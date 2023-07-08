package com.example.ndelivery.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class BigDecimalExtension {

    fun BigDecimal.toBrazilianCurrency(): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)
    }

}