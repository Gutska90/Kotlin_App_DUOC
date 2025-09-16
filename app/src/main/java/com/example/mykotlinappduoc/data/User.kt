package com.example.mykotlinappduoc.data

/**
 * Modelo de datos para representar un usuario de la aplicación
 * Diseñado para personas con discapacidad sensorial visual
 */
data class User(
    val id: Int,
    val username: String,
    val email: String,
    val password: String,
    val fullName: String,
    val isAccessibilityEnabled: Boolean = true
)

/**
 * Clase para manejar la gestión de usuarios
 * Incluye array predefinido de 5 usuarios como se solicita
 */
object UserManager {
    // Array de usuarios predefinidos como se requiere en los requerimientos
    private val predefinedUsers = listOf(
        User(1, "usuario1", "usuario1@email.com", "password123", "María González"),
        User(2, "usuario2", "usuario2@email.com", "password456", "Carlos Rodríguez"),
        User(3, "usuario3", "usuario3@email.com", "password789", "Ana Martínez"),
        User(4, "usuario4", "usuario4@email.com", "password012", "Luis Fernández"),
        User(5, "usuario5", "usuario5@email.com", "password345", "Carmen López")
    )
    
    private val registeredUsers = mutableListOf<User>()
    
    init {
        // Agregar usuarios predefinidos al registro
        registeredUsers.addAll(predefinedUsers)
    }
    
    /**
     * Registra un nuevo usuario
     */
    fun registerUser(user: User): Boolean {
        return if (isUserExists(user.username, user.email)) {
            false
        } else {
            registeredUsers.add(user)
            true
        }
    }
    
    /**
     * Autentica un usuario
     */
    fun authenticateUser(username: String, password: String): User? {
        return registeredUsers.find { 
            (it.username == username || it.email == username) && it.password == password 
        }
    }
    
    /**
     * Verifica si un usuario ya existe
     */
    private fun isUserExists(username: String, email: String): Boolean {
        return registeredUsers.any { it.username == username || it.email == email }
    }
    
    /**
     * Obtiene todos los usuarios registrados
     */
    fun getAllUsers(): List<User> = registeredUsers.toList()
    
    /**
     * Busca un usuario por email para recuperación de contraseña
     */
    fun findUserByEmail(email: String): User? {
        return registeredUsers.find { it.email == email }
    }
}
