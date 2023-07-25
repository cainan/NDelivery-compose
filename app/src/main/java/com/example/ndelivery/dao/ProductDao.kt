package com.example.ndelivery.dao

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.ndelivery.model.Product
import com.example.ndelivery.sampledata.sampleProducts

class ProductDao {

    private val TAG = "ProductDao"

    companion object {
        private val products = mutableStateListOf<Product>(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()

    fun save(product: Product) {
        Log.i(TAG, "save: $product")
        products.add(product)
    }
}