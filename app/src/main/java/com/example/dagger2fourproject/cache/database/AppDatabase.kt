package com.example.dagger2fourproject.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger2fourproject.cache.RoomServiceDao
import com.example.dagger2fourproject.cache.model.RoomModel

@Database(entities = [RoomModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun roomServiceDao(): RoomServiceDao

    companion object {
        val DATABASE_NAME: String = "jalgas_database"
    }

}