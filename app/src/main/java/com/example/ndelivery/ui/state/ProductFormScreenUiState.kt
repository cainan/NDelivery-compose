package com.example.ndelivery.ui.state

data class ProductFormScreenUiState(
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val price: String = "",
    val onPriceChange: (String) -> Unit = {},
    val description: String = "",
    val onDescriptionChange: (String) -> Unit = {},
    val url: String = "",
    val onUrlChange: (String) -> Unit = {},

    ) {
    fun isShowPreview(): Boolean {
        return url.isNotBlank()
    }
}
