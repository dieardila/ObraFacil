# ObraFacil
Aplicación Android independiente en Java y XML. Propuesta académica para registrar el interés en servicios de remodelación.

## Motivación y alcance
Las remodelaciones permiten conservar viviendas, mejorar espacios y atender necesidades cotidianas. El proyecto explora cómo una interfaz sencilla puede organizar el primer contacto entre una persona y los servicios de pintura, plomería, electricidad y remodelación general.
Es un prototipo académico: no ofrece contratación real, cotizaciones, profesionales verificados, pagos ni envío de solicitudes.

## Uso
1. Presentación: nombre, ilustración vectorial local, descripción y Comenzar.
2. Inscripción: nombre, teléfono, correo, un servicio y aceptación obligatoria.
3. Confirmación: muestra los cinco datos recibidos mediante Intent. Volver permite corregir; Salir ejecuta finishAffinity().

## Arquitectura
Tres Activities reales: MainActivity, InscripcionActivity y ConfirmacionActivity.
Layouts XML con ScrollView y LinearLayout; recursos de texto en strings.xml.
El formulario se conserva con onSaveInstanceState y restauración de vistas al recrear la Activity. Volver cierra la confirmación sin recrear el formulario.
No se usan bases de datos, archivos de registro, preferencias ni red. Bundle e Intent contienen únicamente estado transitorio administrado por Android; no constituyen almacenamiento permanente.
ScrollView permite desplazamiento; adjustResize y WindowInsetsCompat consideran teclado, barras y recortes. No se bloquea la orientación.

## Compilar
Desde la raíz en Windows:
` .\gradlew.bat assembleDebug `
` .\gradlew.bat lintDebug `

APK esperado: app/build/outputs/apk/debug/app-debug.apk.
Informe lint: app/build/reports/lint-results-debug.html.
Consulta PRUEBAS_MANUALES.md para distinguir verificaciones ejecutadas y pendientes.

## Asistencia de IA y validación
Se utilizó asistencia de inteligencia artificial (Codex) para implementar código Java, layouts y recursos XML, preparar documentación y ejecutar verificaciones de compilación y análisis estático. Se declara esta asistencia de forma transparente en el alcance académico del proyecto.
El autor informó que probó la aplicación en su celular. No se especificaron los casos de esa prueba; por tanto, no se atribuyen resultados a escenarios concretos de navegación, validación, rotación o teclado.

## Entrega individual
Repositorio privado: https://github.com/dieardila/ObraFacil
La guía académica indica compartir el proyecto individual solo con el docente. Mantenerlo privado y conceder acceso únicamente al docente correspondiente; no se han añadido colaboradores automáticamente.
El repositorio conserva fuentes, recursos, manifiesto, configuración Gradle y Gradle Wrapper. Excluye claves, configuración local del equipo y archivos generados mediante .gitignore.
