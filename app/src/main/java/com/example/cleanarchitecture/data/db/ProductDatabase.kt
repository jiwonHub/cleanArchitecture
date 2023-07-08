package com.example.cleanarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cleanarchitecture.data.db.dao.ProductDao
import com.example.cleanarchitecture.data.entity.product.ProductEntity
import com.example.cleanarchitecture.utillity.DataConverter


@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverter::class)
abstract class ProductDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ProductDataBase.db"
    }

    abstract fun productDao(): ProductDao
}