#!/bin/bash

# Script para crear el ZIP de entrega final
# MyKotlinAppDuoc - Entrega Final Sumativa 3

echo "🚀 Creando ZIP de entrega final..."
echo ""

# Nombre del archivo ZIP
ZIP_NAME="MyKotlinAppDuoc_Entrega_Final.zip"
OUTPUT_DIR="../"

# Limpiar ZIP previo si existe
if [ -f "$OUTPUT_DIR$ZIP_NAME" ]; then
    echo "🗑️  Eliminando ZIP anterior..."
    rm "$OUTPUT_DIR$ZIP_NAME"
fi

echo "📦 Empaquetando proyecto..."

# Crear ZIP excluyendo carpetas innecesarias
zip -r "$OUTPUT_DIR$ZIP_NAME" . \
    -x "*.gradle/*" \
    -x "*.idea/*" \
    -x "local.properties" \
    -x "app/build/intermediates/*" \
    -x "app/build/tmp/*" \
    -x "app/build/kotlin/*" \
    -x "app/build/generated/*" \
    -x "app/build/reports/*" \
    -x "app/build/test-results/*" \
    -x "*/.DS_Store" \
    -x "*.iml" \
    -x "crear_entrega.sh"

echo ""
echo "✅ ZIP creado exitosamente: $OUTPUT_DIR$ZIP_NAME"
echo ""
echo "📊 Información del archivo:"
ls -lh "$OUTPUT_DIR$ZIP_NAME"
echo ""
echo "📋 Contenidos incluidos:"
echo "   ✅ Código fuente completo"
echo "   ✅ APK Debug (app/build/outputs/apk/debug/app-debug.apk)"
echo "   ✅ APK Release (app/build/outputs/apk/release/app-release-unsigned.apk)"
echo "   ✅ Documentación completa (*.md)"
echo "   ✅ Configuración Firebase (google-services.json)"
echo "   ✅ Reglas de Firestore (firestore.rules)"
echo ""
echo "🎯 Próximos pasos:"
echo "   1. Convertir PRESENTACION.md a PowerPoint"
echo "   2. Grabar video de presentación (máximo 15 minutos)"
echo "   3. Subir ZIP y link del video a AVA"
echo ""
echo "✨ ¡Proyecto listo para entregar!"

