package com.example.isisapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InscriptionScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Écran d’inscription 📝",
            style = MaterialTheme.typography.headlineMedium
        )
        //back to initial screen
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Retour")
        }
    }
}
