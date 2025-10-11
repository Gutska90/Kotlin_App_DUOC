package com.example.mykotlinappduoc.data

import java.util.Date

/**
 * Modelo de datos para el historial de acciones del usuario
 * Guarda las solicitudes y respuestas generadas
 */
data class ActionHistory(
    val id: String = "",
    val userId: String = "",
    val actionType: String = "", // "Escribir" o "Hablar"
    val input: String = "", // Texto ingresado por el usuario
    val output: String = "", // Resultado generado
    val timestamp: Date = Date(),
    val wasSuccessful: Boolean = true
)

/**
 * Servicio para gestionar el historial de acciones
 */
class ActionHistoryManager {
    private val history = mutableListOf<ActionHistory>()
    
    /**
     * Guarda una acción en el historial
     */
    fun saveAction(action: ActionHistory) {
        history.add(action)
    }
    
    /**
     * Obtiene el historial completo
     */
    fun getHistory(): List<ActionHistory> = history.toList()
    
    /**
     * Obtiene el historial de un usuario específico
     */
    fun getUserHistory(userId: String): List<ActionHistory> {
        return history.filter { it.userId == userId }
    }
    
    /**
     * Limpia el historial
     */
    fun clearHistory() {
        history.clear()
    }
    
    /**
     * Obtiene las últimas N acciones
     */
    fun getRecentActions(count: Int): List<ActionHistory> {
        return history.takeLast(count)
    }
}

