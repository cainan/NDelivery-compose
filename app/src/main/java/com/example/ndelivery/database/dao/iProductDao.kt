package com.example.ndelivery.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ndelivery.model.Product

@Dao
interface iProductDao {
    @Query("SELECT * FROM Product")
    fun getAll(): List<Product>

    @Insert
    fun insertAll(vararg product: Product)

    @Delete
    fun delete(vararg product: Product)

    @Update
    fun update(product: Product)

}