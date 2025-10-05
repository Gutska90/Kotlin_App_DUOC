package com.example.mykotlinappduoc.services

import com.example.mykotlinappduoc.data.SampleRecipes
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Servicio para migrar datos de ejemplo a Firestore
 * Se ejecuta una sola vez para poblar la base de datos
 */
class DataMigrationService {
    
    private val firestore = FirebaseFirestore.getInstance()
    private val recipesCollection = firestore.collection("recipes")
    
    /**
     * Migra todas las recetas de ejemplo a Firestore
     * Solo se ejecuta si la colección está vacía
     */
    suspend fun migrateSampleRecipes(): Result<Boolean> {
        return try {
            // Verificar si ya existen recetas
            val existingRecipes = recipesCollection.get().await()
            
            if (existingRecipes.isEmpty) {
                // Migrar todas las recetas de ejemplo
                val allRecipes = SampleRecipes.todasLasRecetas
                
                allRecipes.forEach { recipe ->
                    recipesCollection.add(recipe).await()
                }
                
                Result.success(true)
            } else {
                Result.success(false) // Ya existen recetas
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Verifica si la base de datos está poblada
     */
    suspend fun isDatabasePopulated(): Boolean {
        return try {
            val recipes = recipesCollection.get().await()
            !recipes.isEmpty
        } catch (e: Exception) {
            false
        }
    }
}
