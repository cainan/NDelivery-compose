package com.example.ndelivery.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ndelivery.ui.theme.NDeliveryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = {
            onSearchChange(it)
        },
        modifier = modifier,
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        label = {
            Text("Produto")
        },
        placeholder = {
            Text("O que você procura?")
        }
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    NDeliveryTheme() {
        Surface {
            SearchTextField(searchText = "Lorem", onSearchChange = {

            })
        }
    }
}