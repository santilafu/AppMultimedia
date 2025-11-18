package com.example.appmultimedia.ui.theme

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.appmultimedia.R

@Composable
fun VideoScreen(navController: NavHostController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Reproductor de Video",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // 🔥 Aquí metemos el reproductor de vídeo REAL
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            factory = { ctx ->
                VideoView(ctx).apply {

                    val videoUri = Uri.parse("android.resource://${ctx.packageName}/${R.raw.prueba1}")
                    setVideoURI(videoUri)

                    val controller = MediaController(ctx)
                    controller.setAnchorView(this)

                    setMediaController(controller)
                    start()
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al menú")
        }
    }
}
