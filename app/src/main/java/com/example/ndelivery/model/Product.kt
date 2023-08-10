package com.example.ndelivery.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0L,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo val price: BigDecimal,
    @ColumnInfo val image: String? = null,
    @ColumnInfo val description: String? = null
)
