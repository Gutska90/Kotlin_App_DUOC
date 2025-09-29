# Minuta Nutricional - Aplicación Móvil

Una aplicación móvil desarrollada en Kotlin con Android Studio, diseñada para facilitar la planificación de comidas saludables para usuarios de baja habilidad informática.

## 🎯 Características Principales

- **Autenticación con Firebase**: Login, registro y recuperación de contraseña
- **Gestión de recetas**: CRUD completo para recetas nutricionales
- **Minuta semanal**: Planificación de comidas por semana
- **Búsqueda de dispositivos**: Conecta con otros dispositivos para compartir recetas
- **Interfaz intuitiva**: Diseñada para usuarios de baja habilidad informática
- **Persistencia de datos**: Integración completa con Firebase Firestore

## 🚀 Funcionalidades Implementadas

### Pantallas de Autenticación
- **Login**: Acceso con email y contraseña usando Firebase Auth
- **Registro**: Creación de nuevas cuentas con validaciones
- **Recuperación de contraseña**: Proceso de recuperación por email

### Gestión de Recetas
- **Lista de recetas**: Visualización de recetas públicas
- **Búsqueda**: Búsqueda por nombre, ingredientes o descripción
- **Filtros**: Filtrado por categoría (Desayuno, Almuerzo, Cena, Snack)
- **Detalles**: Información completa de cada receta

### Minuta Semanal
- **Planificación**: Creación y edición de minutas semanales
- **Vista por días**: Organización de comidas por día de la semana
- **Gestión de comidas**: Asignación de recetas a cada comida del día

### Búsqueda de Dispositivos
- **Detección**: Búsqueda de dispositivos cercanos en la red
- **Conexión**: Conecta con otros dispositivos para compartir recetas
- **Sincronización**: Comparte minutas y recetas entre dispositivos

## 🔥 Firebase Integration

La aplicación utiliza Firebase para:

- **Autenticación**: Firebase Auth para login y registro
- **Base de datos**: Firestore para persistencia de datos
- **Almacenamiento**: Firebase Storage para imágenes de recetas
- **Analytics**: Firebase Analytics para métricas de uso

### Configuración de Firebase

1. Crear proyecto en [Firebase Console](https://console.firebase.google.com)
2. Agregar aplicación Android con package name: `com.example.mykotlinappduoc`
3. Descargar `google-services.json` y reemplazar el archivo en `app/`
4. Configurar reglas de seguridad en Firestore

## 🛠️ Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Android Studio**: IDE de desarrollo
- **Jetpack Compose**: Framework de UI moderna
- **Material Design 3**: Sistema de diseño de Google
- **Firebase**: Backend como servicio (Auth, Firestore, Storage)
- **MVVM Architecture**: Patrón de arquitectura con ViewModel
- **Coroutines**: Programación asíncrona
- **Android API 24+**: Compatibilidad con dispositivos modernos

## 📱 Requisitos del Sistema

- Android 7.0 (API 24) o superior
- Conexión a internet activa
- Mínimo 2GB de RAM
- 50MB de espacio de almacenamiento

## 🏗️ Estructura del Proyecto

```
app/src/main/java/com/example/mykotlinappduoc/
├── data/
│   └── User.kt                    # Modelos de datos y gestión de usuarios
├── ui/screens/
│   ├── LoginScreen.kt            # Pantalla de inicio de sesión
│   ├── RegisterScreen.kt         # Pantalla de registro
│   ├── ForgotPasswordScreen.kt   # Pantalla de recuperación
│   └── MainAppScreen.kt          # Pantalla principal con funcionalidades
└── MainActivity.kt               # Actividad principal y navegación
```

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   ```

2. **Abrir en Android Studio**:
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar a la carpeta del proyecto

3. **Configurar el proyecto**:
   - Sincronizar con Gradle
   - Verificar que el SDK de Android esté configurado
   - Conectar dispositivo Android o iniciar emulador

4. **Ejecutar la aplicación**:
   - Hacer clic en "Run" o presionar Shift+F10
   - Seleccionar dispositivo de destino
   - La aplicación se instalará y ejecutará automáticamente

## 🧪 Pruebas

### Pruebas de Funcionalidad
1. **Login**: Usar cualquiera de los usuarios predefinidos
2. **Registro**: Crear una nueva cuenta con datos válidos
3. **Recuperación**: Probar recuperación con email existente
4. **Accesibilidad**: Probar lectura de texto y escritura asistida

### Pruebas de Accesibilidad
- Verificar que todos los elementos sean accesibles por voz
- Confirmar que los textos sean legibles con lectores de pantalla
- Validar navegación por teclado
- Probar contraste y tamaño de fuente

## 📋 Requerimientos Cumplidos

✅ **Implementación en Kotlin**: Todo el código desarrollado en Kotlin  
✅ **Android Studio**: Proyecto desarrollado en Android Studio  
✅ **Jetpack Compose**: UI implementada con Jetpack Compose  
✅ **Material Design**: Componentes Material Design integrados  
✅ **Firebase Integration**: Backend completo con Firebase  
✅ **Autenticación**: Firebase Auth para usuarios  
✅ **Base de datos**: Firestore para persistencia  
✅ **CRUD completo**: Gestión de usuarios, recetas y minutas  
✅ **Pantallas requeridas**: Minuta, Receta y BuscarDispositivo  
✅ **Servicios de datos**: Conexión y gestión de datos  
✅ **Permisos de internet**: Configurados en AndroidManifest  
✅ **Documentación**: Documentación completa del proyecto  

## 🔧 Configuración de Desarrollo

### Dependencias Principales
```kotlin
// Firebase
implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
implementation("com.google.firebase:firebase-auth-ktx")
implementation("com.google.firebase:firebase-firestore-ktx")
implementation("com.google.firebase:firebase-storage-ktx")

// Compose
implementation("androidx.compose.ui:ui:1.5.8")
implementation("androidx.compose.material3:material3:1.1.2")
implementation("androidx.navigation:navigation-compose:2.7.6")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
```

### Permisos Requeridos
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## 📄 Documentación Adicional

- **Documentación técnica completa**: Ver `DOCUMENTACION_PROYECTO.md`
- **Especificaciones de accesibilidad**: Incluidas en la documentación técnica
- **Diagramas de arquitectura**: Disponibles en la documentación del proyecto

## 👨‍💻 Desarrollo

Este proyecto fue desarrollado como parte de la actividad formativa 5 del curso "Desarrollo de Aplicaciones Móviles" de la Universidad Duoc UC, enfocado en la programación del backend de aplicaciones móviles con Firebase y Kotlin.

## 📞 Soporte

Para soporte técnico o consultas sobre la aplicación, contactar al equipo de desarrollo del proyecto.

---

**Versión**: 1.0  
**Última actualización**: Diciembre 2024  
**Estado**: ✅ Completado y funcional
