package com.example.ndelivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleSections
import com.example.ndelivery.ui.components.ProductSection
import com.example.ndelivery.ui.theme.NDeliveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(vertical = 16.dp)
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for (section in sections) {
            val title = section.key
            val products = section.value
            ProductSection(
                title = title,
                products = products
            )
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