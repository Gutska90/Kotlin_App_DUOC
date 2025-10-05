package com.example.mykotlinappduoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mykotlinappduoc.ui.screens.*
import com.example.mykotlinappduoc.data.Recipe
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
    var showWrite by remember { mutableStateOf(false) }
    var showSpeak by remember { mutableStateOf(false) }
    var showRecipeSelection by remember { mutableStateOf(false) }
    var selectedDay by remember { mutableStateOf("") }
    var selectedMealType by remember { mutableStateOf("") }
    var showRecipeDetail by remember { mutableStateOf(false) }
    var selectedRecipe by remember { mutableStateOf<Recipe?>(null) }
    
    val currentUser by viewModel.currentUser.collectAsState()
    val recipes by viewModel.recipes.collectAsState()
    val weeklyMenu by viewModel.weeklyMenu.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

            // Observar cambios en el usuario autenticado
            LaunchedEffect(currentUser) {
                if (currentUser != null) {
                    currentScreen = "main"
                    // Cargar recetas solo si no están cargadas
                    if (recipes.isEmpty()) {
                        viewModel.loadRecipes()
                    }
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
                            icon = { Icon(Icons.Default.Star, contentDescription = "Recetas") },
                            label = { Text("Recetas") },
                            selected = selectedTab == 0,
                            onClick = { selectedTab = 0 }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Default.DateRange, contentDescription = "Minuta") },
                            label = { Text("Minuta") },
                            selected = selectedTab == 1,
                            onClick = { selectedTab = 1 }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Default.Phone, contentDescription = "Dispositivos") },
                            label = { Text("Dispositivos") },
                            selected = selectedTab == 2,
                            onClick = { selectedTab = 2 }
                        )
                    }
                }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    when (selectedTab) {
                        0 -> {
                            RecipeScreen(
                                recipes = recipes,
                                onRecipeClick = { recipe ->
                                    selectedRecipe = recipe
                                    showRecipeDetail = true
                                },
                                onCreateRecipe = { /* TODO: Navegar a crear receta */ },
                                onSearch = { query -> viewModel.searchRecipes(query) }
                            )
                        }
                                1 -> {
                                    WeeklyMenuScreen(
                                        weeklyMenu = weeklyMenu,
                                        onEditMenu = { /* TODO: Navegar a editar minuta */ },
                                        onCreateMenu = { /* TODO: Navegar a crear minuta */ },
                                        onAddRecipe = { day, mealType ->
                                            selectedDay = day
                                            selectedMealType = mealType
                                            showRecipeSelection = true
                                        }
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
    
    // Modales simples para Escribir/Hablar
    if (showWrite) {
        AlertDialog(
            onDismissRequest = { showWrite = false },
            confirmButton = {},
            title = { Text("Escribir") },
            text = {
                WriteScreen(onSave = { /* podría persistir */ showWrite = false })
            }
        )
    }
    if (showSpeak) {
        AlertDialog(
            onDismissRequest = { showSpeak = false },
            confirmButton = {},
            title = { Text("Hablar") },
            text = {
                SpeakScreen(onResult = { /* usar texto */ showSpeak = false })
            }
        )
    }

    if (showRecipeSelection) {
        AlertDialog(
            onDismissRequest = { showRecipeSelection = false },
            confirmButton = {},
            title = { Text("Seleccionar Receta") },
            text = {
                RecipeSelectionScreen(
                    recipes = recipes,
                    selectedMealType = selectedMealType,
                    selectedDay = selectedDay,
                    onRecipeSelected = { recipe ->
                        viewModel.addRecipeToMeal(selectedDay, selectedMealType, recipe)
                        showRecipeSelection = false
                    },
                    onBack = { showRecipeSelection = false },
                    onSearch = { query -> viewModel.searchRecipes(query) }
                )
            }
        )
    }

    if (showRecipeDetail && selectedRecipe != null) {
        AlertDialog(
            onDismissRequest = { 
                showRecipeDetail = false
                selectedRecipe = null
            },
            confirmButton = {},
            title = { Text("Detalle de Receta") },
            text = {
                RecipeDetailScreen(
                    recipe = selectedRecipe!!,
                    onBack = { 
                        showRecipeDetail = false
                        selectedRecipe = null
                    },
                    onAddToMenu = { recipe ->
                        // TODO: Implementar agregar a menú desde detalle
                        showRecipeDetail = false
                        selectedRecipe = null
                    }
                )
            }
        )
    }

    // Mostrar loading y errores
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
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