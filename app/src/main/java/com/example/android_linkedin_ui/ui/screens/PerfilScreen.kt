package com.example.android_linkedin_ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_linkedin_ui.ui.theme.AndroidlinkedinUITheme
import com.example.android_linkedin_ui.ui.theme.LinkedInBackground

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
            Text("Encabezado")
            Text("Datos")
            Text("Botones")
        }
        Text("Acerca de")
        Text("Experiencia")
    }
}

    @Preview(showBackground = true)
    @Composable
    private fun PerfilScreenPreview() {
        AndroidlinkedinUITheme {
            PerfilScreen()
        }
    }

