# Recomendaciones de arquitectura para aplicaciones Android

## Tabla de contenidos
- [Introducción](#introducción)
- [Control de Dependencias: Inserción de Dependencias](#control-de-dependencias-:-inserción-de-dependencias)
- [Convenciones de Nombres: Nombrar Métodos](#convenciones-de-nombres-:-nombrar-métodos)
- [Capa de la IU: No Enviar Eventos del ViewModel a la IU](#capa-de-la-iu-:-no-enviar-eventos-del-viewmodel-a-la-iu)
- [Arquitectura en Capas: Repositorio para Exponer Datos](#arquitectura-en-capas-:-repositorio-para-exponer-datos)
- [Arquitectura en Capas: Capa de Datos Claramente Definida](#arquitectura-en-capas-:-capa-de-datos-claramente-definida)
- [Documentación](#documentación)
- [Colaboradores](#colaboradores)
- [Descargo de Responsabilidad](#descargo-de-responsabilidad)

## Introducción
Este informe destaca cinco recomendaciones esenciales para optimizar el proyecto final de la asignatura centrado en el desarrollo de una aplicación Android. Cada recomendación se basa en las directrices proporcionadas en el sitio web oficial de Android. Se presenta una decisión sobre si seguir o no cada recomendación, acompañada de una justificación que destaca su importancia en la aplicación.

## Control de Dependencias: Inserción de Dependencias
- Descripción:
  - Utilizar la inserción de dependencias, especialmente la inserción del constructor, siempre que sea posible.
- Decisión:
  - Seguir esta recomendación.
- Justificación:
  - La inserción de dependencias es crucial para la modularidad y mantenibilidad del código. Facilita la inyección de dependencias, promoviendo la cohesión y el desacoplamiento entre los componentes, mejorando así las pruebas unitarias y la detección de errores.

## Convenciones de Nombres: Nombrar Métodos
- Descripción:
  - Nombrar los métodos de manera descriptiva utilizando frases verbales, por ejemplo, "makePayment()".
- Decisión:
  - Seguir esta recomendación.
- Justificación:
  - Nombres descriptivos facilitan la comprensión y mantenimiento del código. Identificar fácilmente operaciones como solicitar adopción, hacer donaciones o pedir apadrinamiento mejora la colaboración y desarrollo del proyecto.

## Capa de la IU: No Enviar Eventos del ViewModel a la IU
- Descripción:
  - Procesar eventos directamente en el ViewModel y generar una actualización de estado en lugar de enviar eventos a la IU.
- Decisión:
  - Seguir esta recomendación.
- Justificación:
  - Procesar eventos en el ViewModel simplifica la lógica de manejo de eventos y mantiene un flujo de datos unidireccional, reduciendo la complejidad y acoplamiento en el sistema.

## Arquitectura en Capas: Repositorio para Exponer Datos
- Descripción:
  - Utilizar un repositorio para exponer datos de la aplicación, evitando que la capa de IU interactúe directamente con las fuentes de datos.
- Decisión:
  - Seguir esta recomendación.
- Justificación:
  - Un repositorio centraliza la gestión de datos, proporcionando modularidad y flexibilidad. Facilita cambios futuros en las fuentes de datos sin afectar la capa de IU.

## Arquitectura en Capas: Capa de Datos Claramente Definida
- Descripción:
  - Utilizar una capa de datos claramente definida que exponga los datos de la aplicación y contenga la mayoría de la lógica empresarial.
- Decisión:
  - Seguir esta recomendación.
- Justificación:
  - Una capa de datos bien definida mantiene organizada la lógica empresarial, permitiendo un código limpio y escalable. Facilita la gestión de información sobre animales, usuarios y diversas interacciones en el refugio de animales.

## Documentación
- [https://developer.android.com/topic/architecture/recommendations?hl=es-419&authuser=1#handle-dependencies](https://developer.android.com/topic/architecture/recommendations?hl=es-419&authuser=1#handle-dependencies)

## Colaboradores
- [Selene](https://github.com/SeleneGonzalezCurbelo)
- [Mele13](https://github.com/mele13)

## Descargo de Responsabilidad
Este repositorio se desarrolla exclusivamente con fines educativos como parte de un curso universitario.
