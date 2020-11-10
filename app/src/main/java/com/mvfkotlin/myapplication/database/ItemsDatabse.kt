package com.mvfkotlin.myapplication.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(DbConverters::class)
@Database(entities = [DatabaseEntity::class], version = 1)
abstract class ItemsDatabase: RoomDatabase(){

    abstract fun databaseDao(): DbDao

    companion object{
        val DATABASE_NAME: String = "items_db"
    }
}