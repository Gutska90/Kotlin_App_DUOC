# Documentación del Proyecto - Aplicación de Accesibilidad Visual

## Información del Proyecto

**Organización:** Universidad Duoc UC  
**Sección:** Desarrollo de Aplicaciones Móviles (DSY2204)  
**Proyecto:** Integrando Kotlin a la aplicación móvil con Android Studio  
**Fecha de inicio:** Diciembre 2024  
**Fecha de término:** Diciembre 2024  
**Patrocinador principal:** Universidad Duoc UC  
**Docente:** [Nombre del docente]  

## Alcance del Proyecto

### Problema
Las personas con discapacidad sensorial visual enfrentan barreras significativas para acceder a la tecnología móvil, limitando su capacidad de comunicación, lectura y escritura en su entorno cotidiano. La falta de aplicaciones específicamente diseñadas para sus necesidades dificulta su integración al mundo digital y real.

### Solución Propuesta
Desarrollar una aplicación móvil nativa en Android usando Kotlin y Jetpack Compose, específicamente diseñada para personas con discapacidad sensorial visual. La aplicación incluye funcionalidades de lectura de texto en voz alta, escritura asistida, y una interfaz completamente accesible con componentes Material Design adaptados.

### Contexto del Proyecto
Esta aplicación forma parte de la actividad sumativa 2 del curso de Desarrollo de Aplicaciones Móviles, donde se integran las funcionalidades básicas y avanzadas del lenguaje de programación Kotlin en una aplicación Android Studio existente.

## Funciones Esperadas del Software

### Mockups de Funcionalidades Principales

1. **Pantalla de Login**
   - Campos de usuario/email y contraseña
   - Botones de acceso con indicadores visuales claros
   - Enlaces de navegación a registro y recuperación de contraseña
   - Información de usuarios de prueba

2. **Pantalla de Registro**
   - Formulario completo con validaciones
   - Campos: nombre completo, usuario, email, contraseña y confirmación
   - Indicadores de progreso y mensajes de error/éxito
   - Navegación de regreso al login

3. **Pantalla de Recuperación de Contraseña**
   - Campo de email con validación
   - Proceso de recuperación simulado
   - Información importante sobre el proceso
   - Navegación de regreso

4. **Pantalla Principal de Accesibilidad**
   - Lectura de texto en voz alta
   - Escritura asistida con corrección automática
   - Configuración de funciones de accesibilidad
   - Panel de información del usuario

## Rendimiento Esperado del Software

### Descripción de cada View

**LoginScreen:**
- Tiempo de carga: < 2 segundos
- Autenticación instantánea con usuarios predefinidos
- Validación en tiempo real de campos
- Navegación fluida entre pantallas

**RegisterScreen:**
- Validación inmediata de campos
- Registro exitoso en < 3 segundos
- Manejo de errores en tiempo real
- Retroalimentación visual clara

**ForgotPasswordScreen:**
- Verificación de email en < 2 segundos
- Proceso de recuperación simulado
- Mensajes informativos claros
- Navegación intuitiva

**MainAppScreen:**
- Funcionalidades de accesibilidad responsivas
- Lectura de texto sin demoras perceptibles
- Escritura asistida con corrección automática
- Configuración persistente de preferencias

## Restricciones del Proyecto

1. **Tecnológicas:**
   - Desarrollo exclusivo en Android Studio
   - Uso obligatorio del lenguaje Kotlin
   - Implementación con Jetpack Compose
   - Compatibilidad con dispositivos Android API 24+

2. **Funcionales:**
   - Adaptabilidad a múltiples dispositivos Android
   - Requerimiento de conexión a internet activa
   - Array predefinido de 5 usuarios mínimo
   - Funcionalidades específicas para discapacidad visual

3. **Temporales:**
   - Entrega dentro del plazo establecido
   - Documentación completa requerida
   - Código fuente comprimido en ZIP

4. **Calidad:**
   - No se aceptan productos desarrollados completamente con IA
   - Código funcional y sin errores críticos
   - Documentación en formato PDF

## Estructura de Desglose de Trabajo (EDT)

### Diagrama EDT
```
Proyecto Aplicación Accesibilidad Visual
├── 1. Análisis y Diseño
│   ├── 1.1 Análisis de requerimientos
│   ├── 1.2 Diseño de arquitectura
│   └── 1.3 Diseño de interfaz de usuario
├── 2. Desarrollo Backend
│   ├── 2.1 Modelos de datos
│   ├── 2.2 Gestión de usuarios
│   └── 2.3 Lógica de negocio
├── 3. Desarrollo Frontend
│   ├── 3.1 Pantalla de Login
│   ├── 3.2 Pantalla de Registro
│   ├── 3.3 Pantalla de Recuperación
│   └── 3.4 Pantalla Principal
├── 4. Implementación de Accesibilidad
│   ├── 4.1 Lectura de texto
│   ├── 4.2 Escritura asistida
│   └── 4.3 Configuración de accesibilidad
├── 5. Testing y Validación
│   ├── 5.1 Pruebas unitarias
│   ├── 5.2 Pruebas de integración
│   └── 5.3 Pruebas de accesibilidad
└── 6. Documentación y Entrega
    ├── 6.1 Documentación técnica
    ├── 6.2 Manual de usuario
    └── 6.3 Preparación de entrega
```

### Diccionario EDT

**1. Análisis y Diseño**
- 1.1 Análisis de requerimientos: Identificación y documentación de necesidades del usuario
- 1.2 Diseño de arquitectura: Definición de la estructura técnica del proyecto
- 1.3 Diseño de interfaz: Creación de mockups y especificaciones de UI

**2. Desarrollo Backend**
- 2.1 Modelos de datos: Definición de estructuras de datos en Kotlin
- 2.2 Gestión de usuarios: Implementación de autenticación y registro
- 2.3 Lógica de negocio: Algoritmos y reglas de la aplicación

**3. Desarrollo Frontend**
- 3.1 Pantalla de Login: Implementación de autenticación de usuarios
- 3.2 Pantalla de Registro: Formulario de creación de nuevas cuentas
- 3.3 Pantalla de Recuperación: Proceso de recuperación de contraseñas
- 3.4 Pantalla Principal: Interfaz principal con funcionalidades de accesibilidad

**4. Implementación de Accesibilidad**
- 4.1 Lectura de texto: Funcionalidad de texto a voz
- 4.2 Escritura asistida: Herramientas de escritura con asistencia
- 4.3 Configuración: Panel de ajustes de accesibilidad

**5. Testing y Validación**
- 5.1 Pruebas unitarias: Validación de componentes individuales
- 5.2 Pruebas de integración: Verificación de funcionamiento conjunto
- 5.3 Pruebas de accesibilidad: Validación de cumplimiento de estándares

**6. Documentación y Entrega**
- 6.1 Documentación técnica: Especificaciones técnicas del proyecto
- 6.2 Manual de usuario: Guía de uso de la aplicación
- 6.3 Preparación de entrega: Compilación y empaquetado final

## Resumen de Riesgos

| Riesgo | Fase | Probabilidad | Impacto | Acción de Mitigación |
|--------|------|--------------|---------|---------------------|
| Complejidad técnica de Jetpack Compose | Desarrollo Frontend | Media | Significativo | Capacitación previa y uso de documentación oficial |
| Problemas de compatibilidad con dispositivos | Testing | Baja | Moderado | Pruebas en múltiples dispositivos virtuales |
| Retrasos en implementación de accesibilidad | Implementación de Accesibilidad | Media | Significativo | Priorización de funcionalidades críticas |
| Errores en gestión de usuarios | Desarrollo Backend | Baja | Moderado | Implementación de validaciones robustas |
| Problemas de rendimiento en dispositivos antiguos | Testing | Media | Moderado | Optimización de código y pruebas de rendimiento |
| Dificultades en integración de componentes | Desarrollo Frontend | Media | Moderado | Desarrollo incremental y pruebas continuas |

## Definición de Artefactos

| Artefacto | Descripción |
|-----------|-------------|
| Código fuente completo | Proyecto Android Studio con todas las funcionalidades implementadas en Kotlin |
| Documentación técnica | Este documento con especificaciones, diseño y análisis del proyecto |
| APK de la aplicación | Archivo ejecutable para instalación en dispositivos Android |
| Repositorio Git | Control de versiones del código fuente con historial de cambios |
| Manual de usuario | Guía de uso de la aplicación para usuarios finales |
| Reporte de pruebas | Documentación de pruebas realizadas y resultados obtenidos |
| Diagramas de arquitectura | Representaciones visuales de la estructura del sistema |

## Condiciones de Aceptación para Cierre del Proyecto

### Condiciones Obligatorias:
1. ✅ Aplicación completamente funcional en Android Studio
2. ✅ Implementación completa en lenguaje Kotlin
3. ✅ Integración de Jetpack Compose y Material Design
4. ✅ Pantallas de Login, Registro y Recuperación de contraseña implementadas
5. ✅ Array de 5 usuarios predefinidos funcionando
6. ✅ Funcionalidades de accesibilidad para discapacidad visual
7. ✅ Permisos de internet configurados
8. ✅ Documentación completa del proyecto
9. ✅ Código fuente comprimido en formato ZIP
10. ✅ Documentación en formato PDF

### Margen de Tolerancia de Aceptación de Defectos:
- **Defectos críticos:** 0% tolerancia
- **Defectos mayores:** Máximo 2 defectos
- **Defectos menores:** Máximo 5 defectos
- **Mejoras de usabilidad:** Sin límite específico

### Criterios de Calidad:
- Código compilable sin errores
- Funcionalidades principales operativas
- Interfaz de usuario accesible
- Documentación completa y clara
- Cumplimiento de todos los requerimientos técnicos

---

**Fecha de finalización:** Diciembre 2024  
**Estado del proyecto:** ✅ COMPLETADO  
**Cumplimiento de requerimientos:** 100%
