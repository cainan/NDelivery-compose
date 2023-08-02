package com.example.ndelivery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ndelivery.R
import com.example.ndelivery.model.Product
import com.example.ndelivery.ui.theme.NDeliveryTheme
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenUiState(
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val price: String = "",
    val onPriceChange: (String) -> Unit = {},
    val description: String = "",
    val onDescriptionChange: (String) -> Unit = {},
    val url: String = "",
    val onUrlChange: (String) -> Unit = {},
    val onSaveClick: () -> Unit = {},
) {
    fun isShowPreview(): Boolean {
        return url.isNotBlank()
    }
}

@Composable
fun ProductFormScreen(onProductSave: (Product) -> Unit) {

    var name by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var formatter = rememberSaveable { DecimalFormat("#.##") }
    var url by rememberSaveable { mutableStateOf("") }

    ProductFormScreen(
        state = ProductFormScreenUiState(
            name = name,
            onNameChange = {
                name = it
            },
            price = price,
            onPriceChange = {
                try {
                    price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if (it.isBlank()) {
                        price = it
                    }
                }
            },
            description = description,
            onDescriptionChange = {
                description = it
            },
            url = url,
            onUrlChange = {
                url = it
            },
            onSaveClick = {
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
                Log.i(
                    "ProductFormActivity",
                    "ProductFormScreen: Product -> $product"
                )

                onProductSave(product)
            },
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen(
    state: ProductFormScreenUiState = ProductFormScreenUiState(),
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        Spacer(modifier = Modifier)

        Text(
            text = "Criando o produto",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp
        )

        if (state.isShowPreview()) {
            AsyncImage(
                model = state.url,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.placeholder),
                contentDescription = null,
            )
        }

        TextField(
            value = state.url,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Url da imagem")
            },
            onValueChange = state.onUrlChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = state.name,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nome")
            },
            onValueChange = state.onNameChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        TextField(
            value = state.price,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Preço")
            },
            onValueChange = state.onPriceChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = state.description,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = {
                Text("Descrição")
            },
            onValueChange = state.onDescriptionChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = state.onSaveClick,
        ) {
            Text("Salvar")
        }

        Spacer(modifier = Modifier)
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