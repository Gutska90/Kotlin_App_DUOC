package com.example.mykotlinappduoc.services

import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.User
import com.example.mykotlinappduoc.data.WeeklyMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import java.util.Date

/**
 * Servicio para manejar todas las operaciones con Firebase
 * Incluye autenticación, CRUD de usuarios, recetas y minutas
 */
class FirebaseService {
    
    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()
    
    // Colecciones de Firestore
    private val usersCollection = firestore.collection("users")
    private val recipesCollection = firestore.collection("recipes")
    private val weeklyMenusCollection = firestore.collection("weekly_menus")
    
    // ========== AUTENTICACIÓN ==========
    
    /**
     * Registra un nuevo usuario con email y contraseña
     */
    suspend fun registerUser(email: String, password: String, name: String): Result<User> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val user = User(
                id = authResult.user?.uid ?: "",
                email = email,
                name = name,
                createdAt = Date(),
                lastLoginAt = Date()
            )
            
            // Guardar usuario en Firestore
            usersCollection.document(user.id).set(user).await()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Inicia sesión con email y contraseña
     */
    suspend fun signIn(email: String, password: String): Result<User> {
        return try {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid ?: throw Exception("Error al obtener ID de usuario")
            
            // Obtener datos del usuario desde Firestore
            val userDoc = usersCollection.document(userId).get().await()
            val user = userDoc.toObject(User::class.java) ?: throw Exception("Usuario no encontrado")
            
            // Actualizar último login
            usersCollection.document(userId).update("lastLoginAt", Date()).await()
            
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Cierra la sesión del usuario actual
     */
    fun signOut() {
        auth.signOut()
    }
    
    /**
     * Obtiene el usuario actual autenticado
     */
    fun getCurrentUser(): User? {
        val firebaseUser = auth.currentUser
        return if (firebaseUser != null) {
            User(
                id = firebaseUser.uid,
                email = firebaseUser.email ?: "",
                name = firebaseUser.displayName ?: ""
            )
        } else null
    }
    
    // ========== CRUD DE USUARIOS ==========
    
    /**
     * Obtiene un usuario por ID
     */
    suspend fun getUserById(userId: String): Result<User> {
        return try {
            val userDoc = usersCollection.document(userId).get().await()
            val user = userDoc.toObject(User::class.java)
            if (user != null) {
                Result.success(user)
            } else {
                Result.failure(Exception("Usuario no encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Actualiza los datos de un usuario
     */
    suspend fun updateUser(user: User): Result<User> {
        return try {
            usersCollection.document(user.id).set(user).await()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Elimina un usuario
     */
    suspend fun deleteUser(userId: String): Result<Boolean> {
        return try {
            usersCollection.document(userId).delete().await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // ========== CRUD DE RECETAS ==========
    
    /**
     * Crea una nueva receta
     */
    suspend fun createRecipe(recipe: Recipe): Result<Recipe> {
        return try {
            val docRef = recipesCollection.add(recipe).await()
            val newRecipe = recipe.copy(id = docRef.id)
            docRef.set(newRecipe).await()
            Result.success(newRecipe)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Obtiene todas las recetas públicas
     */
    suspend fun getAllRecipes(): Result<List<Recipe>> {
        return try {
            val querySnapshot = recipesCollection
                .whereEqualTo("isPublic", true)
                .orderBy("name", Query.Direction.ASCENDING)
                .get()
                .await()
            
            val recipes = querySnapshot.documents.mapNotNull { it.toObject(Recipe::class.java) }
            Result.success(recipes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Obtiene recetas por categoría
     */
    suspend fun getRecipesByCategory(category: String): Result<List<Recipe>> {
        return try {
            val querySnapshot = recipesCollection
                .whereEqualTo("category", category)
                .whereEqualTo("isPublic", true)
                .get()
                .await()
            
            val recipes = querySnapshot.documents.mapNotNull { it.toObject(Recipe::class.java) }
            Result.success(recipes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Obtiene una receta por ID
     */
    suspend fun getRecipeById(recipeId: String): Result<Recipe> {
        return try {
            val recipeDoc = recipesCollection.document(recipeId).get().await()
            val recipe = recipeDoc.toObject(Recipe::class.java)
            if (recipe != null) {
                Result.success(recipe)
            } else {
                Result.failure(Exception("Receta no encontrada"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Actualiza una receta
     */
    suspend fun updateRecipe(recipe: Recipe): Result<Recipe> {
        return try {
            recipesCollection.document(recipe.id).set(recipe).await()
            Result.success(recipe)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Elimina una receta
     */
    suspend fun deleteRecipe(recipeId: String): Result<Boolean> {
        return try {
            recipesCollection.document(recipeId).delete().await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // ========== CRUD DE MINUTAS SEMANALES ==========
    
    /**
     * Crea una nueva minuta semanal
     */
    suspend fun createWeeklyMenu(weeklyMenu: WeeklyMenu): Result<WeeklyMenu> {
        return try {
            val docRef = weeklyMenusCollection.add(weeklyMenu).await()
            val newWeeklyMenu = weeklyMenu.copy(id = docRef.id)
            docRef.set(newWeeklyMenu).await()
            Result.success(newWeeklyMenu)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Obtiene la minuta semanal de un usuario
     */
    suspend fun getWeeklyMenuByUser(userId: String): Result<WeeklyMenu?> {
        return try {
            val querySnapshot = weeklyMenusCollection
                .whereEqualTo("userId", userId)
                .orderBy("weekStartDate", Query.Direction.DESCENDING)
                .limit(1)
                .get()
                .await()
            
            val weeklyMenu = if (querySnapshot.documents.isNotEmpty()) {
                querySnapshot.documents.first().toObject(WeeklyMenu::class.java)
            } else null
            
            Result.success(weeklyMenu)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Actualiza una minuta semanal
     */
    suspend fun updateWeeklyMenu(weeklyMenu: WeeklyMenu): Result<WeeklyMenu> {
        return try {
            weeklyMenusCollection.document(weeklyMenu.id).set(weeklyMenu).await()
            Result.success(weeklyMenu)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Elimina una minuta semanal
     */
    suspend fun deleteWeeklyMenu(weeklyMenuId: String): Result<Boolean> {
        return try {
            weeklyMenusCollection.document(weeklyMenuId).delete().await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // ========== BÚSQUEDA DE DISPOSITIVOS ==========
    
    /**
     * Busca recetas por nombre o ingredientes
     */
    suspend fun searchRecipes(query: String): Result<List<Recipe>> {
        return try {
            val querySnapshot = recipesCollection
                .whereEqualTo("isPublic", true)
                .get()
                .await()
            
            val recipes = querySnapshot.documents.mapNotNull { it.toObject(Recipe::class.java) }
                .filter { recipe ->
                    recipe.name.contains(query, ignoreCase = true) ||
                    recipe.ingredients.any { it.contains(query, ignoreCase = true) } ||
                    recipe.description.contains(query, ignoreCase = true)
                }
            
            Result.success(recipes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
