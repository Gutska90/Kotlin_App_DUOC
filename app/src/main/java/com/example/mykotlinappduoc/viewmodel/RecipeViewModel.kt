package com.example.mykotlinappduoc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlinappduoc.data.DayMenu
import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.SampleRecipes
import com.example.mykotlinappduoc.data.User
import com.example.mykotlinappduoc.data.WeeklyMenu
import com.example.mykotlinappduoc.services.DataMigrationService
import com.example.mykotlinappduoc.services.FirebaseService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel para manejar el estado de la aplicación de minuta nutricional
 * Diseñado para usuarios de baja habilidad informática
 */
class RecipeViewModel : ViewModel() {
    
    private val firebaseService = FirebaseService()
    private val migrationService = DataMigrationService()
    
    // Estados de la aplicación
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()
    
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()
    
    private val _weeklyMenu = MutableStateFlow<WeeklyMenu?>(null)
    val weeklyMenu: StateFlow<WeeklyMenu?> = _weeklyMenu.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
    
    // ========== AUTENTICACIÓN ==========
    
    /**
     * Registra un nuevo usuario
     */
    fun registerUser(email: String, password: String, name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.registerUser(email, password, name)
                .onSuccess { user ->
                    _currentUser.value = user
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Inicia sesión
     */
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.signIn(email, password)
                .onSuccess { user ->
                    _currentUser.value = user
                    loadUserData()
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Cierra la sesión
     */
    fun signOut() {
        firebaseService.signOut()
        _currentUser.value = null
        _recipes.value = emptyList()
        _weeklyMenu.value = null
    }
    
    // ========== GESTIÓN DE RECETAS ==========
    
    /**
     * Carga todas las recetas públicas desde Firebase
     */
    fun loadRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                // Intentar cargar desde Firebase
                firebaseService.getAllRecipes()
                    .onSuccess { recipes ->
                        if (recipes.isEmpty()) {
                            // Si no hay recetas, migrar las de ejemplo
                            migrateSampleRecipes()
                        } else {
                            _recipes.value = recipes
                        }
                    }
                    .onFailure { exception ->
                        // Si falla Firebase, usar recetas de ejemplo como fallback
                        _recipes.value = SampleRecipes.todasLasRecetas
                        _errorMessage.value = "Error de conexión: ${exception.message}"
                    }
            } catch (e: Exception) {
                // Fallback a recetas de ejemplo
                _recipes.value = SampleRecipes.todasLasRecetas
                _errorMessage.value = "Error inesperado: ${e.message}"
            }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Migra las recetas de ejemplo a Firebase
     */
    private fun migrateSampleRecipes() {
        viewModelScope.launch {
            migrationService.migrateSampleRecipes()
                .onSuccess { migrated ->
                    if (migrated) {
                        // Recargar recetas después de la migración
                        firebaseService.getAllRecipes()
                            .onSuccess { recipes -> _recipes.value = recipes }
                    } else {
                        // Ya existen recetas, cargarlas
                        firebaseService.getAllRecipes()
                            .onSuccess { recipes -> _recipes.value = recipes }
                    }
                }
                .onFailure { exception ->
                    // Si falla la migración, usar recetas locales
                    _recipes.value = SampleRecipes.todasLasRecetas
                    _errorMessage.value = "Error migrando datos: ${exception.message}"
                }
        }
    }
    
    /**
     * Carga recetas por categoría desde Firebase
     */
    fun loadRecipesByCategory(category: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                firebaseService.getRecipesByCategory(category)
                    .onSuccess { recipes ->
                        _recipes.value = recipes
                    }
                    .onFailure { exception ->
                        // Fallback a recetas locales por categoría
                        val filteredRecipes = when (category) {
                            "Desayuno" -> SampleRecipes.desayunos
                            "Almuerzo" -> SampleRecipes.almuerzos
                            "Cena" -> SampleRecipes.cenas
                            "Snack" -> SampleRecipes.snacks
                            else -> SampleRecipes.todasLasRecetas
                        }
                        _recipes.value = filteredRecipes
                        _errorMessage.value = "Error de conexión: ${exception.message}"
                    }
            } catch (e: Exception) {
                // Fallback a recetas locales
                val filteredRecipes = when (category) {
                    "Desayuno" -> SampleRecipes.desayunos
                    "Almuerzo" -> SampleRecipes.almuerzos
                    "Cena" -> SampleRecipes.cenas
                    "Snack" -> SampleRecipes.snacks
                    else -> SampleRecipes.todasLasRecetas
                }
                _recipes.value = filteredRecipes
                _errorMessage.value = "Error inesperado: ${e.message}"
            }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Busca recetas con debounce para optimizar rendimiento
     */
    fun searchRecipes(query: String) {
        viewModelScope.launch {
            // Debounce: esperar 300ms antes de buscar
            kotlinx.coroutines.delay(300)
            
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                if (query.isBlank()) {
                    // Si no hay query, cargar todas las recetas
                    loadRecipes()
                } else {
                    // Buscar en Firebase
                    firebaseService.searchRecipes(query)
                        .onSuccess { recipes ->
                            _recipes.value = recipes
                        }
                        .onFailure { exception ->
                            // Fallback a búsqueda local
                            val searchResults = SampleRecipes.todasLasRecetas.filter { recipe ->
                                recipe.name.contains(query, ignoreCase = true) ||
                                recipe.description.contains(query, ignoreCase = true) ||
                                recipe.ingredients.any { it.contains(query, ignoreCase = true) }
                            }
                            _recipes.value = searchResults
                            _errorMessage.value = "Error de conexión: ${exception.message}"
                        }
                }
            } catch (e: Exception) {
                // Fallback a búsqueda local
                val searchResults = if (query.isBlank()) {
                    SampleRecipes.todasLasRecetas
                } else {
                    SampleRecipes.todasLasRecetas.filter { recipe ->
                        recipe.name.contains(query, ignoreCase = true) ||
                        recipe.description.contains(query, ignoreCase = true) ||
                        recipe.ingredients.any { it.contains(query, ignoreCase = true) }
                    }
                }
                _recipes.value = searchResults
                _errorMessage.value = "Error inesperado: ${e.message}"
            }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Crea una nueva receta
     */
    fun createRecipe(recipe: Recipe) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.createRecipe(recipe)
                .onSuccess { newRecipe ->
                    _recipes.value = _recipes.value + newRecipe
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    // ========== GESTIÓN DE MINUTAS ==========
    
    /**
     * Carga la minuta semanal del usuario
     */
    fun loadWeeklyMenu() {
        val user = _currentUser.value ?: return
        
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.getWeeklyMenuByUser(user.id)
                .onSuccess { weeklyMenu ->
                    _weeklyMenu.value = weeklyMenu
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Crea una nueva minuta semanal
     */
    fun createWeeklyMenu(weeklyMenu: WeeklyMenu) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.createWeeklyMenu(weeklyMenu)
                .onSuccess { newWeeklyMenu ->
                    _weeklyMenu.value = newWeeklyMenu
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Agrega una receta a una comida específica de un día
     */
    fun addRecipeToMeal(day: String, mealType: String, recipe: Recipe) {
        val currentMenu = _weeklyMenu.value
        if (currentMenu == null) {
            // Crear nueva minuta si no existe
            val newWeeklyMenu = WeeklyMenu(
                id = "",
                userId = _currentUser.value?.id ?: "",
                weekStartDate = java.util.Date(),
                days = mutableMapOf()
            )
            _weeklyMenu.value = newWeeklyMenu
            addRecipeToMeal(day, mealType, recipe)
            return
        }
        
        val dayMenu = currentMenu.days[day] ?: DayMenu(
            date = java.util.Date(),
            breakfast = null,
            lunch = null,
            dinner = null,
            snack = null
        )
        
        val updatedDayMenu = when (mealType) {
            "Desayuno" -> dayMenu.copy(breakfast = recipe)
            "Almuerzo" -> dayMenu.copy(lunch = recipe)
            "Cena" -> dayMenu.copy(dinner = recipe)
            "Snack" -> dayMenu.copy(snack = recipe)
            else -> dayMenu
        }
        
        val updatedDays = currentMenu.days.toMutableMap()
        updatedDays[day] = updatedDayMenu
        
        val updatedWeeklyMenu = currentMenu.copy(days = updatedDays)
        _weeklyMenu.value = updatedWeeklyMenu
        
        // TODO: Persistir en Firebase
        // updateWeeklyMenu(updatedWeeklyMenu)
    }
    
    /**
     * Actualiza la minuta semanal
     */
    fun updateWeeklyMenu(weeklyMenu: WeeklyMenu) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.updateWeeklyMenu(weeklyMenu)
                .onSuccess { updatedWeeklyMenu ->
                    _weeklyMenu.value = updatedWeeklyMenu
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    // ========== UTILIDADES ==========
    
    /**
     * Carga todos los datos del usuario
     */
    private fun loadUserData() {
        loadRecipes()
        loadWeeklyMenu()
    }
    
    /**
     * Limpia el mensaje de error
     */
    fun clearError() {
        _errorMessage.value = null
    }
    
    /**
     * Verifica si el usuario está autenticado
     */
    fun isUserAuthenticated(): Boolean {
        return _currentUser.value != null
    }
}
