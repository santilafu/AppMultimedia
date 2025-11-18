package com.example.appmultimedia.ui.theme

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appmultimedia.R

@Composable
fun VideoScreen(navController: NavHostController) {

    val context = LocalContext.current

    // Ruta del vídeo dentro de res/raw
    val videoUri = Uri.parse("android.resource://${context.packageName}/${R.raw.prueba1}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Reproductor de Vídeo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Componente VideoView de Android dentro de Compose
        AndroidView(
            factory = {
                VideoView(context).apply {

                    val mediaController = MediaController(context)
                    mediaController.setAnchorView(this)

                    setMediaController(mediaController)
                    setVideoURI(videoUri)
                    requestFocus()
                    start()  // inicia el vídeo automáticamente
                }
            },
            modifier = Modifier.height(250.dp)
        )

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Volver")
        }
    }
}
