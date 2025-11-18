# 📱 App Multimedia – Documentación Técnica (README Técnico)

Este documento explica la estructura, funcionamiento y diseño técnico de la aplicación App Multimedia, desarrollada en Kotlin + Jetpack Compose.
La app reproduce audio, muestra una imagen, reproduce un vídeo y tiene una animación simple.

## 📌 1. Arquitectura general

La aplicación sigue una estructura simple:
````
app/
└── src/main/java/com/example/appmultimedia/
├── MainActivity.kt
├── ui/
│     ├── AudioScreen.kt
│     ├── ImageScreen.kt
│     ├── VideoScreen.kt
│     ├── AnimationScreen.kt
└── theme/ (tema de Material 3)
````
- **MainActivity.kt**

  - Es el punto de entrada.

  - Configura el tema.

  - Llama a AppMultimediaApp(), donde está la navegación.

- **Pantallas**

  - Cada pantalla se separa en un archivo individual para mantener claridad:
### Archivos de pantallas

| Archivo             | Función                                            |
|---------------------|----------------------------------------------------|
| `AudioScreen.kt`    | Reproduce audio usando `MediaPlayer`.              |
| `ImageScreen.kt`    | Muestra una imagen desde `drawable`.               |
| `VideoScreen.kt`    | Reproduce vídeo con `VideoView` + `MediaController`. |
| `AnimationScreen.kt`| Muestra una animación usando `animateFloatAsState`. |


## 📌 2. Navegación entre pantallas

Se utiliza Navigation Compose, la forma actual recomendada por Android.

**Controlador**
```kotlin
val navController = rememberNavController()
```
**Rutas definidas**
```kotlin
NavHost(
navController = navController,
startDestination = "menu"
) {
composable("menu") { MainMenuScreen(navController) }
composable("audio") { AudioScreen(navController) }
composable("imagen") { ImageScreen(navController) }
composable("video") { VideoScreen(navController) }
composable("animacion") { AnimationScreen(navController) }
}
```
**Ventajas**

- Código organizado.

- Fácil añadir nuevas pantallas.

- Navegación sencilla con:
```kotlin
navController.navigate("audio")
```

## 📌 3. Pantalla principal (MainMenuScreen)

Contiene los botones que navegan a cada sección:
```kotlin
Button(onClick = { navController.navigate("audio") }) { ... }
Button(onClick = { navController.navigate("imagen") }) { ... }
Button(onClick = { navController.navigate("video") }) { ... }
Button(onClick = { navController.navigate("animacion") }) { ... }
```

Los botones ocupan todo el ancho para mejor accesibilidad.

## 📌 4. Reproductor de audio (AudioScreen)

Se usa **MediaPlayer**, la clase oficial e integrada en Android.
```kotlin
val mediaPlayer = MediaPlayer.create(context, R.raw.audio_demo)
```

- **Incluye:**

  - Botón "Reproducir"

  - Botón "Pausar"

  - Botón "Detener"

  - Control de estados para evitar errores 
  - Liberación de recursos con mediaPlayer.release() (fundamental)

## 📌 5. Visualización de imágenes (ImageScreen)

Carga una imagen desde /res/drawable:
```kotlin
Image(
painter = painterResource(id = R.drawable.foto_demo),
contentDescription = null
)

```
- **Todo optimizado con Compose:**

  - Se adapta al espacio

  - Respeta márgenes de 24dp

  - Centrada vertical y horizontalmente

## 📌 6. Reproductor de vídeo (VideoScreen)

Aquí se usa un componente Android tradicional dentro de Compose:
```kotlin
AndroidView(factory = { context ->
VideoView(context).apply {
setVideoURI(videoUri)
setMediaController(MediaController(context).also { it.setAnchorView(this) })
start()
}
})
```

- Características:

  - Reproducción en pantalla completa de forma automática

  - Controles clásicos (play, pausa, avance)

  - Compatibilidad universal

## 📌 7. Pantalla de animación (AnimationScreen)

Se usa Jetpack Compose para animar valores:
```kotlin
val alpha by animateFloatAsState(
targetValue = if (visible) 1f else 0f,
animationSpec = tween(1500)
)
```
- **Imagen animada:**

  - Se desvanece con un Fade In / Fade Out

  -   Se controla con un botón

- **Ideal para mostrar:**

  - Notificaciones visuales

  - Efectos de entrada

  - Señales importantes en la UI

## 📌 8. Recursos multimedia utilizados
### Carpeta drawable

- **Contiene:**

  - kotlin.png

  - Iconos o imágenes necesarias

### Carpeta raw

- **Contiene:**

  - introentera.mp3

  - prueba1.mp4

Estas carpetas permiten que el contenido venga dentro de la app, sin necesidad de internet.

## 📌 9. Diseño adaptativo

- **La app usa:**

  - fillMaxWidth() para que los botones se adapten

  -    Column() centrada

  - Padding constante de 24dp

  - Tipografías Material 3

  - Vídeo ajustado con AndroidView

- **Beneficios:**

  - Funciona igual en móviles pequeños y grandes

  - Interfaz limpia para cursos o aprendizaje

## 📌 10. Buenas prácticas aplicadas

#### ✔ Separación de pantallas
#### ✔ Navegación limpia
#### ✔ Recursos bien organizados
#### ✔ Gestión correcta de MediaPlayer
#### ✔ Comentarios en todo el código
#### ✔ Diseño Material 3
#### ✔ Animación simple pero funcional
#### ✔ Proyecto apto para añadir más módulos multimedia en el futuro

## 📌 11. Mejoras futuras

- La arquitectura permite añadir:

  - Streaming de audio online

  - MotionLayout para animaciones avanzadas

  - Descarga de contenidos multimedia

  - Soporte para GIF

  - Panel de progreso del audio

  - Pantallas responsivas para tablet

## 📌 12. Conclusión técnica

La aplicación cumple todos los objetivos:

- Usa MediaPlayer, VideoView, Navigation y Animations

- Gestiona audio, imagen, vídeo y animación

- Está estructurada de forma clara

- Es mantenible, ampliable y documentada

- Sigue las recomendaciones de Android Developers

## 📚 Bibliografía Técnica

- Android Developers – MediaPlayer
https://developer.android.com/guide/topics/media

- VideoView Documentation
https://developer.android.com/reference/android/widget/VideoView

- Jetpack Compose Navigation
https://developer.android.com/jetpack/compose/navigation

- Compose Animation Docs
https://developer.android.com/jetpack/compose/animation

- Material 3
https://m3.material.io/