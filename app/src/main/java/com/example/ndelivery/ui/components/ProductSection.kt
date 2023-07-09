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
import com.example.ndelivery.R
import com.example.ndelivery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection() {

    Column() {
        Text(
            text = "Promoções", Modifier.padding(
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
            ProductItem(
                Product(
                    name = "Burger",
                    price = BigDecimal("14.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    name = "Pizza",
                    price = BigDecimal("34.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    name = "Batata Frita",
                    price = BigDecimal("10.99"),
                    image = R.drawable.fries
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ProductSection()
}