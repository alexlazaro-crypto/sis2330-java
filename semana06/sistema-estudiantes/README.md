# Sistema de Estudiantes con Maven y JUnit 5

## Descripcion
Proyecto Maven para gestionar estudiantes con registro, busqueda por codigo, actualizacion de promedio, eliminacion, ranking descendente, top N y suite de pruebas automatizadas con JUnit 5.

## Como compilar, testear y empaquetar
* Ejecutar pruebas con Maven: `mvn test`
* Empaquetar el proyecto en jar: `mvn clean package`
* Ejecutar el jar generado con Java 21: `"$JAVA_HOME/bin/java" -jar target/sistema-estudiantes-1.0.0.jar`

## Tests incluidos
* `registrarEstudianteNuevoDevuelveTrue` verifica el registro de un estudiante nuevo valido.
* `registrarCodigoDuplicadoDevuelveFalse` comprueba que no se registre un codigo repetido.
* `buscarPorCodigoExistenteDevuelveEstudiante` valida la consulta de un estudiante registrado.
* `buscarPorCodigoInexistenteDevuelveNull` revisa el comportamiento al buscar un codigo que no existe.
* `actualizarPromedioDeEstudianteExistenteDevuelveTrue` verifica la modificacion del promedio y su nuevo valor.
* `actualizarPromedioDeEstudianteInexistenteDevuelveFalse` comprueba que actualizar un codigo inexistente devuelve false.
* `eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking` valida la eliminacion del mapa y del ranking.
* `listarRankingConColeccionVaciaDevuelveListaVacia` prueba el caso borde cuando no hay estudiantes registrados.
* `listarRankingOrdenaPorPromedioDescendente` verifica el orden de mayor a menor promedio.
* `topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion` comprueba el caso borde cuando `n` supera la cantidad total de estudiantes.

## Resultado de mvn test
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
