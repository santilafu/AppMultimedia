package com.example.appmultimedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmultimedia.ui.theme.AppMultimediaTheme
import com.example.appmultimedia.ui.theme.AudioScreen
import com.example.appmultimedia.ui.theme.ImageScreen
import com.example.appmultimedia.ui.theme.VideoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMultimediaTheme {
                AppMultimediaApp()
            }
        }
    }
}

@Composable
fun AppMultimediaApp() {
    // Controlador de navegación
    val navController = rememberNavController()

    // Definimos las pantallas de la app
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") {
            MainMenuScreen(navController)
        }
        composable("audio") {
            AudioScreen(navController)
        }
        composable("imagen") {
            ImageScreen(navController)
        }
        composable("video") {
            VideoScreen(navController)
        }
        // Más adelante podríamos usar:
        // composable("animacion") { AnimationScreen(navController) }
    }
}

@Composable
fun MainMenuScreen(navController: NavHostController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "App Multimedia",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = { navController.navigate("audio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Reproducir audio")
            }

            Button(
                onClick = { navController.navigate("imagen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Ver imagen")
            }

            Button(
                onClick = { navController.navigate("video") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Ver vídeo")
            }
        }
    }
}
