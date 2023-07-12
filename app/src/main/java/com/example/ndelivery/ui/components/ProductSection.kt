package com.example.ndelivery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts
import com.example.ndelivery.ui.theme.NDeliveryTheme

@Composable
fun ProductSection(title: String, products: List<Product>) {

    Column() {
        Text(
            text = title, Modifier.padding(
                start = 16.dp
            ), fontSize = 20.sp, fontWeight = FontWeight(400)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(products) {
                ProductItem(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    NDeliveryTheme() {
        Surface {
            ProductSection("Promoções", products = sampleProducts)
        }
    }
}