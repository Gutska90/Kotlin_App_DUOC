# DOCUMENTACIÓN DEL PROYECTO - APLICACIÓN DE ACCESIBILIDAD VISUAL

---

## DATOS DEL DOCUMENTO

### Histórico de Revisiones

| Versión | Fecha | Descripción/Cambio | Autor |
|---------|-------|-------------------|-------|
| 1.0 | Diciembre 2024 | Versión inicial del proyecto - Implementación completa en Kotlin | Estudiante |
| 1.1 | Diciembre 2024 | Corrección de iconos y optimización de componentes | Estudiante |
| 1.2 | Diciembre 2024 | Documentación final y verificación de cumplimiento | Estudiante |

---

## INFORMACIÓN DEL PROYECTO

| Campo | Información |
|-------|-------------|
| **Organización** | Universidad Duoc UC |
| **Sección** | Desarrollo de Aplicaciones Móviles (DSY2204) |
| **Proyecto (nombre)** | Integrando Kotlin a la aplicación móvil con Android Studio |
| **Fecha de inicio** | Diciembre 2024 |
| **Fecha de término** | Diciembre 2024 |
| **Patrocinador principal** | Universidad Duoc UC |
| **Docente** | [Nombre del docente] |

---

## ALCANCE DEL PROYECTO

### Problema
Las personas con discapacidad sensorial visual enfrentan barreras significativas para acceder a la tecnología móvil, limitando su capacidad de comunicación, lectura y escritura en su entorno cotidiano. La falta de aplicaciones específicamente diseñadas para sus necesidades dificulta su integración al mundo digital y real, afectando directamente su calidad de vida y autonomía.

### Solución Propuesta
Desarrollar una aplicación móvil nativa en Android usando Kotlin y Jetpack Compose, específicamente diseñada para personas con discapacidad sensorial visual. La aplicación incluye funcionalidades de lectura de texto en voz alta, escritura asistida con corrección automática, y una interfaz completamente accesible con componentes Material Design adaptados para facilitar la comunicación y mejorar la integración digital.

### Contexto del Proyecto
Esta aplicación forma parte de la actividad sumativa 2 del curso de Desarrollo de Aplicaciones Móviles, donde se integran las funcionalidades básicas y avanzadas del lenguaje de programación Kotlin en una aplicación Android Studio existente. El proyecto busca demostrar el dominio de tecnologías móviles modernas aplicadas a la inclusión social.

---

## FUNCIONES ESPERADAS DEL SOFTWARE A DESARROLLAR

### Mockups de Funcionalidades Principales

#### 1. Pantalla de Login
```
┌─────────────────────────────────────┐
│        Acceso a la Aplicación       │
│   Para personas con discapacidad    │
│            visual                   │
├─────────────────────────────────────┤
│  📧 Usuario o Email                 │
│  ┌─────────────────────────────────┐ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│                                     │
│  🔒 Contraseña                       │
│  ┌─────────────────────────────────┐ │
│  │ ••••••••••••••••••••••••••••••• │ │
│  └─────────────────────────────────┘ │
│                                     │
│  ┌─────────────────────────────────┐ │
│  │        Iniciar Sesión           │ │
│  └─────────────────────────────────┘ │
│                                     │
│  ¿Olvidaste tu contraseña? Crear cuenta │
└─────────────────────────────────────┘
```

#### 2. Pantalla de Registro
```
┌─────────────────────────────────────┐
│        Crear Nueva Cuenta           │
│   Registro accesible para personas   │
│     con discapacidad visual         │
├─────────────────────────────────────┤
│  👤 Nombre Completo                 │
│  ┌─────────────────────────────────┐ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│                                     │
│  👤 Nombre de Usuario               │
│  ┌─────────────────────────────────┐ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│                                     │
│  📧 Email                           │
│  ┌─────────────────────────────────┐ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│                                     │
│  🔒 Contraseña                       │
│  ┌─────────────────────────────────┐ │
│  │ ••••••••••••••••••••••••••••••• │ │
│  └─────────────────────────────────┘ │
│                                     │
│  🔒 Confirmar Contraseña             │
│  ┌─────────────────────────────────┐ │
│  │ ••••••••••••••••••••••••••••••• │ │
│  └─────────────────────────────────┘ │
│                                     │
│  ┌─────────────────────────────────┐ │
│  │        Crear Cuenta             │ │
│  └─────────────────────────────────┘ │
└─────────────────────────────────────┘
```

#### 3. Pantalla de Recuperación de Contraseña
```
┌─────────────────────────────────────┐
│      Recuperar Contraseña           │
│  Ingrese su email para recibir      │
│   instrucciones de recuperación     │
├─────────────────────────────────────┤
│  📧 Email                           │
│  ┌─────────────────────────────────┐ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│                                     │
│  ┌─────────────────────────────────┐ │
│  │    Enviar Instrucciones         │ │
│  └─────────────────────────────────┘ │
│                                     │
│  📋 Información importante:        │
│  • Verifique que el email sea correcto │
│  • Revise su carpeta de spam        │
│  • El enlace expira en 24 horas     │
│                                     │
│  ¿Ya tienes cuenta? Inicia sesión   │
└─────────────────────────────────────┘
```

#### 4. Pantalla Principal de Accesibilidad
```
┌─────────────────────────────────────┐
│  Bienvenido, [Usuario]               │
│  Aplicación de Accesibilidad Visual │
├─────────────────────────────────────┤
│  🎵 Lectura de Texto                 │
│  ┌─────────────────────────────────┐ │
│  │ Escriba el texto que desea que   │ │
│  │ la aplicación lea en voz alta   │ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│  ┌─────────────────────────────────┐ │
│  │        Leer Texto              │ │
│  └─────────────────────────────────┘ │
│                                     │
│  ✏️ Escritura Asistida              │
│  ┌─────────────────────────────────┐ │
│  │ Escriba texto con asistencia    │ │
│  │ de voz y corrección automática  │ │
│  │                                 │ │
│  └─────────────────────────────────┘ │
│  ┌─────────────┐ ┌─────────────────┐ │
│  │   Guardar   │ │     Borrar     │ │
│  └─────────────┘ └─────────────────┘ │
│                                     │
│  ⚙️ Configuración de Accesibilidad  │
│  Funciones de accesibilidad [ON/OFF] │
└─────────────────────────────────────┘
```

---

## RENDIMIENTO ESPERADO DEL SOFTWARE A DESARROLLAR

### Descripción de cada View

#### **LoginScreen**
- **Tiempo de carga**: < 2 segundos
- **Autenticación**: Instantánea con usuarios predefinidos
- **Validación**: En tiempo real de campos obligatorios
- **Navegación**: Transición fluida entre pantallas (< 500ms)
- **Accesibilidad**: Lectura de elementos por lectores de pantalla
- **Rendimiento**: 60 FPS constante, uso de memoria < 50MB

#### **RegisterScreen**
- **Validación**: Inmediata de campos con retroalimentación visual
- **Registro**: Proceso completado en < 3 segundos
- **Manejo de errores**: Mensajes claros en < 1 segundo
- **UX**: Retroalimentación visual inmediata en cada campo
- **Persistencia**: Datos guardados automáticamente
- **Rendimiento**: Sin bloqueos de UI durante validaciones

#### **ForgotPasswordScreen**
- **Verificación**: Proceso de email en < 2 segundos
- **Simulación**: Recuperación simulada sin demoras
- **Información**: Mensajes informativos claros y accesibles
- **Navegación**: Botones de regreso responsivos
- **Rendimiento**: Interfaz fluida sin lag

#### **MainAppScreen**
- **Funcionalidades**: Respuesta inmediata a interacciones
- **Lectura de texto**: Sin demoras perceptibles (< 100ms)
- **Escritura asistida**: Corrección automática en tiempo real
- **Configuración**: Cambios aplicados instantáneamente
- **Memoria**: Uso eficiente con gestión automática
- **Rendimiento**: Mantiene 60 FPS durante todas las operaciones

---

## RESTRICCIONES DEL PROYECTO

### Restricciones Tecnológicas
1. **Plataforma**: Desarrollo exclusivo en Android Studio
2. **Lenguaje**: Implementación obligatoria en Kotlin
3. **UI Framework**: Uso exclusivo de Jetpack Compose
4. **Compatibilidad**: Dispositivos Android API 24+ (Android 7.0+)
5. **Arquitectura**: Patrón MVVM recomendado

### Restricciones Funcionales
1. **Usuarios**: Mínimo 5 usuarios predefinidos requeridos
2. **Pantallas**: Implementación obligatoria de Login, Registro y Recuperación
3. **Accesibilidad**: Funcionalidades específicas para discapacidad visual
4. **Conectividad**: Requerimiento de conexión a internet activa
5. **Persistencia**: Datos de usuarios almacenados localmente

### Restricciones Temporales
1. **Entrega**: Dentro del plazo establecido por la universidad
2. **Documentación**: Completar antes de la fecha límite
3. **Testing**: Pruebas básicas antes de entrega
4. **Revisión**: Tiempo limitado para correcciones

### Restricciones de Calidad
1. **Código**: Sin errores críticos de compilación
2. **Funcionalidad**: Todas las características principales operativas
3. **Usabilidad**: Interfaz intuitiva y accesible
4. **Documentación**: Completa y clara
5. **Cumplimiento**: 100% de requerimientos técnicos

---

## ESTRUCTURA DE DESGLOSE DE TRABAJO (EDT)

### Diagrama EDT
```
Proyecto Aplicación Accesibilidad Visual
├── 1. Análisis y Diseño (20%)
│   ├── 1.1 Análisis de requerimientos (5%)
│   ├── 1.2 Diseño de arquitectura (8%)
│   └── 1.3 Diseño de interfaz de usuario (7%)
├── 2. Desarrollo Backend (25%)
│   ├── 2.1 Modelos de datos (8%)
│   ├── 2.2 Gestión de usuarios (10%)
│   └── 2.3 Lógica de negocio (7%)
├── 3. Desarrollo Frontend (30%)
│   ├── 3.1 Pantalla de Login (8%)
│   ├── 3.2 Pantalla de Registro (8%)
│   ├── 3.3 Pantalla de Recuperación (6%)
│   └── 3.4 Pantalla Principal (8%)
├── 4. Implementación de Accesibilidad (15%)
│   ├── 4.1 Lectura de texto (6%)
│   ├── 4.2 Escritura asistida (5%)
│   └── 4.3 Configuración de accesibilidad (4%)
├── 5. Testing y Validación (5%)
│   ├── 5.1 Pruebas unitarias (2%)
│   ├── 5.2 Pruebas de integración (2%)
│   └── 5.3 Pruebas de accesibilidad (1%)
└── 6. Documentación y Entrega (5%)
    ├── 6.1 Documentación técnica (3%)
    ├── 6.2 Manual de usuario (1%)
    └── 6.3 Preparación de entrega (1%)
```

### Diccionario EDT

#### **1. Análisis y Diseño**
- **1.1 Análisis de requerimientos**: Identificación, documentación y validación de necesidades del usuario con discapacidad visual
- **1.2 Diseño de arquitectura**: Definición de la estructura técnica del proyecto, patrones de diseño y arquitectura de componentes
- **1.3 Diseño de interfaz**: Creación de mockups, especificaciones de UI/UX y diseño de componentes accesibles

#### **2. Desarrollo Backend**
- **2.1 Modelos de datos**: Definición de estructuras de datos en Kotlin, data classes y objetos de dominio
- **2.2 Gestión de usuarios**: Implementación de autenticación, registro, validaciones y persistencia de usuarios
- **2.3 Lógica de negocio**: Algoritmos, reglas de negocio y servicios de la aplicación

#### **3. Desarrollo Frontend**
- **3.1 Pantalla de Login**: Implementación completa de autenticación de usuarios con validaciones
- **3.2 Pantalla de Registro**: Formulario de creación de nuevas cuentas con validaciones robustas
- **3.3 Pantalla de Recuperación**: Proceso de recuperación de contraseñas por email
- **3.4 Pantalla Principal**: Interfaz principal con todas las funcionalidades de accesibilidad

#### **4. Implementación de Accesibilidad**
- **4.1 Lectura de texto**: Funcionalidad de conversión de texto a voz para usuarios con discapacidad visual
- **4.2 Escritura asistida**: Herramientas de escritura con corrección automática y asistencia por voz
- **4.3 Configuración**: Panel de ajustes de accesibilidad personalizables por usuario

#### **5. Testing y Validación**
- **5.1 Pruebas unitarias**: Validación de componentes individuales y funciones específicas
- **5.2 Pruebas de integración**: Verificación del funcionamiento conjunto de todos los componentes
- **5.3 Pruebas de accesibilidad**: Validación de cumplimiento de estándares de accesibilidad

#### **6. Documentación y Entrega**
- **6.1 Documentación técnica**: Especificaciones técnicas, arquitectura y guías de desarrollo
- **6.2 Manual de usuario**: Guía de uso de la aplicación para usuarios finales
- **6.3 Preparación de entrega**: Compilación, empaquetado y preparación de archivos finales

---

## RESUMEN DE RIESGOS

| Riesgo | Fase | Probabilidad | Impacto | Acción de Mitigación |
|--------|------|--------------|---------|---------------------|
| **Complejidad técnica de Jetpack Compose** | Desarrollo Frontend | Media | Significativo | Capacitación previa, uso de documentación oficial, desarrollo incremental con pruebas continuas |
| **Problemas de compatibilidad con dispositivos** | Testing y Validación | Baja | Moderado | Pruebas en múltiples dispositivos virtuales, configuración de diferentes resoluciones y versiones de Android |
| **Retrasos en implementación de accesibilidad** | Implementación de Accesibilidad | Media | Significativo | Priorización de funcionalidades críticas, uso de librerías probadas, desarrollo paralelo |
| **Errores en gestión de usuarios** | Desarrollo Backend | Baja | Moderado | Implementación de validaciones robustas, pruebas exhaustivas de casos edge, manejo de errores |
| **Problemas de rendimiento en dispositivos antiguos** | Testing y Validación | Media | Moderado | Optimización de código, pruebas de rendimiento, uso eficiente de memoria y CPU |
| **Dificultades en integración de componentes** | Desarrollo Frontend | Media | Moderado | Desarrollo incremental, pruebas continuas, uso de patrones de diseño establecidos |
| **Falta de conocimiento en tecnologías móviles** | Análisis y Diseño | Alta | Alto | Capacitación intensiva, mentoría, uso de recursos de aprendizaje oficiales |
| **Problemas de conectividad de red** | Implementación de Accesibilidad | Baja | Inferior | Implementación de modo offline, manejo de errores de red, indicadores de estado |

---

**Fecha de finalización**: Diciembre 2024  
**Estado del proyecto**: ✅ COMPLETADO  
**Cumplimiento de requerimientos**: 100%
