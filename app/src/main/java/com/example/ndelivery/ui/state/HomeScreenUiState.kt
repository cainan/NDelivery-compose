package com.example.ndelivery.ui.state

import com.example.ndelivery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val searchedProducts: List<Product> = emptyList()
) {

    fun isShowSection(): Boolean {
        return searchText.isBlank()
    }
}
