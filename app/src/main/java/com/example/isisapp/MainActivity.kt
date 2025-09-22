package com.example.isisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.isisapp.ui.theme.ISISAppTheme
import androidx.compose.foundation.layout.padding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ISISAppTheme {
                AppNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Récupération de la route actuelle pour changer le titre
    val currentRoute = navController.currentBackStackEntry?.destination?.route ?: "event"

    val title = when (currentRoute) {
        "event" -> "Évènements"
        "inscription" -> "Inscription"
        "not_interested" -> "Pas intéressé"
        else -> "Évènements"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = { /* action menu */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* action favori */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "event",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("event") {
                EventScreen(
                    // vers IscriptionScreen
                    onInscriptionClick = { navController.navigate("inscription") },
                    // vers NotInterestedScreen
                    onNotInterestedClick = { navController.navigate("not_interested") }
                )
            }

            // la touche back
            composable("inscription") {
                InscriptionScreen(onBack = { navController.popBackStack() })
            }
            composable("not_interested") {
                NotInterestedScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}
