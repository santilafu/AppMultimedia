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

    // Estado para saber si el audio se está reproduciendo
    var isPlaying by remember { mutableStateOf(false) }

    // Carga del audio desde res/raw
    val mediaPlayer = remember {
        MediaPlayer.create(navController.context, R.raw.introentera)
    }

    // Limpieza del reproductor cuando salimos de la pantalla
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Reproductor de Audio",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                // Reproducimos o pausamos según el estado
                if (!isPlaying) {
                    mediaPlayer.start()
                } else {
                    mediaPlayer.pause()
                }
                isPlaying = !isPlaying
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(if (isPlaying) "Pausar" else "Reproducir")
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Volver")
        }
    }
}
