package com.example.casestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.casestudy.ui.theme.CasestudyTheme
import androidx.compose.material3.TopAppBarDefaults

class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasestudyTheme(dynamicColor = false) {
                FavoritesScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen() {
    val colors = MaterialTheme.colorScheme
    val favorites = listOf(
        "Strawberry Ube Cake",
        "Banana Fritters",
        "Ube Cheesecake",
        "Chocolate Pandesal",
        "Matcha Latte"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites", color = colors.onPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.primary,
                    titleContentColor = colors.onPrimary
                )
            )
        },
        containerColor = colors.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(favorites) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = colors.secondaryContainer)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp),
                        color = colors.onSecondaryContainer
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    CasestudyTheme(dynamicColor = false) {
        FavoritesScreen()
    }
}
