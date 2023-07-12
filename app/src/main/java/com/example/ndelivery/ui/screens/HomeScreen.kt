@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ndelivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import com.example.ndelivery.sampledata.sampleSections
import com.example.ndelivery.ui.components.ProductSection
import com.example.ndelivery.ui.theme.NDeliveryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column()
    {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(value = text, onValueChange = {
            text = it
        })

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

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