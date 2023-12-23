# Patrones de diseño Factory Method

## Tabla de contenidos
- [Introducción](#introducción)
- [Estructura de clases con patrón Factory Method](#estructura-de-clases-con-patrón-factory-method)
- [Elementos Clave de la Aplicación](#elementos-clave-de-la-aplicación)
  - [Diagrama de Clases](#diagrama-de-clases)
  - [Código de Clases](#código-de-clases)
  - [Clases](#clases)
- [Preparación para el Futuro](#preparación-para-el-futuro)
[Colaboradores](#colaboradores)
- [Descargo de Responsabilidad](#descargo-de-responsabilidad)

## Introducción
Este informe se centra en la estructura de clases de una aplicación diseñada para la gestión de notas en Kotlin, haciendo uso del patrón Factory Method. Las notas pueden ser de diferentes tipos, como texto, imagen y audio.

## Estructura de clases con patrón Factory Method
- Clase creadora
  - Creator
    - createNote: Note
    - someOperation()
- Producto
  - <<interface>> Note
    - doStuff()
- Productos concretos
  - NotaTexto: Note
  - NotaAudio: Note
  - NotaImagen: Note
- Creadores concretos
  - CreadorNotaTexto
  - CreadorNotaImagen
  - CreadorNotaAudio

## Elementos Clave de la Aplicación

### Código de Clases
Se describe la relación entre clases y métodos.

### Diagrama de Clases

### Clases
- Producto (Note):
  - Define comportamiento común.
- Productos Concretos:
  - Implementaciones específicas.
- Creadora (NoteCreator):
  - Contiene el Factory Method.
- Creadores Concretos:
  - Sobreescriben Factory Method para devolver tipo específico.

## Preparación para el Futuro
- Extensibilidad
  - Permite agreagar nuevos tipos de notas
- Modificaciones
  - Crear nueva subclase creadora y sobrescribir Factory Method.
- Nuevas clases
  - Subclase creadora y clase de producto específico.

## Colaboradores
- [Selene](https://github.com/SeleneGonzalezCurbelo)
- [Mele13](https://github.com/mele13)

## Descargo de Responsabilidad
Este repositorio se desarrolla exclusivamente con fines educativos como parte de un curso universitario.
