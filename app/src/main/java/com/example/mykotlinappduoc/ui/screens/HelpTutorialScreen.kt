package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Pantalla de ayuda y tutorial de uso
 * Diseñada para usuarios con discapacidad sensorial visual
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpTutorialScreen(
    onBack: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val isTablet = remember(configuration) {
        configuration.screenWidthDp >= 600
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(if (isTablet) 24.dp else 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }
            
            Column(modifier = Modifier.weight(1f).padding(horizontal = 8.dp)) {
                Text(
                    text = "Tutorial de Uso",
                    fontSize = if (isTablet) 26.sp else 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Guía de la aplicación",
                    fontSize = if (isTablet) 16.sp else 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Introducción
            item {
                TutorialCard(
                    title = "¿Qué es esta aplicación?",
                    description = "Esta aplicación de accesibilidad está diseñada específicamente para personas con discapacidad sensorial visual. Te ayuda a comunicarte escribiendo y leyendo textos, facilitando tu integración al mundo digital.",
                    icon = Icons.Default.Info
                )
            }
            
            // Cómo usar - Login
            item {
                TutorialStepCard(
                    stepNumber = 1,
                    title = "Iniciar Sesión",
                    steps = listOf(
                        "Abre la aplicación",
                        "Ingresa tu usuario o email",
                        "Ingresa tu contraseña",
                        "Haz clic en 'Iniciar Sesión'",
                        "Verás un mensaje de bienvenida con tu nombre"
                    )
                )
            }
            
            // Cómo usar - Menú Principal
            item {
                TutorialStepCard(
                    stepNumber = 2,
                    title = "Menú Principal",
                    steps = listOf(
                        "Después de iniciar sesión, verás el menú principal",
                        "Hay 3 pestañas: Recetas, Minuta y Dispositivos",
                        "Usa los botones en la parte inferior para navegar"
                    )
                )
            }
            
            // Función Escribir
            item {
                TutorialStepCard(
                    stepNumber = 3,
                    title = "Función Escribir (Texto a Voz)",
                    steps = listOf(
                        "Escribe cualquier texto en el campo",
                        "Haz clic en 'Leer' para escuchar el texto",
                        "Haz clic en 'Guardar' para guardar el texto",
                        "La aplicación leerá el texto en voz alta",
                        "El texto se guarda en tu historial"
                    )
                )
            }
            
            // Función Hablar
            item {
                TutorialStepCard(
                    stepNumber = 4,
                    title = "Función Hablar (Voz a Texto)",
                    steps = listOf(
                        "Haz clic en 'Escuchar'",
                        "Habla claramente cuando aparezca el micrófono",
                        "El texto reconocido aparecerá en pantalla",
                        "Haz clic en 'Usar texto' para guardarlo",
                        "La conversión se guarda en tu historial"
                    )
                )
            }
            
            // Recetas
            item {
                TutorialStepCard(
                    stepNumber = 5,
                    title = "Explorar Recetas",
                    steps = listOf(
                        "Ve a la pestaña 'Recetas'",
                        "Usa la barra de búsqueda para encontrar recetas",
                        "Filtra por categoría (Desayuno, Almuerzo, Cena, Snack)",
                        "Haz clic en una receta para ver los detalles",
                        "Lee ingredientes e instrucciones completas"
                    )
                )
            }
            
            // Minuta Semanal
            item {
                TutorialStepCard(
                    stepNumber = 6,
                    title = "Crear Minuta Semanal",
                    steps = listOf(
                        "Ve a la pestaña 'Minuta'",
                        "Verás los 7 días de la semana",
                        "Cada día tiene 4 comidas: Desayuno, Almuerzo, Cena, Snack",
                        "Haz clic en 'Agregar' en cualquier comida",
                        "Selecciona una receta de la lista",
                        "La receta se asignará automáticamente"
                    )
                )
            }
            
            // Consejos
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "💡 Consejos de Uso",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                        
                        listOf(
                            "Habla despacio y claro para mejor reconocimiento de voz",
                            "Asegúrate de tener conexión a internet para guardar datos",
                            "Las funciones de accesibilidad funcionan mejor con auriculares",
                            "Puedes usar la aplicación en modo offline, pero no se guardarán los cambios",
                            "Todas las recetas y minutas se sincronizan automáticamente"
                        ).forEach { tip ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Text(
                                    text = "•",
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Text(
                                    text = tip,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp
                                )
                            }
                        }
                    }
                }
            }
            
            // Soporte
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "🆘 ¿Necesitas Ayuda?",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Si tienes problemas con la aplicación, contacta a soporte técnico o consulta la documentación completa.",
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TutorialCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
fun TutorialStepCard(
    stepNumber: Int,
    title: String,
    steps: List<String>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header con número de paso
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.size(32.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$stepNumber",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            // Lista de pasos
            steps.forEach { step ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 8.dp, top = 2.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = step,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

