package com.example.ndelivery.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ndelivery.dao.ProductDao
import com.example.ndelivery.model.Product
import com.example.ndelivery.ui.state.ProductFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<ProductFormScreenUiState> = MutableStateFlow(
        ProductFormScreenUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val formatter = DecimalFormat("#.##")

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = uiState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uiState.value = uiState.value.copy(
                        name = it
                    )
                },
                onPriceChange = {
                    val formattedPrice = try {
                        formatter.format(BigDecimal(it))
                    } catch (e: IllegalArgumentException) {
                        if (it.isBlank()) {
                            it
                        } else {
                            null
                        }
                    }

                    formattedPrice?.let {
                        _uiState.value = uiState.value.copy(
                            price = formattedPrice
                        )
                    }
                },
                onDescriptionChange = {
                    _uiState.value = uiState.value.copy(
                        description = it
                    )
                },
            )
        }
    }

    fun save() {
        val price = try {
            BigDecimal(_uiState.value.price)
        } catch (e: NumberFormatException) {
            BigDecimal.ZERO
        }

        val product = Product(
            name = _uiState.value.name,
            image = _uiState.value.url,
            price = price,
            description = _uiState.value.description
        )
        Log.i(
            "ProductScreenViewModel",
            "ProductScreenViewModel: Product -> $product"
        )

        dao.save(product)
    }
}