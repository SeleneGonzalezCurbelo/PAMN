# CodeLab: Tu primera App para Android

Este repositorio contiene los códigos finales tras realizar el CodeLab: Unidad 1: Tu primera app para Android.

Dos proyectos de aplicaciones Android desarrolladas en Android Studio: una aplicación de una tarjeta de cumpleaños y una aplicación de tarjeta de presentación.

# Tabla de contenido
- [Tarjeta de cumpleaños](#tarjeta-de-cumpleaños)
- [Tarjeta de presentación](#tarjeta-de-presentacion)
- [Dificultades técnicas](#dificultades-técnicas)
- [Instalación](#instalación)
- [Documentación](#documentación)
- [Autor](#autor)

# Tarjeta de cumpleaños

La aplicación de tarjeta de cumpleaños permite a los usuarios crear y personalizar tarjetas de cumpleaños. La aplicación ofrece las siguientes características:
- Añadir texto personalizado y saludo
- Insertar una imagen de fondo
- Preevisualizar la tarjeta

### Capturas de Pantalla

![Preview](/Images/PreviewBirthdayCard.png)
![Final](/Images/BirthdayCard.png)

# Tarjeta de presentación

La aplicación de tarjeta de presentación permite a los usuarios crear tarjetas de presentación. Las características incluyen:
- Añadir nombre, título, número de teléfono, red social y correo electrónico.
- Insertar un logo
- Preevisualizar la tarjeta

### Capturas de Pantalla

![Preview](/Images/PreviewBusinessCard.png)
![Final](/Images/BusinessCard.png)

# Dificultades técnicas

Durante el desarrollo de estos proyectos, se presento una dificultad técnica. Al crear la aplicación de tarjeta de presentación (BusinessCard), surgió un error de versión de la API que causó problemas en la compilación.

## Error de Versión de la API en BusinessCard

Al principio, después de crear el proyecto de BusinessCard, se encontró un error relacionado con la versión de la API. Esto impidió la compilación y ejecución adecuada de la aplicación.

!(/Images/error1.png)
!(/Images/error2.png)
!(/Images/error3.png)

### Solución

Para resolver este problema, se modificó el archivo `build.gradle.kts` en el directorio de scripts (`scripts/build.gradle.kts`). Se actualizó la configuración de la API a la versión correcta y se sincronizó el proyecto. Esto permitió que la aplicación se compile y ejecute sin problemas.

!(/Images/solution.png)

## Instalación

1. Clona o descarga este repositorio.
2. Abre el proyecto correspondiente en Android Studio.
3. Configura tu dispositivo o emulador y ejecuta la aplicación.

# Documentación
- [https://developer.android.com/courses/android-basics-compose/unit-](https://developer.android.com/courses/android-basics-compose/unit-1?hl=es-419)
  
# Autor
Este trabajo fue realizado como parte de un proyecto dirigido para la universidad por:
- [Selene](https://github.com/SeleneGonzalezCurbelo)
