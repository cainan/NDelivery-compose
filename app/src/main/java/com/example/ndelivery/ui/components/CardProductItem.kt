package com.example.ndelivery.ui.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ndelivery.R
import com.example.ndelivery.extensions.toBrazilianCurrency
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts
import com.example.ndelivery.ui.theme.NDeliveryTheme
import java.math.BigDecimal

val TAG = "CardProductItem"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded: Boolean = false
) {
    var expanded by rememberSaveable { mutableStateOf(expanded) }
    Card(
        onClick = {
            expanded = !expanded
            Log.i(TAG, "clicked: $expanded")
        },
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = cardElevation(elevation),
    ) {
        Column() {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }


            product.description?.let {
                if (expanded) {
                    Text(
                        text = product.description,
                        Modifier
                            .padding(16.dp),
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CardProductItemPreview() {
    NDeliveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    NDeliveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Hamburger",
                    price = BigDecimal("25.00"),
                    description = LoremIpsum(20).values.first()
                ),
                expanded = true,
            )
        }
    }
}