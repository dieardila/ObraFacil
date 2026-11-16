# Guía de explicación
## Interés en el sector
La mejora de viviendas reúne oficios esenciales y necesidades frecuentes. ObraFacil propone ordenar la información inicial de una persona interesada, reduciendo omisiones al seleccionar un servicio. La motivación académica es aplicar navegación, formularios y ciclo de vida a un problema cercano.

## Recorrido del código
- MainActivity carga activity_main y abre InscripcionActivity con un Intent explícito.
- InscripcionActivity valida nombre, teléfono de 7 a 15 dígitos (permite prefijo + y separadores), correo con Patterns.EMAIL_ADDRESS, selección única en RadioGroup y aceptación.
- Los errores se muestran junto a los controles; se enfoca y desplaza hacia el primer campo inválido.
- ConfirmacionActivity recibe nombre, teléfono, correo, texto del servicio y booleano de aceptación mediante extras; no consulta fuentes externas.
- Volver llama finish(): reaparece el formulario que quedó en la pila. El botón Atrás del sistema tiene el mismo efecto.
- Salir llama finishAffinity(): cierra las Activities de la tarea.
- onSaveInstanceState guarda los campos y controles en Bundle. Los identificadores de las vistas también permiten a Android restaurar su estado.
- ScreenInsets incorpora barras del sistema, recortes y teclado. El padding interno permanece en el LinearLayout y el ScrollView permite alcanzar los botones.

## Alcance y límites
Es una demostración de inscripción de interés, no una inscripción enviada a una empresa. No valida propiedad del teléfono o correo ni la disponibilidad de un servicio. Los datos se pierden al finalizar la tarea; no hay registro permanente.
La imagen es un vector incluido en drawable/remodelacion.xml y funciona sin Internet.
