package com.example.ndelivery.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ndelivery.dao.ProductDao
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleCandies
import com.example.ndelivery.sampledata.sampleDrinks
import com.example.ndelivery.ui.state.HomeScreenUiState


class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val sections = mapOf(
        "Todos os Produtos" to dao.products(),
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = sections,
            onSearchChange = {
                uiState = uiState.copy(searchText = it, searchedProducts = searchedProducts(it))
            },
        )
    )
        private set


    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            dao.products().filter { product ->
                product.name.contains(text, true) ||
                        product.description?.contains(text, true) ?: false

            }
        } else {
            emptyList()
        }

}