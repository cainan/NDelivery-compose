package com.example.ndelivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts
import com.example.ndelivery.sampledata.sampleSections
import com.example.ndelivery.ui.components.CardProductItem
import com.example.ndelivery.ui.components.ProductSection
import com.example.ndelivery.ui.components.SearchTextField
import com.example.ndelivery.ui.theme.NDeliveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column()
    {
        var text by remember { mutableStateOf(searchText) }
        SearchTextField(
            searchText = text, onSearchChange = {
                text = it
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(text, true) ||
                            product.description?.contains(text, true) ?: false

                }
            } else {
                emptyList()
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(
                        product = it,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    NDeliveryTheme() {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchPreview() {
    NDeliveryTheme() {
        Surface {
            HomeScreen(sampleSections, searchText = "Lorem")
        }
    }
}