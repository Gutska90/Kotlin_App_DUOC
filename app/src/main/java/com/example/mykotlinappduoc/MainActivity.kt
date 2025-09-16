package com.example.mykotlinappduoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.mykotlinappduoc.ui.screens.*
import com.example.mykotlinappduoc.ui.theme.MyKotlinAppDuocTheme

/**
 * Actividad principal de la aplicación de accesibilidad para personas con discapacidad sensorial visual
 * Implementa navegación entre pantallas usando Jetpack Compose y Kotlin
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyKotlinAppDuocTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/**
 * Componente de navegación principal de la aplicación
 * Maneja el estado de navegación entre las diferentes pantallas
 */
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("login") }
    var loggedInUser by remember { mutableStateOf("") }

    when (currentScreen) {
        "login" -> {
            LoginScreen(
                onLoginSuccess = { userName ->
                    loggedInUser = userName
                    currentScreen = "main"
                },
                onNavigateToRegister = {
                    currentScreen = "register"
                },
                onNavigateToForgotPassword = {
                    currentScreen = "forgot_password"
                }
            )
        }
        "register" -> {
            RegisterScreen(
                onRegisterSuccess = {
                    currentScreen = "login"
                },
                onNavigateToLogin = {
                    currentScreen = "login"
                }
            )
        }
        "forgot_password" -> {
            ForgotPasswordScreen(
                onNavigateToLogin = {
                    currentScreen = "login"
                }
            )
        }
        "main" -> {
            MainAppScreen(
                userName = loggedInUser,
                onLogout = {
                    loggedInUser = ""
                    currentScreen = "login"
                }
            )
        }
    }
}