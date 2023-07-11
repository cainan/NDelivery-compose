package com.example.ndelivery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts

@Composable
fun ProductSection(title: String, products: List<Product>) {

    Column() {
        Text(
            text = title, Modifier.padding(
                start = 16.dp
            ), fontSize = 20.sp, fontWeight = FontWeight(400)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            for (p in products) {
                ProductItem(product = p)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Preview", sampleProducts)
}