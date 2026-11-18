package com.example.android_linkedin_ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_linkedin_ui.R
import com.example.android_linkedin_ui.ui.theme.AndroidlinkedinUITheme
import com.example.android_linkedin_ui.ui.theme.LinkedInBackground
import com.example.android_linkedin_ui.ui.theme.LinkedInBlue
import com.example.android_linkedin_ui.ui.theme.LinkedInDarkBlue
import com.example.android_linkedin_ui.ui.theme.LinkedInTextSecondary

//datos, no textos fijos de la interfaz,
private data class ElementoPerfil(val titulo: String, val lugar: String, val periodo: String)

private val experiencias = listOf(
    ElementoPerfil("Docente", "UPB", "  Actualidad"),
    ElementoPerfil("Jefe de Innovación Tecnológica", "Droguería INTI SA", "2021 – Actualidad")
)

private val estudios = listOf(
    ElementoPerfil("Principios SOLID y Clean Code", "DevTalles", "2023"),
    ElementoPerfil("Dart: De cero hasta los detalles", "DevTalles", "2023")
)

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
            DatosPerfil()
            BotonesPerfil()
            AcercaDe()
        }
        SeccionPerfil(stringResource(R.string.experiencia_titulo_perfil)) {
            experiencias.forEach { ItemPerfil(it) }
        }
        SeccionPerfil(stringResource(R.string.educacion_titulo_perfil)) {
            estudios.forEach { ItemPerfil(it) }
        }
    }
        Spacer(modifier = Modifier.height(16.dp))
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
            Text("JH", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun DatosPerfil() {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            stringResource(R.string.nombre_perfil),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            stringResource(R.string.descrip_perfil),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            stringResource(R.string.lugar_perfil),
            color = LinkedInTextSecondary,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            stringResource(R.string.contactos_perfil),
            style = MaterialTheme.typography.bodyMedium,
            color = LinkedInBlue,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun BotonesPerfil() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = LinkedInBlue)
        ) {
            Text("Tengo interés en ...")
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier.weight(1f)
        ) {
            Text("Añadir sección")
        }
    }
}

@Composable
private fun SeccionPerfil(titulo: String, contenido: @Composable () -> Unit) {
    //la tarjeta recibe un pedazo de interfaz como parámetro. La tarjeta pone el marco y el título
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            contenido()
        }
    }
}

@Composable
private fun ItemPerfil(item: ElementoPerfil) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(LinkedInBackground)
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
                item.titulo,
                fontWeight = FontWeight.Bold
            )
            Text(
                item.lugar,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                item.periodo,
                style = MaterialTheme.typography.bodySmall,
                color = LinkedInTextSecondary
            )
        }
    }
}


// Sección "Acerca de" que muestra una breve descripción con opción de expandir/contraer
@Composable
private fun AcercaDe() {
    // Estado para recordar si el texto está expandido (true) o contraído (false)
    var expandido by remember { mutableStateOf(false) }

    // Obtiene el texto descriptivo del perfil desde los recursos de strings (strings.xml)
    val texto = stringResource(R.string.acerca_de_perfil)

    // Componente reutilizable para envolver la sección con su título correspondiente
    SeccionPerfil(stringResource(R.string.acerca_de_titulo_perfil)) {
        // Muestra el texto de la descripción
        Text(
            text = texto,
            // Si está expandido muestra todo el texto, si no solo muestra un máximo de 2 líneas
            maxLines = if (expandido) Int.MAX_VALUE else 2,
            // Agrega puntos suspensivos (...) al final si el texto excede el límite de líneas
            overflow = TextOverflow.Ellipsis
        )

        // Botón para alternar el estado de expansión al hacer clic
        TextButton(onClick = { expandido = !expandido }) {
            // Cambia el texto del botón dinámicamente entre "Ver menos" y "Ver más"
            Text(
                if (expandido) stringResource(R.string.ver_menos_perfil)
                else stringResource(R.string.ver_mas_perfil)
            )
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

