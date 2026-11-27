# Gestor de Tareas Grid y CRUD

## Descripcion
Aplicacion web en Vaadin con tabla Grid, formulario con Binder y crud completo para manejar tareas en memoria.

## Como ejecutar
mvn spring-boot:run
# Abrir http://localhost:8080

## Estructura
com.tareas.Tarea
record inmutable con id, dsc y comp
com.tareas.views.TareaEditable
clase mutable para que funcione el Binder
com.tareas.views.TareasView
vista principal con Grid y formulario

## Nota
Se usa TareaEditable por que el record es inmutable y el Binder necesita setters. Al reiniciar se pierden los datos por que estan en memoria.
