# GUÍA DE INSTALACIÓN Y USO
## Aplicación de Accesibilidad Visual - Minuta Nutricional

---

## 📱 REQUISITOS DEL SISTEMA

### Requisitos Mínimos:
- **Sistema Operativo:** Android 7.0 (API 24) o superior
- **RAM:** 2 GB mínimo
- **Almacenamiento:** 50 MB de espacio libre
- **Conectividad:** Conexión a internet activa
- **Permisos:** Internet, Ubicación, Micrófono

### Dispositivos Compatibles:
- ✅ Smartphones Android
- ✅ Tablets Android
- ✅ Emuladores Android

---

## 📥 INSTALACIÓN

### Opción 1: Instalación Directa (Recomendado)

**Paso 1: Descargar APK**
1. Abre el archivo ZIP entregado
2. Extrae el archivo `app-debug.apk`
3. Transfiere el APK a tu dispositivo Android

**Paso 2: Habilitar Instalación desde Fuentes Desconocidas**
1. Ve a **Configuración** → **Seguridad**
2. Activa **"Orígenes desconocidos"** o **"Instalar apps desconocidas"**
3. Si es Android 8.0+, permite instalación desde el navegador de archivos

**Paso 3: Instalar APK**
1. Abre el archivo `app-debug.apk` en tu dispositivo
2. Haz clic en **"Instalar"**
3. Espera que termine la instalación
4. Haz clic en **"Abrir"** para iniciar la app

### Opción 2: Desde Android Studio

**Paso 1: Conectar Dispositivo**
1. Conecta tu dispositivo Android al computador con cable USB
2. Habilita **"Depuración USB"** en Opciones de desarrollador

**Paso 2: Compilar e Instalar**
```bash
cd /Users/user/AndroidStudioProjects/MyKotlinAppDuoc
./gradlew installDebug
```

3. La app se instalará automáticamente

---

## 🚀 PRIMER USO

### 1. Registro de Usuario

**Al abrir la app por primera vez:**
1. Haz clic en **"Crear cuenta"**
2. Ingresa tu información:
   - **Email:** tu@email.com
   - **Contraseña:** mínimo 6 caracteres
   - **Nombre completo**
3. Haz clic en **"Crear Cuenta"**
4. Verás un mensaje de confirmación

### 2. Iniciar Sesión

**Si ya tienes cuenta:**
1. Ingresa tu **email** o **usuario**
2. Ingresa tu **contraseña**
3. Haz clic en **"Iniciar Sesión"**
4. Verás un mensaje de bienvenida con tu nombre

**Usuarios de Prueba:**
- Usuario: usuario1, Contraseña: password123
- Usuario: usuario2, Contraseña: password456
- Usuario: usuario3, Contraseña: password789

---

## 📖 USO DE LA APLICACIÓN

### Menú Principal

Después de iniciar sesión, verás **4 pestañas**:

#### 🍽️ **1. Recetas**
- Ver todas las recetas disponibles
- Buscar por nombre o ingrediente
- Filtrar por categoría
- Ver detalles completos

#### 📅 **2. Minuta**
- Ver tu planificación semanal
- Agregar recetas a cada comida
- Organizar tu semana

#### 📱 **3. Dispositivos**
- Buscar dispositivos cercanos
- Conectar con otros dispositivos
- Ver tu ubicación

#### ❓ **4. Ayuda**
- Tutorial completo de uso
- Consejos y recomendaciones
- Soporte técnico

---

## ✍️ FUNCIONES DE ACCESIBILIDAD

### Escribir (Texto a Voz)

**Cómo usar:**
1. Escribe el texto que deseas escuchar
2. Haz clic en **"Leer"**
3. La aplicación leerá el texto en voz alta
4. Haz clic en **"Guardar"** para guardar el texto
5. El texto se guarda en tu historial

**Características:**
- 🗣️ Voz en español
- ⚙️ Velocidad ajustable
- 💾 Historial automático

### Hablar (Voz a Texto)

**Cómo usar:**
1. Haz clic en **"Escuchar"**
2. Habla claramente cuando aparezca el micrófono
3. El texto reconocido aparecerá en pantalla
4. Haz clic en **"Usar texto"** para guardarlo
5. Se guarda en tu historial

**Características:**
- 🎤 Reconocimiento en español
- 📝 Conversión precisa
- 💾 Historial automático

---

## 🍽️ GESTIÓN DE RECETAS

### Explorar Recetas

**Búsqueda:**
1. Escribe en la barra de búsqueda
2. Resultados en tiempo real
3. Busca por: nombre, ingrediente, descripción

**Filtros:**
1. Haz clic en los chips de categoría
2. **Desayuno**: 5 recetas
3. **Almuerzo**: 5 recetas
4. **Cena**: 5 recetas
5. **Snack**: 5 recetas

**Ver Detalle:**
1. Haz clic en cualquier receta
2. Ver información completa:
   - Ingredientes detallados
   - Instrucciones paso a paso
   - Tiempo de preparación
   - Calorías y porciones

---

## 📅 PLANIFICACIÓN SEMANAL

### Crear tu Minuta

**Paso 1: Ir a Minuta**
- Haz clic en la pestaña "Minuta"

**Paso 2: Seleccionar Día**
- Verás 7 días de la semana
- Cada día tiene 4 comidas

**Paso 3: Agregar Receta**
1. Haz clic en **"Agregar"** en la comida deseada
2. Busca o filtra recetas
3. Haz clic en **"Agregar"** en la receta
4. La receta se asigna automáticamente

**Paso 4: Ver tu Minuta**
- Las recetas asignadas aparecen en cada comida
- Puedes agregar más recetas
- Se guarda automáticamente en Firebase

---

## 🔧 SOLUCIÓN DE PROBLEMAS

### Problema: No se puede instalar la APK
**Solución:**
- Verifica que "Fuentes desconocidas" esté habilitado
- Asegúrate de tener espacio suficiente
- Reinicia el dispositivo

### Problema: Error de conexión
**Solución:**
- Verifica tu conexión a internet
- La app funciona offline pero no sincroniza
- Reconecta WiFi o datos móviles

### Problema: No aparecen recetas
**Solución:**
- Cierra y abre la aplicación
- Verifica conexión a internet
- Las recetas se cargan desde Firebase

### Problema: Login no funciona
**Solución:**
- Verifica email y contraseña
- Usa usuarios de prueba si es demo
- Registra nuevo usuario si es necesario

### Problema: Voz no se escucha
**Solución:**
- Verifica volumen del dispositivo
- Asegúrate que TTS esté habilitado
- Reinicia la aplicación

---

## 📞 SOPORTE TÉCNICO

### Contacto
- **Universidad:** Duoc UC
- **Repositorio:** https://github.com/Gutska90/Kotlin_App_DUOC.git
- **Documentación:** Ver archivos DOCUMENTACION_*.md

### Recursos Adicionales
- Tutorial integrado en la app (pestaña Ayuda)
- Documentación completa del proyecto
- Código fuente comentado

---

## ⚠️ NOTAS IMPORTANTES

### Permisos Requeridos
La aplicación solicita los siguientes permisos:
- 📡 **Internet** - Para sincronizar con Firebase
- 📍 **Ubicación** - Para búsqueda de dispositivos
- 🎤 **Micrófono** - Para función de voz a texto

### Privacidad
- 🔒 Todos los datos están protegidos
- 👤 Acceso solo con autenticación
- 🛡️ Reglas de seguridad de Firebase
- 💾 Datos encriptados en tránsito

### Rendimiento
- ⚡ Optimizada para dispositivos Android
- 💾 Uso eficiente de memoria
- 🔋 Consumo de batería optimizado
- 📱 Funciona en múltiples tamaños de pantalla

---

## ✅ VERIFICACIÓN DE INSTALACIÓN

### Checklist Post-Instalación

- [ ] APK instalada correctamente
- [ ] App se abre sin errores
- [ ] Login funciona
- [ ] Recetas aparecen
- [ ] Búsqueda funciona
- [ ] Función Escribir funciona
- [ ] Función Hablar funciona
- [ ] Minuta se puede crear
- [ ] Datos se guardan

**Si todos los puntos están marcados, ¡la instalación fue exitosa!** 🎉

---

**Versión:** 1.0  
**Fecha:** Octubre 2025  
**Universidad:** Duoc UC

