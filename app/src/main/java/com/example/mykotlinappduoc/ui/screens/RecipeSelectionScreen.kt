package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlinappduoc.data.Recipe

/**
 * Pantalla para seleccionar recetas y asignarlas a comidas específicas
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeSelectionScreen(
    recipes: List<Recipe>,
    selectedMealType: String,
    selectedDay: String,
    onRecipeSelected: (Recipe) -> Unit,
    onBack: () -> Unit,
    onSearch: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(selectedMealType) }
    
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isTablet = screenWidth >= 600.dp
    
    val categories = listOf("Desayuno", "Almuerzo", "Cena", "Snack")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(if (isTablet) 24.dp else 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Seleccionar Receta",
                    fontSize = if (isTablet) 28.sp else 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$selectedDay - $selectedMealType",
                    fontSize = if (isTablet) 18.sp else 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        // Barra de búsqueda con debounce
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { 
                searchQuery = it
            },
            label = { Text("Buscar recetas...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        
        // Filtros por categoría
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    onClick = { selectedCategory = category },
                    label = { Text(category) },
                    selected = selectedCategory == category
                )
            }
        }
        
        // Lista de recetas con memoización y debounce
        val filteredRecipes = remember(recipes, selectedCategory, searchQuery) {
            recipes.filter { recipe ->
                val matchesCategory = selectedCategory == "Todas" || recipe.category == selectedCategory
                val matchesSearch = searchQuery.isEmpty() || 
                    recipe.name.contains(searchQuery, ignoreCase = true) ||
                    recipe.description.contains(searchQuery, ignoreCase = true)
                matchesCategory && matchesSearch
            }
        }
        
        // Debounce para búsqueda
        LaunchedEffect(searchQuery) {
            kotlinx.coroutines.delay(300)
            onSearch(searchQuery)
        }
        
        if (filteredRecipes.isNotEmpty()) {
            if (isTablet) {
                // Layout de grid para tablets
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = filteredRecipes.chunked(2),
                        key = { rowRecipes -> rowRecipes.joinToString { it.id } }
                    ) { rowRecipes ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            rowRecipes.forEach { recipe ->
                                RecipeSelectionCard(
                                    recipe = recipe,
                                    onClick = { onRecipeSelected(recipe) },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            // Espacio vacío si hay número impar de recetas
                            if (rowRecipes.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            } else {
                // Layout de lista para móviles
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = filteredRecipes,
                        key = { recipe -> recipe.id }
                    ) { recipe ->
                        RecipeSelectionCard(
                            recipe = recipe,
                            onClick = { onRecipeSelected(recipe) }
                        )
                    }
                }
            }
        } else {
            // Estado vacío
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No se encontraron recetas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Intenta con otros términos de búsqueda",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeSelectionCard(
    recipe: Recipe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header de la receta
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = recipe.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                
                Button(
                    onClick = onClick,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Agregar")
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Descripción
            Text(
                text = recipe.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Información de la receta
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeSelectionInfoItem(
                    icon = Icons.Default.Check,
                    text = "${recipe.prepTime + recipe.cookTime} min"
                )
                
                RecipeSelectionInfoItem(
                    icon = Icons.Default.Check,
                    text = "${recipe.servings} porciones"
                )
                
                RecipeSelectionInfoItem(
                    icon = Icons.Default.Check,
                    text = "${recipe.calories} cal"
                )
            }
        }
    }
}

@Composable
fun RecipeSelectionInfoItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
