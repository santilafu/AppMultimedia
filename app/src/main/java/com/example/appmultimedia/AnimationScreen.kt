package com.example.appmultimedia.ui.theme

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appmultimedia.R

@Composable
fun AnimationScreen(navController: NavHostController) {

    // Animación simple de zoom (escala)
    val scale = remember {
        Animatable(1f)
    }

    // Lanza animación infinita
    LaunchedEffect(Unit) {
        while (true) {
            scale.animateTo(
                1.3f,
                animationSpec = tween(900)
            )
            scale.animateTo(
                1f,
                animationSpec = tween(900)
            )
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
            text = "Animación 2D",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Imagen que se anima con escala
        Image(
            painter = painterResource(id = R.drawable.kotlin),
            contentDescription = "Animación",
            modifier = Modifier
                .size(200.dp)
                .scale(scale.value)
        )

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Volver")
        }
    }
}
