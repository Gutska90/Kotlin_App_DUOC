# Aplicación de Accesibilidad Visual

Una aplicación móvil desarrollada en Kotlin con Android Studio, diseñada específicamente para personas con discapacidad sensorial visual.

## 🎯 Características Principales

- **Autenticación completa**: Login, registro y recuperación de contraseña
- **Funcionalidades de accesibilidad**: Lectura de texto y escritura asistida
- **Interfaz accesible**: Diseñada con Material Design y Jetpack Compose
- **Usuarios predefinidos**: 5 usuarios de prueba incluidos
- **Navegación intuitiva**: Flujo de pantallas optimizado para accesibilidad

## 🚀 Funcionalidades Implementadas

### Pantallas de Autenticación
- **Login**: Acceso con usuario/email y contraseña
- **Registro**: Creación de nuevas cuentas con validaciones
- **Recuperación de contraseña**: Proceso de recuperación por email

### Funcionalidades de Accesibilidad
- **Lectura de texto**: Convierte texto escrito en audio
- **Escritura asistida**: Herramientas de escritura con corrección automática
- **Configuración de accesibilidad**: Panel de ajustes personalizables

## 👥 Usuarios de Prueba

La aplicación incluye 5 usuarios predefinidos para testing:

| Usuario | Email | Contraseña | Nombre |
|---------|-------|------------|--------|
| usuario1 | usuario1@email.com | password123 | María González |
| usuario2 | usuario2@email.com | password456 | Carlos Rodríguez |
| usuario3 | usuario3@email.com | password789 | Ana Martínez |
| usuario4 | usuario4@email.com | password012 | Luis Fernández |
| usuario5 | usuario5@email.com | password345 | Carmen López |

## 🛠️ Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Android Studio**: IDE de desarrollo
- **Jetpack Compose**: Framework de UI moderna
- **Material Design 3**: Sistema de diseño de Google
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
✅ **Pantallas requeridas**: Login, Registro y Recuperación implementadas  
✅ **Array de usuarios**: 5 usuarios predefinidos en Kotlin  
✅ **Funcionalidades de accesibilidad**: Lectura y escritura asistida  
✅ **Permisos de internet**: Configurados en AndroidManifest  
✅ **Documentación**: Documentación completa del proyecto  

## 🔧 Configuración de Desarrollo

### Dependencias Principales
```kotlin
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
implementation("androidx.activity:activity-compose:1.8.2")
implementation("androidx.compose.ui:ui:1.5.8")
implementation("androidx.compose.material3:material3:1.1.2")
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

Este proyecto fue desarrollado como parte de la actividad sumativa 2 del curso "Desarrollo de Aplicaciones Móviles" de la Universidad Duoc UC, enfocado en la integración de Kotlin en aplicaciones Android con funcionalidades de accesibilidad.

## 📞 Soporte

Para soporte técnico o consultas sobre la aplicación, contactar al equipo de desarrollo del proyecto.

---

**Versión**: 1.0  
**Última actualización**: Diciembre 2024  
**Estado**: ✅ Completado y funcional
