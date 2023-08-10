package com.example.ndelivery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ndelivery.database.converter.Converter
import com.example.ndelivery.database.dao.iProductDao
import com.example.ndelivery.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): iProductDao
}