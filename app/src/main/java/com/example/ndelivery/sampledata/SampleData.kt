package com.example.ndelivery.sampledata

import com.example.ndelivery.R
import com.example.ndelivery.model.Product
import java.math.BigDecimal

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = R.drawable.placeholder
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = R.drawable.placeholder
    ),
    Product(
        name = "Bolo",
        price = BigDecimal("11.99"),
        image = R.drawable.placeholder
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        image = R.drawable.placeholder
    ),
    Product(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        image = R.drawable.placeholder
    ),
    Product(
        name = "Suco",
        price = BigDecimal("7.99"),
        image = R.drawable.placeholder
    ),
    Product(
        name = "Água",
        price = BigDecimal("2.99"),
        image = R.drawable.placeholder
    )
)

val sampleProducts: List<Product> = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = R.drawable.burger

    ),
    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        image = R.drawable.fries
    )
)