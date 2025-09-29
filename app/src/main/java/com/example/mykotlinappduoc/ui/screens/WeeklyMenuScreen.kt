package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onCreateMenu: () -> Unit
) {
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
            WeeklyMenuContent(weeklyMenu = weeklyMenu)
        } else {
            // Mostrar estado vacío
            EmptyWeeklyMenuState(onCreateMenu = onCreateMenu)
        }
    }
}

@Composable
fun WeeklyMenuContent(weeklyMenu: WeeklyMenu) {
    val daysOfWeek = listOf(
        "Lunes" to "Lun",
        "Martes" to "Mar", 
        "Miércoles" to "Mié",
        "Jueves" to "Jue",
        "Viernes" to "Vie",
        "Sábado" to "Sáb",
        "Domingo" to "Dom"
    )
    
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(daysOfWeek) { (dayName, dayShort) ->
            val dayMenu = weeklyMenu.days[dayName]
            DayMenuCard(
                dayName = dayName,
                dayShort = dayShort,
                dayMenu = dayMenu
            )
        }
    }
}

@Composable
fun DayMenuCard(
    dayName: String,
    dayShort: String,
    dayMenu: DayMenu?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
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
            if (dayMenu != null) {
                MealItem(
                    title = "Desayuno",
                    recipe = dayMenu.breakfast,
                    icon = Icons.Default.Restaurant
                )
                MealItem(
                    title = "Almuerzo", 
                    recipe = dayMenu.lunch,
                    icon = Icons.Default.Restaurant
                )
                MealItem(
                    title = "Cena",
                    recipe = dayMenu.dinner,
                    icon = Icons.Default.Restaurant
                )
                MealItem(
                    title = "Snack",
                    recipe = dayMenu.snack,
                    icon = Icons.Default.Restaurant
                )
            } else {
                Text(
                    text = "No hay comidas planificadas",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun MealItem(
    title: String,
    recipe: Recipe?,
    icon: androidx.compose.ui.graphics.vector.ImageVector
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
        
        Text(
            text = recipe?.name ?: "Sin receta",
            fontSize = 14.sp,
            color = if (recipe != null) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
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
            imageVector = Icons.Default.CalendarToday,
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
