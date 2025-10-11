# PRESENTACIÓN: APLICACIÓN DE ACCESIBILIDAD VISUAL
## Minuta Nutricional - MyKotlinAppDuoc

---

## DIAPOSITIVA 1: PORTADA

**Título:** Aplicación de Accesibilidad para Personas con Discapacidad Visual

**Subtítulo:** Minuta Nutricional - Planificación de Comidas Saludables

**Universidad:** Duoc UC  
**Asignatura:** Desarrollo de Aplicaciones Móviles (DSY2204)  
**Fecha:** Octubre 2025

---

## DIAPOSITIVA 2: INTRODUCCIÓN

### ¿Qué es esta aplicación?

Una aplicación móvil Android desarrollada en **Kotlin** específicamente diseñada para personas con **discapacidad sensorial visual**, que facilita:

- 🗣️ **Comunicación** (escribir y leer)
- 📱 **Integración digital** al mundo real
- 🍽️ **Planificación nutricional** saludable
- ♿ **Accesibilidad total** con TTS y STT

---

## DIAPOSITIVA 3: PROBLEMA Y SOLUCIÓN

### Problema Identificado
Las personas con discapacidad visual enfrentan barreras para:
- Acceder a tecnología móvil
- Planificar comidas saludables
- Comunicarse en su entorno cotidiano
- Integración al mundo digital

### Nuestra Solución
Aplicación móvil con:
- ✅ Interfaz completamente accesible
- ✅ Funciones de voz (TTS/STT)
- ✅ Base de datos Firebase
- ✅ 20 recetas saludables detalladas
- ✅ Planificación semanal de comidas

---

## DIAPOSITIVA 4: TECNOLOGÍAS UTILIZADAS

### Stack Tecnológico

**Frontend:**
- 📱 Jetpack Compose (UI moderna)
- 🎨 Material Design 3
- 📐 Diseño responsivo (móviles/tablets)

**Backend:**
- 🔥 Firebase Authentication
- 📊 Cloud Firestore
- ☁️ Firebase Storage

**Lenguaje:**
- 🔷 Kotlin 100%
- ⚙️ Arquitectura MVVM
- 🧪 Testing (JUnit, Espresso)

---

## DIAPOSITIVA 5: FUNCIONALIDADES PRINCIPALES

### 1. Autenticación de Usuarios
- Login con email/contraseña
- Registro de nuevos usuarios
- Recuperación de contraseña
- Mensaje de bienvenida personalizado

### 2. Gestión de Recetas
- 20 recetas saludables (5 por categoría)
- Búsqueda inteligente
- Filtros por categoría
- Detalle completo con ingredientes

### 3. Planificación Semanal
- Minuta de 7 días
- 4 comidas por día
- Asignación de recetas
- Persistencia en Firebase

---

## DIAPOSITIVA 6: ACCESIBILIDAD

### Funciones de Accesibilidad Visual

**Escribir (Texto a Voz):**
- ✍️ Escribe texto
- 🔊 La app lo lee en voz alta
- 💾 Se guarda en historial

**Hablar (Voz a Texto):**
- 🎤 Habla al micrófono
- 📝 Se convierte a texto
- 💾 Se guarda en historial

**Geolocalización:**
- 📍 Búsqueda de dispositivos cercanos
- 🌍 Localización GPS
- 📡 Sincronización de datos

---

## DIAPOSITIVA 7: ARQUITECTURA

### Patrón MVVM Implementado

```
┌─────────────────┐
│      View       │ ← Jetpack Compose UI
│   (Screens)     │
└────────┬────────┘
         │
┌────────▼────────┐
│   ViewModel     │ ← Lógica de presentación
│  (RecipeVM)     │
└────────┬────────┘
         │
┌────────▼────────┐
│  Repository     │ ← Abstracción de datos
│ (AppRepository) │
└────────┬────────┘
         │
┌────────▼────────┐
│ Firebase Service│ ← Persistencia real
│  (Firestore)    │
└─────────────────┘
```

---

## DIAPOSITIVA 8: BASE DE DATOS

### Estructura de Firestore

**Colecciones:**
- 👤 **users** - Perfiles de usuarios
- 🍽️ **recipes** - Recetas públicas (20+)
- 📅 **weekly_menus** - Minutas semanales

**Seguridad:**
- 🔒 Reglas de acceso configuradas
- 🛡️ Autenticación obligatoria
- 👥 Datos privados por usuario

---

## DIAPOSITIVA 9: CARACTERÍSTICAS TÉCNICAS

### Optimizaciones Implementadas

**Rendimiento:**
- ⚡ Memoización de filtros
- 🔄 LazyColumn con keys
- ⏱️ Debounce en búsquedas
- 💾 Gestión eficiente de memoria

**UI/UX:**
- 📱 Responsive design
- 🎨 Material Design 3
- ♿ Accesibilidad total
- 🌓 Navegación intuitiva

---

## DIAPOSITIVA 10: TESTING

### Pruebas Implementadas

**Unit Testing:**
- ✅ RecipeViewModel tests
- ✅ Firebase Service tests
- ✅ Fake Repository para testing

**UI Testing:**
- ✅ LoginScreen tests (Espresso)
- ✅ Navegación tests
- ✅ Compose UI tests

**Cobertura:**
- 📊 Funcionalidades críticas cubiertas
- 🎯 Tests de integración
- ✅ Validaciones completas

---

## DIAPOSITIVA 11: DEMO - DESCARGA E INSTALACIÓN

### Proceso de Instalación

**Paso 1: Descargar APK**
- Ubicación: `app/build/outputs/apk/debug/app-debug.apk`
- Tamaño: ~14.7 MB

**Paso 2: Habilitar Instalación**
- Configuración → Seguridad
- Permitir "Fuentes desconocidas"

**Paso 3: Instalar**
- Abrir archivo APK
- Hacer clic en "Instalar"
- Confirmar instalación

---

## DIAPOSITIVA 12: DEMO - REGISTRO Y LOGIN

### Primera Vez en la App

**1. Registro:**
- Email: test@ejemplo.com
- Contraseña: 123456
- Nombre completo

**2. Login:**
- Ingresar credenciales
- Ver mensaje de bienvenida
- Acceder al menú principal

---

## DIAPOSITIVA 13: DEMO - FUNCIONALIDADES

### Flujo de Usuario

**1. Explorar Recetas**
- Ver 20 recetas disponibles
- Buscar por nombre
- Filtrar por categoría
- Ver detalles completos

**2. Crear Minuta Semanal**
- Seleccionar día
- Elegir comida
- Asignar receta
- Guardar cambios

**3. Funciones de Accesibilidad**
- Escribir texto → Leer en voz alta
- Hablar → Convertir a texto
- Búsqueda de dispositivos

---

## DIAPOSITIVA 14: RESULTADOS

### Logros Alcanzados

✅ **100% de requerimientos cumplidos**
✅ **Firebase integrado** y operativo
✅ **20 recetas** detalladas
✅ **Accesibilidad** completa
✅ **Responsive design** implementado
✅ **Testing** completado
✅ **Documentación** exhaustiva
✅ **APK listo** para distribución

---

## DIAPOSITIVA 15: BENEFICIOS

### Para Usuarios con Discapacidad Visual

**Autonomía:**
- 🔊 Lectura de textos
- 🎤 Dictado por voz
- 📱 Navegación accesible

**Salud:**
- 🥗 Recetas saludables
- 📅 Planificación nutricional
- 🍽️ Variedad de comidas

**Integración:**
- 🌍 Conectividad digital
- 👥 Comunicación mejorada
- 💪 Calidad de vida

---

## DIAPOSITIVA 16: CONCLUSIONES

### Proyecto Exitoso

**Técnicamente:**
- ✅ Arquitectura sólida (MVVM)
- ✅ Código limpio y mantenible
- ✅ Firebase operativo
- ✅ Optimizado y testeado

**Funcionalmente:**
- ✅ Todas las funcionalidades implementadas
- ✅ Interfaz accesible
- ✅ Experiencia de usuario excelente
- ✅ Cumple objetivo social

**Profesionalmente:**
- ✅ Documentación completa
- ✅ Repositorio Git organizado
- ✅ Listo para producción

---

## DIAPOSITIVA 17: PRÓXIMOS PASOS

### Mejoras Futuras

**Corto Plazo:**
- 📱 Publicación en Google Play Store
- 🌐 Soporte multiidioma
- 🔔 Notificaciones push

**Mediano Plazo:**
- 🤖 IA para sugerencias personalizadas
- 📊 Análisis nutricional avanzado
- 👥 Comunidad de usuarios

**Largo Plazo:**
- 🌍 Expansión internacional
- 🎯 Más funciones de accesibilidad
- 🏆 Certificaciones de accesibilidad

---

## DIAPOSITIVA 18: AGRADECIMIENTOS

### Gracias

**A la Universidad Duoc UC**
Por la formación y oportunidad

**Al Docente**
Por la guía y enseñanzas

**Al Proyecto**
Por permitir crear algo con impacto social

---

## NOTAS PARA LA PRESENTACIÓN

### Tiempo estimado: 12-15 minutos

**Minuto 0-2:** Introducción y problema (Diapositivas 1-3)  
**Minuto 2-4:** Tecnologías y arquitectura (Diapositivas 4-5)  
**Minuto 4-6:** Funcionalidades y accesibilidad (Diapositivas 6-7)  
**Minuto 6-10:** DEMO en vivo (Diapositivas 11-13)  
**Minuto 10-12:** Resultados y beneficios (Diapositivas 14-15)  
**Minuto 12-15:** Conclusiones y próximos pasos (Diapositivas 16-18)

### Consejos para la grabación:
- 🎥 Usa buena iluminación
- 🎤 Habla claro y despacio
- 📱 Muestra la pantalla del dispositivo
- ⏱️ Controla el tiempo
- 🔄 Practica antes de grabar

