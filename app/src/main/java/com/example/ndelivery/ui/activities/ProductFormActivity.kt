package com.example.ndelivery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndelivery.model.Product
import com.example.ndelivery.ui.theme.NDeliveryTheme
import java.math.BigDecimal

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
                    ProductFormScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        Text(
            text = "Criando o produto",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp
        )

        var url by remember { mutableStateOf("") }
        TextField(value = url, modifier = Modifier.fillMaxWidth(), label = {
            Text("Url da imagem")
        }, onValueChange = {
            url = it
        })

        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nome")
            },
            onValueChange = {
                name = it
            }
        )

        var price by remember { mutableStateOf("") }
        TextField(
            value = price,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Preço")
            },
            onValueChange = {
                price = it
            }
        )

        var description by remember { mutableStateOf("") }
        TextField(
            value = description,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = {
                Text("Descrição")
            },
            onValueChange = {
                description = it
            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val price = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }

                val product = Product(
                    name = name,
                    image = url,
                    price = price,
                    description = description
                )
                Log.i("ProductFormScreen", "ProductFormScreen: Product -> $product")
            },
        ) {
            Text("Salvar")
        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun ProductFormScreenPreview() {
    NDeliveryTheme {
        Surface() {
            ProductFormScreen()
        }
    }
}