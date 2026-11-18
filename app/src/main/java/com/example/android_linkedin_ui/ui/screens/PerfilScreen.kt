package com.example.android_linkedin_ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_linkedin_ui.ui.theme.AndroidlinkedinUITheme
import com.example.android_linkedin_ui.ui.theme.LinkedInBackground
import com.example.android_linkedin_ui.ui.theme.LinkedInBlue
import com.example.android_linkedin_ui.ui.theme.LinkedInDarkBlue

@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LinkedInBackground)
            .verticalScroll(rememberScrollState())
    ) {
        //PAL BLOQUE blanco
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            EncabezadoPerfil()
            Text("Datos")
            Text("Botones")
        }
        Text("Acerca de")
        Text("Experiencia")
    }
}

//para el encabezado

@Composable
private fun EncabezadoPerfil() {
    Box(modifier = Modifier.fillMaxWidth()) {
        //esto para el banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(LinkedInDarkBlue)
        )
        //Para la foto del usuario
        Box(
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp)
                .size(100.dp)
                .clip(CircleShape) //para hacer el circulo del perfil
                .background(LinkedInBlue)
                .border(4.dp, Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("PP", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PerfilScreenPreview() {
    AndroidlinkedinUITheme {
        PerfilScreen()
    }
}

