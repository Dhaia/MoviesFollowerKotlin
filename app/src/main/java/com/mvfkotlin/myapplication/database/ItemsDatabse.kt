package com.mvfkotlin.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@TypeConverters(DbConverters::class)
@Database(entities = [CashingDatabaseEntity::class, FavoriteDatabaseEntity::class], version = 5)
abstract class ItemsDatabase: RoomDatabase(){

    abstract fun databaseDao(): DbDao

    companion object{
        val DATABASE_NAME: String = "items_db"
    }
}