package com.example.appmultimedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Importamos las pantallas que hemos creado por separado
import com.example.appmultimedia.ui.theme.AudioScreen
import com.example.appmultimedia.ui.theme.ImageScreen
import com.example.appmultimedia.ui.theme.VideoScreen
import com.example.appmultimedia.ui.theme.AnimationScreen
import com.example.appmultimedia.ui.theme.AppMultimediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ajusta la pantalla para usar toda la zona visible del móvil
        enableEdgeToEdge()

        // Aquí cargamos toda la interfaz usando Jetpack Compose
        setContent {
            AppMultimediaTheme {
                AppMultimediaApp() // Llamamos a la función que maneja toda la navegación
            }
        }
    }
}

@Composable
fun AppMultimediaApp() {

    // Controlador de navegación (permite cambiar entre pantallas)
    val navController = rememberNavController()

    // Lista de pantallas disponibles en la app
    NavHost(
        navController = navController,
        startDestination = "menu"  // Pantalla que se abre al iniciar la app
    ) {
        // Pantalla principal
        composable("menu") {
            MainMenuScreen(navController)
        }

        // Pantalla de audio
        composable("audio") {
            AudioScreen(navController)
        }

        // Pantalla de imagen
        composable("imagen") {
            ImageScreen(navController)
        }

        // Pantalla de vídeo
        composable("video") {
            VideoScreen(navController)
        }

        // Pantalla de animación
        composable("animacion") {
            AnimationScreen(navController)
        }
    }
}

@Composable
fun MainMenuScreen(navController: NavHostController) {

    // Scaffold permite tener una estructura base: barras, cuerpo, etc.
    Scaffold { innerPadding ->

        // Columna para colocar elementos uno debajo de otro
        Column(
            modifier = Modifier
                .fillMaxSize()      // Ocupa toda la pantalla
                .padding(innerPadding)
                .padding(24.dp),     // Espacio interno general
            verticalArrangement = Arrangement.Top,            // Alinea elementos arriba
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
        ) {

            // Título principal
            Text(
                text = "App Multimedia",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Botón que abre la pantalla de audio
            Button(
                onClick = { navController.navigate("audio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Reproducir audio")
            }

            // Botón que abre la pantalla de imagen
            Button(
                onClick = { navController.navigate("imagen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Ver imagen")
            }

            // Botón que abre la pantalla de vídeo
            Button(
                onClick = { navController.navigate("video") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Ver vídeo")
            }

            // Botón que abre la pantalla de animación
            Button(
                onClick = { navController.navigate("animacion") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Animación 2D")
            }
        }
    }
}
