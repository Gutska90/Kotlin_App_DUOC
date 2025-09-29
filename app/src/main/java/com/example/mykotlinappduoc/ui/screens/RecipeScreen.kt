package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Time
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlinappduoc.data.Recipe

/**
 * Pantalla de Recetas
 * Diseñada para usuarios de baja habilidad informática
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit,
    onCreateRecipe: () -> Unit,
    onSearch: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Todas") }
    
    val categories = listOf("Todas", "Desayuno", "Almuerzo", "Cena", "Snack")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Recetas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Descubre nuevas recetas saludables",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            IconButton(onClick = onCreateRecipe) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Crear receta"
                )
            }
        }
        
        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { 
                searchQuery = it
                onSearch(it)
            },
            label = { Text("Buscar recetas...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
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
        
        // Lista de recetas
        if (recipes.isNotEmpty()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(recipes.filter { 
                    selectedCategory == "Todas" || it.category == selectedCategory 
                }) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = { onRecipeClick(recipe) }
                    )
                }
            }
        } else {
            EmptyRecipesState()
        }
    }
}

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
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
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = recipe.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = recipe.category,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                
                IconButton(onClick = { /* TODO: Agregar a favoritos */ }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Agregar a favoritos"
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Descripción
            Text(
                text = recipe.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Información de la receta
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeInfoItem(
                    icon = Icons.Default.Time,
                    text = "${recipe.prepTime + recipe.cookTime} min"
                )
                RecipeInfoItem(
                    icon = Icons.Default.Favorite,
                    text = "${recipe.calories} cal"
                )
                RecipeInfoItem(
                    icon = Icons.Default.Add,
                    text = "${recipe.servings} porciones"
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Dificultad
            Text(
                text = "Dificultad: ${recipe.difficulty}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun RecipeInfoItem(
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

@Composable
fun EmptyRecipesState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Sin recetas",
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "No se encontraron recetas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Intenta con otros términos de búsqueda o crea tu primera receta",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
