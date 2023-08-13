package com.example.ndelivery.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ndelivery.database.converter.Converter
import com.example.ndelivery.database.dao.iProductDao
import com.example.ndelivery.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): iProductDao

    companion object {
        fun instance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()
        }
    }

}