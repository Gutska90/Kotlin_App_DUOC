package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlinappduoc.data.DayMenu
import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.WeeklyMenu
import java.text.SimpleDateFormat
import java.util.*

/**
 * Pantalla de Minuta Semanal
 * Diseñada para usuarios de baja habilidad informática
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyMenuScreen(
    weeklyMenu: WeeklyMenu?,
    onEditMenu: () -> Unit,
    onCreateMenu: () -> Unit,
    onAddRecipe: (String, String) -> Unit = { _, _ -> } // day, mealType
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isTablet = screenWidth >= 600.dp
    
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Mi Minuta Semanal",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Planifica tus comidas de la semana",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            IconButton(onClick = if (weeklyMenu != null) onEditMenu else onCreateMenu) {
                Icon(
                    imageVector = if (weeklyMenu != null) Icons.Default.Edit else Icons.Default.Add,
                    contentDescription = if (weeklyMenu != null) "Editar minuta" else "Crear minuta"
                )
            }
        }
        
        if (weeklyMenu != null) {
            // Mostrar minuta existente
            WeeklyMenuContent(
                weeklyMenu = weeklyMenu, 
                isTablet = isTablet,
                onAddRecipe = onAddRecipe
            )
        } else {
            // Mostrar estado vacío
            EmptyWeeklyMenuState(onCreateMenu = onCreateMenu)
        }
    }
}

@Composable
fun WeeklyMenuContent(
    weeklyMenu: WeeklyMenu, 
    isTablet: Boolean = false,
    onAddRecipe: (String, String) -> Unit = { _, _ -> }
) {
    val daysOfWeek = listOf(
        "Lunes" to "Lun",
        "Martes" to "Mar", 
        "Miércoles" to "Mié",
        "Jueves" to "Jue",
        "Viernes" to "Vie",
        "Sábado" to "Sáb",
        "Domingo" to "Dom"
    )
    
    if (isTablet) {
        // Layout de grid para tablets
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = daysOfWeek.chunked(2),
                key = { rowDays -> rowDays.joinToString { it.first } }
            ) { rowDays ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowDays.forEach { (dayName, dayShort) ->
                        val dayMenu = weeklyMenu.days[dayName]
                        DayMenuCard(
                            dayName = dayName,
                            dayShort = dayShort,
                            dayMenu = dayMenu,
                            modifier = Modifier.weight(1f),
                            onAddRecipe = onAddRecipe
                        )
                    }
                    // Espacio vacío si hay número impar de días
                    if (rowDays.size == 1) {
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
                items = daysOfWeek,
                key = { (dayName, _) -> dayName }
            ) { (dayName, dayShort) ->
                val dayMenu = weeklyMenu.days[dayName]
                DayMenuCard(
                    dayName = dayName,
                    dayShort = dayShort,
                    dayMenu = dayMenu,
                    onAddRecipe = onAddRecipe
                )
            }
        }
    }
}

@Composable
fun DayMenuCard(
    dayName: String,
    dayShort: String,
    dayMenu: DayMenu?,
    modifier: Modifier = Modifier,
    onAddRecipe: (String, String) -> Unit = { _, _ -> }
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header del día
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dayName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = dayShort,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Comidas del día
            val meals = listOf(
                "Desayuno" to (dayMenu?.breakfast),
                "Almuerzo" to (dayMenu?.lunch),
                "Cena" to (dayMenu?.dinner),
                "Snack" to (dayMenu?.snack)
            )
            
            meals.forEach { (mealName, recipe) ->
                MealItem(
                    title = mealName,
                    recipe = recipe,
                    icon = Icons.Default.Info,
                    onAddRecipe = { onAddRecipe(dayName, mealName) }
                )
            }
        }
    }
}

@Composable
fun MealItem(
    title: String,
    recipe: Recipe?,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onAddRecipe: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        
        if (recipe != null) {
            Text(
                text = recipe.name,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        } else {
            TextButton(
                onClick = onAddRecipe,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Agregar receta",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Agregar",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun EmptyWeeklyMenuState(onCreateMenu: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Minuta vacía",
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "No tienes una minuta semanal",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Crea tu primera minuta semanal para planificar tus comidas y mantener una alimentación saludable",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = onCreateMenu,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Crear minuta",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Crear Minuta Semanal")
        }
    }
}
