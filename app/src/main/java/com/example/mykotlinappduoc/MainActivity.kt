package com.example.mykotlinappduoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mykotlinappduoc.ui.screens.*
import com.example.mykotlinappduoc.ui.theme.MyKotlinAppDuocTheme
import com.example.mykotlinappduoc.viewmodel.RecipeViewModel

/**
 * Actividad principal de la aplicación de minuta nutricional
 * Implementa navegación entre pantallas usando Jetpack Compose y Kotlin
 * Integrada con Firebase para persistencia de datos
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val viewModel: RecipeViewModel = viewModel()
    var currentScreen by remember { mutableStateOf("login") }
    var selectedTab by remember { mutableStateOf(0) }
    
    val currentUser by viewModel.currentUser.collectAsState()
    val recipes by viewModel.recipes.collectAsState()
    val weeklyMenu by viewModel.weeklyMenu.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    // Observar cambios en el usuario autenticado
    LaunchedEffect(currentUser) {
        if (currentUser != null) {
            currentScreen = "main"
        } else {
            currentScreen = "login"
        }
    }

    when (currentScreen) {
        "login" -> {
            LoginScreen(
                onLoginSuccess = { 
                    currentScreen = "main"
                },
                onNavigateToRegister = {
                    currentScreen = "register"
                },
                onNavigateToForgotPassword = {
                    currentScreen = "forgot_password"
                },
                viewModel = viewModel
            )
        }
        "register" -> {
            RegisterScreen(
                onRegisterSuccess = {
                    currentScreen = "login"
                },
                onNavigateToLogin = {
                    currentScreen = "login"
                },
                viewModel = viewModel
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
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        NavigationBarItem(
                            icon = { Icon(Icons.Default.Restaurant, contentDescription = "Recetas") },
                            label = { Text("Recetas") },
                            selected = selectedTab == 0,
                            onClick = { selectedTab = 0 }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Default.CalendarToday, contentDescription = "Minuta") },
                            label = { Text("Minuta") },
                            selected = selectedTab == 1,
                            onClick = { selectedTab = 1 }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Default.DeviceHub, contentDescription = "Dispositivos") },
                            label = { Text("Dispositivos") },
                            selected = selectedTab == 2,
                            onClick = { selectedTab = 2 }
                        )
                    }
                }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    when (selectedTab) {
                        0 -> {
                            RecipeScreen(
                                recipes = recipes,
                                onRecipeClick = { /* TODO: Navegar a detalle de receta */ },
                                onCreateRecipe = { /* TODO: Navegar a crear receta */ },
                                onSearch = { query -> viewModel.searchRecipes(query) }
                            )
                        }
                        1 -> {
                            WeeklyMenuScreen(
                                weeklyMenu = weeklyMenu,
                                onEditMenu = { /* TODO: Navegar a editar minuta */ },
                                onCreateMenu = { /* TODO: Navegar a crear minuta */ }
                            )
                        }
                        2 -> {
                            SearchDeviceScreen(
                                onSearchDevices = { /* TODO: Implementar búsqueda de dispositivos */ },
                                onConnectDevice = { deviceName -> /* TODO: Implementar conexión */ }
                            )
                        }
                    }
                }
            }
        }
    }
    
    // Mostrar loading y errores
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    
    errorMessage?.let { message ->
        LaunchedEffect(message) {
            // TODO: Mostrar snackbar con el error
            viewModel.clearError()
        }
    }
}