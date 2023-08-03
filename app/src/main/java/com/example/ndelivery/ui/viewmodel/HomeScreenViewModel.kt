package com.example.ndelivery.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ndelivery.dao.ProductDao
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleCandies
import com.example.ndelivery.sampledata.sampleDrinks
import com.example.ndelivery.ui.state.HomeScreenUiState
import kotlinx.coroutines.launch


class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            onSearchChange = {
                uiState = uiState.copy(searchText = it, searchedProducts = searchedProducts(it))
            },
        )
    )
        private set

    init {
        viewModelScope.launch {
            dao.products().collect {
                uiState = uiState.copy(
                    sections = mapOf(
                        "Todos os Produtos" to it,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    )
                )
            }
        }
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            dao.products().value.filter { product ->
                product.name.contains(text, true) ||
                        product.description?.contains(text, true) ?: false

            }
        } else {
            emptyList()
        }

}