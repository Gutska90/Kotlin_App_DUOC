package com.example.mykotlinappduoc.data

import java.util.Date

/**
 * Modelo de datos para representar una receta nutricional
 * Diseñado para usuarios de baja habilidad informática
 */
data class Recipe(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val ingredients: List<String> = emptyList(),
    val instructions: List<String> = emptyList(),
    val prepTime: Int = 0, // en minutos
    val cookTime: Int = 0, // en minutos
    val servings: Int = 1,
    val calories: Int = 0,
    val category: String = "", // Desayuno, Almuerzo, Cena, Snack
    val difficulty: String = "Fácil", // Fácil, Medio, Difícil
    val imageUrl: String = "",
    val createdBy: String = "", // ID del usuario que creó la receta
    val createdAt: Date = Date(),
    val isPublic: Boolean = true
)

/**
 * Modelo de datos para representar una minuta semanal
 */
data class WeeklyMenu(
    val id: String = "",
    val weekStartDate: Date = Date(),
    val userId: String = "",
    val days: Map<String, DayMenu> = emptyMap(), // Lunes, Martes, etc.
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

/**
 * Modelo de datos para representar el menú de un día
 */
data class DayMenu(
    val date: Date = Date(),
    val breakfast: Recipe? = null,
    val lunch: Recipe? = null,
    val dinner: Recipe? = null,
    val snack: Recipe? = null
)

/**
 * Modelo de datos para representar un usuario de la aplicación
 */
data class User(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val profileImageUrl: String = "",
    val preferences: UserPreferences = UserPreferences(),
    val createdAt: Date = Date(),
    val lastLoginAt: Date = Date()
)

/**
 * Preferencias del usuario para personalizar la experiencia
 */
data class UserPreferences(
    val dietaryRestrictions: List<String> = emptyList(), // Vegetariano, Vegano, Sin gluten, etc.
    val allergies: List<String> = emptyList(),
    val favoriteCategories: List<String> = emptyList(),
    val skillLevel: String = "Principiante", // Principiante, Intermedio, Avanzado
    val language: String = "es"
)
