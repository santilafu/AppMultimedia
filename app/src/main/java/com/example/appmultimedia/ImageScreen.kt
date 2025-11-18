package com.example.appmultimedia.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appmultimedia.R

@Composable
fun ImageScreen(navController: NavHostController) {

    // Pantalla simple que muestra una imagen de drawable
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Imagen de ejemplo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.kotlin),
            contentDescription = "Imagen de ejemplo"
        )

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Volver")
        }
    }
}
