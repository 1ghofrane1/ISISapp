package com.example.isisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource  
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.isisapp.ui.theme.ISISAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ISISAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Evènements") },
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
                    EventScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image de l'événement
        Image(
            painter = painterResource(id = R.drawable.event_isis),
            contentDescription = "Affiche événement",
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Textes descriptifs
        Text(
            text = "Où : Ecole ingénieur ISIS",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Quand : 24 octobre",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Boutons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* rien pour l’instant */ }) {
                Text("Inscription")
            }
            OutlinedButton(onClick = { /* rien pour l’instant */ }) {
                Text("Pas intéressé")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventScreenPreview() {
    ISISAppTheme {
        EventScreen()
    }
}
