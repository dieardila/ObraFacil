# Pruebas y verificaciones
## Estado
Verificación realizada el 16 de noviembre de 2026:
- .\\gradlew.bat assembleDebug: BUILD SUCCESSFUL (13 s).
- .\\gradlew.bat lintDebug --console=plain: BUILD SUCCESSFUL (19 s).
- Después de corregir las etiquetas duplicadas, .\\gradlew.bat assembleDebug lintDebug --console=plain: BUILD SUCCESSFUL (8 s), código de salida 0.
- Se comprobó con Test-Path la existencia de app/build/outputs/apk/debug/app-debug.apk.
- Informe final de lint: 0 errores y 11 advertencias. Persisten avisos por dependencias de la plantilla, checks de Lifecycle incompatibles con la versión de lint, atributos accesibles solo en APIs recientes, tamaño del vector y colores de plantilla sin uso. No se ocultaron advertencias.
- Informe: app/build/reports/lint-results-debug.html.
- No se ejecutaron tests unitarios, instrumentados ni pruebas visuales o de interacción. Los casos siguientes quedan pendientes en dispositivo o emulador.

## Casos pendientes en dispositivo o emulador
1. Inicio: comprobar presentación, imagen local y navegación con Comenzar.
2. Confirmar vacío: mostrar errores y permanecer en inscripción.
3. Nombre vacío, espacios o solo números: rechazar. Nombre con letras y al menos dos caracteres: aceptar.
4. Teléfono con letras, menos de 7 o más de 15 dígitos: rechazar. Probar +57 300 123 4567.
5. Correo sin dominio o sin @: rechazar. Probar ana@ejemplo.com.
6. Sin servicio: rechazar. Seleccionar sucesivamente los cuatro servicios y comprobar selección única.
7. Sin aceptación: rechazar; al marcarla, permitir confirmar con los demás campos válidos.
8. Comparar nombre, teléfono, correo, servicio y aceptación en confirmación. Repetir con cada servicio.
9. Volver con botón y con Atrás del sistema: conservar datos; corregir y confirmar nuevamente.
10. Girar inscripción antes de confirmar y con datos parciales: conservar texto, selección y aceptación.
11. Girar confirmación: conservar resumen; volver y comprobar formulario.
12. Con teclado abierto, pantalla horizontal y tamaño de fuente grande: alcanzar todos los campos y botones mediante desplazamiento.
13. Comprobar controles fuera de barras y recortes, en navegación por gestos y tres botones; revisar tema claro y oscuro.
14. Salir: cerrar toda la tarea. Abrir desde el lanzador: formulario nuevo.
15. Recrear Activities mediante opciones de desarrollador: verificar restauración al volver desde confirmación.
16. Modo avión: completar todo el flujo sin conexión.

## Prueba informada por el autor
El autor informó que probó la aplicación en su celular. No detalló los casos ejecutados ni sus resultados individuales. Por ello, la lista anterior sigue siendo un plan de verificación y no se presenta como evidencia de pruebas específicas realizadas. La sesión del IDE también registró una compilación/ejecución de app con resultado satisfactorio.

La implementación, la documentación y las verificaciones de compilación y lint contaron con asistencia de IA (Codex).
