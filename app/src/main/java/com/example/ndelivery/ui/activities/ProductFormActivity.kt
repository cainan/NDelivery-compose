package com.example.ndelivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ndelivery.ui.screens.ProductFormScreen
import com.example.ndelivery.ui.theme.NDeliveryTheme
import com.example.ndelivery.ui.viewmodel.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel by viewModels<ProductFormScreenViewModel>()
                    ProductFormScreen(viewModel = viewModel, onSaveClick = {
                        finish()
                    })
                }
            }
        }
    }
}


