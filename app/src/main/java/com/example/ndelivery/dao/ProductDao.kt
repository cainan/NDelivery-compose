package com.example.ndelivery.dao

import android.util.Log
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {

    private val TAG = "ProductDao"

    companion object {
        private val products = MutableStateFlow<List<Product>>(sampleProducts)
    }

    fun products() = products.asStateFlow()

    fun save(product: Product) {
        Log.i(TAG, "save: $product")
        products.value += product
    }
}