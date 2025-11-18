package com.example.appmultimedia


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//Navegamos a traves de pantallas
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Funcion de AppMultimedia
            AppMultimediaApp()                  //Llamamos a la funcion de AppMultimedia que arranca  el sistema de navegacion
        }
    }
}
// Creamos la navegacion a las pantallas
@Composable
fun AppMultimediaApp(){
//Aqui creamos el controlador de navegacion
    val navController = rememberNavController()
//Aqui creamos el host de navegacion,  que define las rutas de navegacion
    NavHost(
        navController = navController,           //Definimos el controlador de navegacion
        startDestination = "menu"                //Definimos la pantalla inicial
    ){
        composable("menu"){
            AppMultimediaMainScreen()           //LLamamos a la funcion de AppMultimediaMainScreen
        }
        composable("audio"){             //Definimos la pantalla audio
            PantallaAudio()                     //Llamamos a la funcion de PantallaAudio
        }
        composable("imagen"){           //Definimos la pantalla imagen
            PantallaImagen()                    //Llamamos a la funcion de PantallaImagen
            PantallaImagen()
        }
        composable("video"){            //Definimos la pantalla video
            PantallaVideo()                     //Llamamos a la funcion de PantallaVideo
        }
    }
}

//Creamos la funcion de AppMultimedia
@Composable //Funcion de AppMultimedia
fun AppMultimediaMainScreen() {
    // Esta pantalla sera la principal
    // Contiene el menu principal de la app
    Scaffold { innerPadding ->
        // Contenido de la pantalla
        Column (
            modifier = Modifier
                .fillMaxSize()                                  // Llena la pantalla
                .padding(innerPadding)           // Agrega relleno para que no se vea la barra de navegacion
                .padding(24.dp),                           // Agrega relleno para que no se vea el texto
            verticalArrangement = Arrangement.Center,           // Centra verticalmente el contenido
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente el contenido

        ){
            //Titulo de la pantalla
            Text(
            text = "App Multimedia",                            // Muestra el texto
            style = MaterialTheme.typography.headlineMedium,    // Estilo de texto
            modifier = Modifier.padding(bottom = 32.dp)         // Agrega relleno para que no se vea el texto
            )
            //Boton Audio
            Button(
                onClick = { /*PantallaAudio()*/ },              // Acción al hacer click en el boton de audio navega a la pantalla de audio
                modifier = Modifier                             // Modificador para el boton de audio de la app multimedia
                    .fillMaxWidth()                             // Llena el ancho del padre (la pantalla) con el boton
                    .padding(vertical = 8.dp)                   // Agrega relleno vertical para que no se vea el texto
            ){
                Text(text = "Reproducir Audio")
            }
            //Boton Imagen
            Button(
                onClick = { /*PantallaImagen()*/ },             // Acción al hacer click
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ){
                Text(text = "Ver Imagen")
            }
            // Boton Video
            Button(
                onClick = { /*PantallaVideo()*/ },              // Acción al hacer click en el boton de video navega a la pantalla de video
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ){
                Text(text = "Ver Video")
            }
        }
    }
}
// Creamos la pantalla de Audio
@Composable
fun PantallaAudio() {
    // Esta sera la pantalla de audio
    // Contiene el reproductor de audio
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Reproducir Audio",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text("Aqui ira el reproductor de audio")
    }
}

//Creamos la pantalla imagen
@Composable
fun PantallaImagen() {
    // Esta sera la pantalla de imagen
    // Contiene la imagen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ver Imagen",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text("Aqui ira la imagen")
    }
}

//Creamos la pantalla video
@Composable
fun PantallaVideo() {
    // Esta sera la pantalla de video
    // Contiene el reproductor de video
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Reproductor Video",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text("Aqui ira el reproductor de video")
    }
}

