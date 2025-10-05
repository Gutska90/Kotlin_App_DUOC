# DOCUMENTACIÓN DEL PROYECTO - APLICACIÓN DE ACCESIBILIDAD VISUAL

---

## DESCRIPCIÓN DE LA ACTIVIDAD (Sumativa 3)

En esta octava semana, se realizará la actividad sumativa 3, llamada "Preparación de una aplicación móvil Android/Kotlin para su distribución". Se debe integrar en la app creada con Android Studio y Kotlin tanto el front end como el back end y preparar la aplicación móvil para su publicación en una distribución de descarga de apps. La entrega consiste en la documentación del desarrollo y el código del proyecto comprimido en formato .zip.

### Instrucciones específicas
- Integrar en la aplicación móvil de accesibilidad para personas con discapacidad sensorial visual (desarrollada en la experiencia de aprendizaje 1) el front end y back end en Kotlin, y preparar y publicar el APK firmado.
- La aplicación debe estar diseñada con componentes UI específicos para personas con discapacidad sensorial visual, facilitando su comunicación (escribir y leer) en el entorno cotidiano, transformando sus dispositivos móviles en una herramienta que los integra al mundo real y digital.

### Requerimientos generales
- Integrar el front end (views: Login, Registro, Recuperar contraseña, HomeMenú, Escribir, Hablar y BuscarDispositivo; uso de geolocalización, fragments, viewgroups, content providers, widgets, palette texts, buttons y palette widgets) y el back end (base de datos Google Firebase para permanencia de datos, reglas de conexión con los objetos y configuración de parámetros para autenticación de usuarios registrados) en Kotlin sobre la app móvil de las experiencias 1 y 2.
- Implementar servicios para manejo de datos: conexión a la base de datos, autorización y autenticación de usuarios, operaciones CRUD para gestión de usuarios y para las funciones de las views Escribir, Hablar y BuscarDispositivo.
- Testear con pruebas unitarias y de UI (JUnit, Mockito, Robolectric, Espresso, TDD y Firebase Test Lab) la app móvil, para luego generar el APK, firmarlo y publicarlo en una plataforma de descarga gratuita, simulando la tienda Google Play Store.

### Requerimientos técnicos
- Desarrollar la aplicación con Android Studio.
- Compartir el repositorio Git del proyecto.
- Integrar el lenguaje Kotlin al código fuente de la app.
- Integrar los componentes UI de Android Studio y Kotlin.
- Integrar Firebase para persistencia de datos y autorización.
- Desarrollar pruebas unitarias y de UI en Kotlin.
- Generar el APK, firmarlo y publicarlo.

### Entrega de encargo con documentación
Actividad con dos partes, a entregar todo en un único archivo ZIP:
1) Comprimir la carpeta del código del proyecto completo desde Git y adjuntar el APK generado, firmado y publicado (o enlace de distribución) en el espacio indicado del AVA.
2) Documentar todo el proceso de desarrollo: rendimiento de las views y de las pruebas, restricciones, y seguimiento de 5 riesgos técnicos definidos en la experiencia de aprendizaje 1, describiendo resultados de las acciones de mitigación. Este mismo documento debe adjuntarse en formato PDF dentro del ZIP junto con el proyecto.
- Entregar el producto totalmente finalizado, según el avance solicitado.
- No se aceptarán entregas fuera de plazo ni por otro medio que no sea AVA.
- Todos los productos desarrollados con IA serán evaluados con nota mínima.

### Restricciones en esta entrega
La aplicación móvil debe ser adaptativa a múltiples dispositivos Android con conexión activa a internet.

### Formato del texto
- Fuente: Arial
- Tamaño: 12 pt
- Interlineado: 1,5 líneas
- Alineación: izquierda

---

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
Esta aplicación forma parte de la actividad sumativa 3 del curso de Desarrollo de Aplicaciones Móviles, enfocada en integrar front end y back end en Kotlin, preparar el APK firmado y simular su publicación para distribución. El proyecto busca demostrar el dominio de tecnologías móviles modernas aplicadas a la inclusión social.

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

---

## PLANTILLA DE RESPUESTA PARA COMPLETAR Y ANEXAR EN PDF

> Usa estas secciones como plantilla oficial solicitada. Puedes dejarlas como registro adicional junto a las secciones completas anteriores.

### Datos del documento
#### Histórico de revisiones
| Versión | Fecha | Descripción/cambio | Autor |
|---------|------|--------------------|-------|
|         |      |                    |       |

### Información del proyecto
| Campo | Información |
|-------|-------------|
| Organización | |
| Sección | |
| Proyecto (nombre) | |
| Fecha de inicio | |
| Fecha de término | |
| Patrocinador principal | |
| Docente | |

### Alcance del proyecto
#### Problema, solución propuesta y contexto del proyecto



### Funciones esperadas del software a desarrollar
Solo mockup



### Rendimiento esperado del software a desarrollar
Descripción de cada view



### Restricciones del proyecto



### Estructura de desglose de trabajo (EDT)
Definición de Diagrama y diccionario EDT. Adjuntar diagrama y diccionario.



### Resumen de riesgos
Listado de riesgos relacionados al desarrollo de software. Indica: riesgo, fase, probabilidad (alta/media/baja) e impacto (alto/significativo/moderado/inferior/bajo) y acción de mitigación.

| Riesgo | Fase | Probabilidad | Impacto | Acción de mitigación |
|--------|------|--------------|---------|----------------------|
|        |      |              |         |                      |
|        |      |              |         |                      |
|        |      |              |         |                      |
|        |      |              |         |                      |
|        |      |              |         |                      |

### Definición de artefactos
Listar y describir los artefactos/entregables del proyecto.

| Artefacto | Descripción |
|-----------|-------------|
|           |             |
|           |             |
|           |             |

### Condiciones de aceptación para cierre del proyecto
Condiciones para dar término al proyecto y margen de tolerancia de defectos.



### Anexos
- Anexo 1: Diagrama EDT
- Anexo 2: Diccionario EDT

---

## Guía de compilación, firma y publicación (Release)

1. Generar keystore (solo una vez):
   - Android Studio > Build > Generate Signed App Bundle / APK > Create new...
   - Guarda el keystore en `app/keystore/release.jks` y anota alias/contraseña.
2. Configurar firma en `gradle.properties` (variables locales):
   - `MYAPP_STORE_FILE=/absolute/path/app/keystore/release.jks`
   - `MYAPP_STORE_PASSWORD=********`
   - `MYAPP_KEY_ALIAS=myapp`
   - `MYAPP_KEY_PASSWORD=********`
3. Añadir configuración de signing en `build.gradle.kts` (solo si se requiere release real).
4. Build de APK:
   - Build > Generate Signed App Bundle / APK > APK > release.
5. Verificación:
   - Instalar en dispositivo y validar TTS/STT, login y geolocalización.
6. Publicación simulada:
   - Subir APK a una plataforma gratuita (Drive enlazado en AVA) o a un store alternativo para descarga de prueba.
