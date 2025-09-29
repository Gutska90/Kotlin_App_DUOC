package com.example.mykotlinappduoc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.User
import com.example.mykotlinappduoc.data.WeeklyMenu
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
     * Carga todas las recetas públicas
     */
    fun loadRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.getAllRecipes()
                .onSuccess { recipes ->
                    _recipes.value = recipes
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Carga recetas por categoría
     */
    fun loadRecipesByCategory(category: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.getRecipesByCategory(category)
                .onSuccess { recipes ->
                    _recipes.value = recipes
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
                }
            
            _isLoading.value = false
        }
    }
    
    /**
     * Busca recetas
     */
    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            firebaseService.searchRecipes(query)
                .onSuccess { recipes ->
                    _recipes.value = recipes
                }
                .onFailure { exception ->
                    _errorMessage.value = exception.message
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
