package com.example.android_linkedin_ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_linkedin_ui.ui.theme.LinkedInBlue
import com.example.android_linkedin_ui.ui.theme.LinkedInBackground
import com.example.android_linkedin_ui.ui.theme.LinkedInTextSecondary

// datos para las tarjetas
data class SugerenciaRed(
    val nombre: String,
    val seguidores: String,
    val descripcion: String
)

@Composable
fun MiRedScreen(modifier: Modifier = Modifier) {

    val sugerencias = listOf(
        SugerenciaRed("username1", "4,215,866 followers", "Universidad...Viaje...Licenciatura"),
        SugerenciaRed("username2", "123,488 followers", "Docente...Ingeniero..."),
        SugerenciaRed("username3", "98.764 followers", "Universidad...Docente...Beca"),
        SugerenciaRed("username4", "5.544 followers", "Universidad...Docente...Beca"),
        SugerenciaRed("username5", "948.423 followers", "Universidad...Docente...Beca"),
        SugerenciaRed("username6", "83.732 followers", "Universidad...Docente...Beca"),
        SugerenciaRed("username7", "3.684 followers", "Universidad...Docente...Beca"),
    )

    Column(modifier = modifier.fillMaxSize().background(LinkedInBackground)) {

        // Barra de busqueda
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        // Opciones de menu
        MenuItemFila(texto = "Manage my network")
        HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
        MenuItemFila(texto = "Invitations")
        HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)

        // Titulo
        Text(
            text = "People Also Viewed",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(16.dp)
        )

        //Lista con Scroll
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sugerencias) { sugerencia ->
                TarjetaSugerencia(sugerencia)
            }
        }
    }
}

@Composable
private fun MenuItemFila(texto: String) {
    Row(
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = texto, color = LinkedInBlue, fontSize = 14.sp)
        Text(text = ">", color = Color.Gray)
    }
}

@Composable
private fun TarjetaSugerencia(sugerencia: SugerenciaRed) {
    // Estado para la interacción del botón
    var isFollowing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            // Cabecera Azul
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(LinkedInBlue)
            ) {
                Text(
                    text = "✕",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                )
            }

            // Contenido de la tarjeta
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Avatar
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .border(2.dp, Color.White, CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Nombre y seguidores
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = sugerencia.nombre, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = sugerencia.seguidores, fontSize = 10.sp, color = LinkedInTextSecondary)
                        }

                        // Botón Follow con Interacción
                        OutlinedButton(
                            onClick = { isFollowing = !isFollowing },
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                            modifier = Modifier.height(30.dp)
                        ) {
                            Text(
                                text = if (isFollowing) "Following" else "Follow",
                                fontSize = 12.sp,
                                color = if (isFollowing) Color.Gray else LinkedInBlue
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = sugerencia.descripcion, fontSize = 12.sp, color = LinkedInTextSecondary)
                }
            }
        }
    }
}