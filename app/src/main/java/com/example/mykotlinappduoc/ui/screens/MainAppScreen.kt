package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Pantalla principal de la aplicación con funcionalidades de accesibilidad
 * Diseñada específicamente para personas con discapacidad sensorial visual
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(
    userName: String,
    onLogout: () -> Unit
) {
    var textToSpeak by remember { mutableStateOf("") }
    var writtenText by remember { mutableStateOf("") }
    var selectedFeature by remember { mutableStateOf("") }
    var accessibilityEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header con información del usuario
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Bienvenido, $userName",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Aplicación de Accesibilidad Visual",
                        fontSize = 14.sp
                    )
                }
                
                IconButton(onClick = onLogout) {
                    Icon(
                        Icons.Default.ExitToApp,
                        contentDescription = "Cerrar sesión"
                    )
                }
            }
        }

        // Funcionalidades principales
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Funcionalidades de Accesibilidad",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Sección de lectura de texto
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Lectura de texto",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = "Lectura de Texto",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        
                        Text(
                            text = "Escriba el texto que desea que la aplicación lea en voz alta",
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        OutlinedTextField(
                            value = textToSpeak,
                            onValueChange = { textToSpeak = it },
                            label = { Text("Texto para leer") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            maxLines = 3,
                            supportingText = { Text("Máximo 200 caracteres") }
                        )
                        
                        Button(
                            onClick = { 
                                // Simular lectura de texto
                                selectedFeature = "Leyendo: $textToSpeak"
                            },
                            modifier = Modifier.fillMaxWidth(),
                            enabled = textToSpeak.isNotBlank()
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Reproducir",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text("Leer Texto")
                        }
                    }
                }
            }

            // Sección de escritura asistida
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "Escritura asistida",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = "Escritura Asistida",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        
                        Text(
                            text = "Escriba texto con asistencia de voz y corrección automática",
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        OutlinedTextField(
                            value = writtenText,
                            onValueChange = { writtenText = it },
                            label = { Text("Texto escrito") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            maxLines = 3,
                            supportingText = { Text("El texto se guardará automáticamente") }
                        )
                        
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { 
                                    selectedFeature = "Guardando texto escrito"
                                },
                                modifier = Modifier.weight(1f),
                                enabled = writtenText.isNotBlank()
                            ) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = "Guardar",
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                Text("Guardar")
                            }
                            
                            Button(
                                onClick = { 
                                    writtenText = ""
                                    selectedFeature = "Texto borrado"
                                },
                                modifier = Modifier.weight(1f),
                                enabled = writtenText.isNotBlank()
                            ) {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Borrar",
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                Text("Borrar")
                            }
                        }
                    }
                }
            }

            // Sección de configuración de accesibilidad
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "Configuración de accesibilidad",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = "Configuración de Accesibilidad",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Funciones de accesibilidad habilitadas")
                            Switch(
                                checked = accessibilityEnabled,
                                onCheckedChange = { accessibilityEnabled = it }
                            )
                        }
                        
                        if (accessibilityEnabled) {
                            Text(
                                text = "✓ Lectura de texto habilitada\n" +
                                      "✓ Escritura asistida habilitada\n" +
                                      "✓ Navegación por voz habilitada\n" +
                                      "✓ Contraste alto habilitado",
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }

            // Estado actual
            if (selectedFeature.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Info,
                                contentDescription = "Información",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = selectedFeature,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Información de usuarios registrados
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Usuarios Registrados en el Sistema",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "La aplicación cuenta con 5 usuarios predefinidos más los usuarios que se registren dinámicamente. " +
                                  "Cada usuario tiene acceso completo a las funcionalidades de accesibilidad visual.",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}
