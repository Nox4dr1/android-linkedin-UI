package com.example.android_linkedin_ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
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

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {

    // 1. Usamos verticalScroll para que toda la pantalla se pueda desplazar
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LinkedInBackground)
            .verticalScroll(rememberScrollState())
    ) {

        // barra de busqueda
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        // post
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column {

                // Cabecera del usuario
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Avatar
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Nombre y Check Azul
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "username", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Verified",
                            tint = LinkedInBlue,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    // Botón + Follow
                    TextButton(onClick = { /* Interacción visual */ }) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = LinkedInBlue, modifier = Modifier.size(16.dp))
                        Text("Follow", color = LinkedInBlue, fontSize = 14.sp)
                    }

                    // Icono de 3 puntos
                    Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.Gray)
                }

                // Texto del post (Parte superior)
                Text(
                    text = "Este post es muy importante por que dentro contiene contenido importante. Este contecnido es importante para la gente que lo vea y crea que pueda ser reelevante",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    fontSize = 14.sp
                )

                // Imagen del post (El rectángulo azul grande)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(LinkedInBlue)
                )

                // Texto inferior del post
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Post Importante", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Si, revisar este post y leerlo con cuidado por que tiene cosas importantes que puede usted, como usario, encontrar relevante e importanto y usarlo a su guto siempre y caundo sea en algo importante, claro",
                        fontSize = 12.sp,
                        color = LinkedInTextSecondary
                    )
                }

                // Contador de Likes y Comentarios
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("👍❤️💡", fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("67", fontSize = 12.sp, color = LinkedInTextSecondary)
                    }
                    Text("19 comments • 1,999 reposts", fontSize = 12.sp, color = LinkedInTextSecondary)
                }

                HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)

                // --- BOTONES DE ACCIÓN (Like, Comment, Repost, Send) ---
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Botón Like con interacción
                    var isLiked by remember { mutableStateOf(false) }
                    AccionBoton(
                        icon = Icons.Default.ThumbUp,
                        texto = "Like",
                        isActive = isLiked,
                        onClick = { isLiked = !isLiked }
                    )

                    // Icono de comentario (Usamos Email porque es el más similar disponible)
                    AccionBoton(icon = Icons.Default.Email, texto = "Comment")

                    AccionBoton(icon = Icons.Default.Share, texto = "Repost")

                    // Icono de Send corregido
                    AccionBoton(icon = Icons.AutoMirrored.Filled.Send, texto = "Send")
                }
            }
        }
    }
}

// Composable auxiliar para los botones de acción
@Composable
fun AccionBoton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    texto: String,
    isActive: Boolean = false,
    onClick: () -> Unit = {}
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            contentColor = if (isActive) LinkedInBlue else Color.Gray
        )
    ) {
        Icon(imageVector = icon, contentDescription = texto, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = texto, fontSize = 12.sp, fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal)
    }
}
