package com.example.mykotlinappduoc

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * Clase de aplicación para inicializar Firebase
 */
class FirebaseApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Inicializar Firebase
        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseApp.initializeApp(this)
        }
    }
}
