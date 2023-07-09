package com.example.ndelivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndelivery.App
import com.example.ndelivery.ui.components.ProductSection

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(vertical = 16.dp)
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductSection()
        ProductSection()
        ProductSection()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    App()
}