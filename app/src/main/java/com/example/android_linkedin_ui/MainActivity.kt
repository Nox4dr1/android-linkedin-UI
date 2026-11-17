package com.example.android_linkedin_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_linkedin_ui.ui.theme.AndroidlinkedinUITheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.android_linkedin_ui.ui.screens.InicioScreen
import com.example.android_linkedin_ui.ui.screens.MiRedScreen
import com.example.android_linkedin_ui.ui.screens.NotificacionesScreen
import com.example.android_linkedin_ui.ui.screens.PerfilScreen
import com.example.android_linkedin_ui.ui.theme.AndroidlinkedinUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidlinkedinUITheme {
                LinkedInApp()
            }
        }
    }
}

@Composable
fun LinkedInApp() {
    var pestanaActual by rememberSaveable { mutableIntStateOf(0) }
    val titulos = listOf("Inicio", "Mi red", "Notificaciones", "Perfil")
    val iconos = listOf(
        Icons.Filled.Home,
        Icons.Filled.Person,
        Icons.Filled.Notifications,
        Icons.Filled.AccountCircle
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                titulos.forEachIndexed { i, titulo ->
                    NavigationBarItem(
                        selected = pestanaActual == i,
                        onClick = { pestanaActual = i },
                        icon = { Icon(iconos[i], contentDescription = titulo) },
                        label = { Text(titulo) }
                    )
                }
            }
        }
    ) { innerPadding ->
        val mod = Modifier.padding(innerPadding)
        when (pestanaActual) {
            0 -> InicioScreen(mod)
            1 -> MiRedScreen(mod)
            2 -> NotificacionesScreen(mod)
            3 -> PerfilScreen(mod)
        }
    }
}