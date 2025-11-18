# 📘 README – Creando aplicaciones con contenido multimedia (UD3)

### Asignatura: Programación Multimedia y Dispositivos Móviles
### Proyecto: Aplicación Multimedia para DreamSoftware
### Alumno: **Santiago Lafuente Hernández**

## ✅ 1. Formatos más empleados en codificación, almacenamiento y transmisión multimedia

En el desarrollo multimedia se utilizan diferentes formatos según el tipo de contenido:

- Imágenes

  - JPEG: formato comprimido con pérdida, ideal para fotografías.

  - PNG: conserva transparencia y ofrece buena calidad sin pérdida.

  - WEBP: mejor compresión, usado en apps modernas.

  - SVG: gráficos vectoriales escalables, ideales para iconos.

- Audio

  - MP3: el más utilizado, comprimido con pérdida.

  - WAV: audio sin compresión, alta calidad.

  - AAC: mejor calidad que MP3 a igual bitrate.

  - OGG: libre y eficiente.

- Vídeo

  - MP4 (H.264 / H.265): estándar actual en móviles.

  - WebM: formato libre para streaming.

  - AVI: antiguo, sin optimización.

  - Transmisión digital

  - HLS: streaming adaptable, usado por YouTube.

  - RTMP: transmisión en directo de baja latencia.

  - DASH: streaming moderno basado en segmentos.

## ✅ 2. Diferenciación de entornos de desarrollo

En el desarrollo móvil existen distintos enfoques:

- **Desarrollo nativo**

  - Android: Kotlin / Java

  - iOS: Swift

  - Mejor rendimiento y acceso directo al hardware.

- **Multiplataforma**

  - Flutter (Dart): un único código para Android e iOS.

  - React Native: usa JavaScript.

  - Xamarin / MAUI: usa C#.

  - Permiten desarrollar más rápido sacrificando algo de rendimiento.

- **Web móvil / híbrido**

  - Tecnologías web dentro de un contenedor (WebView).

## ✅ 3. Tipos de contenido multimedia

Una aplicación de formación puede incluir:

- **Imágenes**

  - Fotografías, ilustraciones, gráficos, diagramas.

- **Audio**

  - Narraciones, podcasts, efectos, explicaciones habladas.

- **Vídeo**

- Clases grabadas, presentaciones, tutoriales.

- **Animaciones**

  - Elementos visuales que ayudan a comprender conceptos.

- **Contenido interactivo**

  - Botones, gestos, formularios, quiz, etc.

## ✅ 4. Clases que permiten reproducción, creación, captura y almacenamiento multimedia en Android

Android ofrece varias clases ya integradas:

- **Reproducción**

  - MediaPlayer: reproduce audio y vídeo de forma sencilla.

  - ExoPlayer: reproductor avanzado recomendado por Google.

  - VideoView: widget sencillo para vídeo.

- **Creación y captura**

  - CameraX / Camera2: captura fotos y vídeo.

  - MediaRecorder: grabación de audio y vídeo.

- **Procesamiento**

  - Bitmap: manipulación de imágenes.

  - Canvas y Paint: dibujo 2D.

  - MediaCodec: codificación/decodificación de medios.

- **Almacenamiento**

  - File, InputStream, OutputStream: guardado en memoria interna/externa.

  -   MediaStore: gestión de archivos multimedia del dispositivo.

## ✅ 5. Animaciones y figuras gráficas
- **Figuras gráficas 2D**

  - Se crean con Canvas y Paint.

  - Se utilizan para: diagramas, barras de progreso, elementos decorativos.

- **Animaciones**

  - Hacen la app más intuitiva.

  - Se crean con:

    -   animateFloatAsState, AnimatedVisibility (Jetpack Compose).

    - ObjectAnimator (Android tradicional).

- **Importancia:**

  - Guían la atención del usuario.

  - Mejoran la experiencia sin saturar la interfaz.

## ✅ 6. Conversión y transformación de datos multimedia
- **Conversión**

- Transformar un medio a otro formato (p.ej., MP3 → WAV).
  - Se usa para:

    -   Reducir tamaño.

    - Mejorar compatibilidad.

    -   Adecuar archivos para streaming.

- Ejemplos reales:

  - Convertir vídeos MP4 a WebM para ahorrar espacio.

  -   Pasar imágenes PNG a WEBP para apps móviles.

- **Transformación de fuentes de datos**

  - Modificar el contenido multimedia:

    -   Cambiar resolución.

    -   Reducir bitrate.

    -   Aplicar filtros.

    - Recortar o comprimir.

## ✅ 7. Control y gestión de eventos

- Una app multimedia gestiona eventos como:

  -   Play / Pause

  -   Stop

  -   Fin de reproducción

  - Error del reproductor

  - Tocando la pantalla

  - Cambios de volumen

  -   Rotación del dispositivo

- Android usa:

  -   Listeners como setOnCompletionListener

  - Callbacks
  - StateFlow / LiveData en apps modernas

Los eventos permiten controlar la app en tiempo real.

## ✅ 8. Cómo crear una app con reproductor multimedia

- Componentes básicos:

  1. Pantallas para audio, imagen y vídeo

  2. MediaPlayer para audio

  3. VideoView + MediaController para vídeo

  4. Navegación con:

     - NavHost

     -   composable { }

     - rememberNavController()

  5. Archivos multimedia en res/raw y res/drawable

## ✅ 9. Interfaz de usuario adaptativa

- **Características de una UI adaptativa:**

  - Ajuste automático para pantallas pequeñas y grandes.

  - Botones con fillMaxWidth().

  - Uso de Column, Row, Box con Modifier.

  - Espaciados correctos con dp.

  - Uso de Material 3 (colores, tipografías, temas).

  - Mantener márgenes amplios para accesibilidad.

## ✅ 10. Importancia de depuración y pruebas

- **Depuración**

  - Permite detectar:

    - errores lógicos

    - fallos de reproducción

    - rutas mal configuradas

    - crashes en dispositivos reales

- **Herramientas:**

  - Logcat

  - Depurador de Android Studio

  - inspectores de memoria

- **Pruebas**

  - Debe probarse en:

    - diferentes tamaños de pantalla

    - versiones distintas de Android

    - emulador y dispositivo físico

    - con red lenta o sin conexión

    - Garantiza que la app funciona en cualquier situación.

## ✅ 11. Importancia de documentar el software

- **Documentar permite:**

  - que otros desarrolladores entiendan el proyecto

  - facilitar mantenimiento futuro

  - entregar un trabajo profesional

  - explicar decisiones técnicas tomadas

  - justificar el diseño y la arquitectura

- **Tipos de documentación útiles:**

  - README

  - comentarios en el código

  - diagramas

  - explicación de pantallas y navegación

## 📚 Bibliografía / Fuentes utilizadas

- Documentación oficial de Android Developers:
https://developer.android.com

- Guía oficial de Jetpack Compose:
https://developer.android.com/jetpack/compose

- MediaPlayer y VideoView (Google):
https://developer.android.com/guide/topics/media

- Flutter & multiplataforma (referencia general):
https://flutter.dev/docs

- Material Design 3 Guidelines:
https://m3.material.io

- W3C Multimedia Formats:
https://www.w3.org/TR

- AndroidX Navigation:
https://developer.android.com/guide/navigation