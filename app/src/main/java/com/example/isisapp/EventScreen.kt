package com.example.isisapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun EventScreen(
    modifier: Modifier = Modifier,
    onInscriptionClick: () -> Unit,
    onNotInterestedClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //image url
        AsyncImage(
            model = "https://blogs.univ-jfc.fr/archampo/wp-content/uploads/sites/125/2024/03/2010campus-de-la-borde-basse-castres-universit-champollion_11977849535_o.jpg",
            contentDescription = "Affiche événement",
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Où : Ecole ingénieur ISIS", style = MaterialTheme.typography.bodyLarge)
        Text("Quand : 24 octobre", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onInscriptionClick) {
                Text("Inscription")
            }
            OutlinedButton(onClick = onNotInterestedClick) {
                Text("Pas intéressé")
            }
        }
    }
}

