package com.example.ndelivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ndelivery.dao.ProductDao
import com.example.ndelivery.sampledata.sampleCandies
import com.example.ndelivery.sampledata.sampleDrinks
import com.example.ndelivery.sampledata.sampleSections
import com.example.ndelivery.ui.screens.HomeScreen
import com.example.ndelivery.ui.screens.HomeScreenUiState
import com.example.ndelivery.ui.theme.NDeliveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(Intent(this, ProductFormActivity::class.java))
                },
                content = {
                    dao.products()
                    val sections = mapOf(
                        "Todos os Produtos" to dao.products(),
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    )

                    val state = remember {
                        HomeScreenUiState()
                    }
                    HomeScreen(sections, state)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    NDeliveryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    App(
        content = {
            HomeScreen(sampleSections)
        },
    )
}