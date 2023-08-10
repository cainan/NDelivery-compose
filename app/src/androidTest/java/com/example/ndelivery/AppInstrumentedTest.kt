package com.example.ndelivery

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ndelivery.database.AppDatabase
import com.example.ndelivery.model.Product
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@RunWith(AndroidJUnit4::class)
class AppInstrumentedTest {

    @Test
    fun testDatabase() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.ndelivery", appContext.packageName)

        val db = Room.databaseBuilder(appContext, AppDatabase::class.java, "app.db").build()
        val productDao = db.productDao()

        productDao.insertAll(
            Product(
                name = "Produto 01",
                price = BigDecimal("9.99"),
                description = "This is my product"
            )
        )

        val productList = productDao.getAll()
        productList.forEach {
            Log.d("Test", "The product is: $it")
        }
    }

}