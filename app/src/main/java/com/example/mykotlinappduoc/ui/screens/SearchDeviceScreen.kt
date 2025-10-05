package com.example.mykotlinappduoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlinappduoc.data.Recipe
import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker

/**
 * Pantalla de Búsqueda de Dispositivos
 * Diseñada para usuarios de baja habilidad informática
 * Permite buscar y conectar con dispositivos para sincronizar recetas
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDeviceScreen(
    onSearchDevices: () -> Unit,
    onConnectDevice: (String) -> Unit
) {
    var isSearching by remember { mutableStateOf(false) }
    var foundDevices by remember { mutableStateOf<List<DeviceInfo>>(emptyList()) }
    var isConnected by remember { mutableStateOf(false) }
    var connectedDevice by remember { mutableStateOf<String?>(null) }
    
    val context = LocalContext.current
    val fusedClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var lastKnownLocation by remember { mutableStateOf<Location?>(null) }
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
                    text = "Buscar Dispositivos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Conecta con otros dispositivos para compartir recetas",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Icon(imageVector = Icons.Default.Info, contentDescription = "Info", modifier = Modifier.size(32.dp), tint = MaterialTheme.colorScheme.primary)
        }
        
        // Estado de conexión
        ConnectionStatusCard(
            isConnected = isConnected,
            connectedDevice = connectedDevice
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Botón de búsqueda (con geolocalización básica)
        Button(
            onClick = {
                isSearching = true
                // Intentar obtener última ubicación conocida
                requestLastLocation(fusedClient) { location ->
                    lastKnownLocation = location
                }
                // Simular búsqueda de dispositivos
                foundDevices = listOf(
                    DeviceInfo("Cocina Smart", "192.168.1.100", "Activo"),
                    DeviceInfo("Tablet Cocina", "192.168.1.101", "Activo"),
                    DeviceInfo("Teléfono María", "192.168.1.102", "Activo")
                )
                isSearching = false
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isSearching
        ) {
            if (isSearching) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Buscar Dispositivos Cercanos")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Lista de dispositivos encontrados
        if (foundDevices.isNotEmpty()) {
            Text(
                text = "Dispositivos Encontrados",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(foundDevices) { device ->
                    DeviceCard(
                        device = device,
                        onConnect = { 
                            onConnectDevice(device.name)
                            isConnected = true
                            connectedDevice = device.name
                        }
                    )
                }
            }
        } else if (!isSearching) {
            EmptyDevicesState()
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Información de ayuda
        HelpCard()

        if (lastKnownLocation != null) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Ubicación aproximada: ${lastKnownLocation!!.latitude.format(4)}, ${lastKnownLocation!!.longitude.format(4)}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@SuppressLint("MissingPermission")
private fun requestLastLocation(
    fusedClient: FusedLocationProviderClient,
    onLocation: (Location?) -> Unit
) {
    fusedClient.lastLocation
        .addOnSuccessListener { location -> onLocation(location) }
        .addOnFailureListener { onLocation(null) }
}

private fun Double.format(decimals: Int): String =
    String.format(java.util.Locale.getDefault(), "% .${'$'}{decimals}f", this).trim()

@Composable
fun ConnectionStatusCard(
    isConnected: Boolean,
    connectedDevice: String?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isConnected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = "Estado de conexión")
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column {
                Text(
                    text = if (isConnected) "Conectado" else "Desconectado",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                if (isConnected && connectedDevice != null) {
                    Text(
                        text = "Dispositivo: $connectedDevice",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    Text(
                        text = "No hay dispositivos conectados",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun DeviceCard(
    device: DeviceInfo,
    onConnect: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = device.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = device.ipAddress,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Estado: ${device.status}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            Button(
                onClick = onConnect,
                modifier = Modifier.height(36.dp)
            ) {
                Text("Conectar")
            }
        }
    }
}

@Composable
fun EmptyDevicesState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = Icons.Default.Info, contentDescription = "Sin dispositivos", modifier = Modifier.size(64.dp), tint = MaterialTheme.colorScheme.primary)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "No se encontraron dispositivos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Asegúrate de que los dispositivos estén en la misma red Wi-Fi y que tengan la aplicación instalada",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun HelpCard() {
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
                text = "¿Cómo funciona?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = "• Busca dispositivos cercanos en tu red Wi-Fi\n" +
                      "• Conecta con otros dispositivos que tengan la aplicación\n" +
                      "• Comparte recetas y minutas entre dispositivos\n" +
                      "• Sincroniza tu información automáticamente",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Modelo de datos para información de dispositivos
 */
data class DeviceInfo(
    val name: String,
    val ipAddress: String,
    val status: String
)
