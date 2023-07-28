package com.example.ndelivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ndelivery.dao.ProductDao
import com.example.ndelivery.ui.screens.ProductFormScreen
import com.example.ndelivery.ui.theme.NDeliveryTheme

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ProductFormScreen(onProductSave = { product ->
                        dao.save(product)
                        finish()
                    })

                }
            }
        }
    }
}


