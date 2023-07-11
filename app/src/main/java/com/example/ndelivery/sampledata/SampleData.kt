package com.example.ndelivery.sampledata

import com.example.ndelivery.R
import com.example.ndelivery.model.Product
import java.math.BigDecimal

val sampleProduct = listOf(
    Product(
        name = "Burger",
        price = BigDecimal("14.99"),
        image = R.drawable.burger
    ),

    Product(
        name = "Pizza",
        price = BigDecimal("34.99"),
        image = R.drawable.pizza
    ),

    Product(
        name = "Batata Frita",
        price = BigDecimal("10.99"),
        image = R.drawable.fries
    ),
)