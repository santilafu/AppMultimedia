package com.example.appmultimedia.ui.theme

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appmultimedia.R

@Composable
fun AudioScreen(navController: NavHostController) {

    // MediaPlayer se declara como estado para poder recrearlo
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Reproductor de Audio",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // BOTÓN REPRODUCIR
        Button(
            onClick = {
                // Si ya hay un reproductor, lo paramos y lo borramos
                mediaPlayer?.release()

                // Creamos uno nuevo
                mediaPlayer = MediaPlayer.create(navController.context, R.raw.introentera)

                // Lo arrancamos
                mediaPlayer?.start()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reproducir audio")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // BOTÓN PARAR
        Button(
            onClick = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Detener audio")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al menú")
        }
    }
}
