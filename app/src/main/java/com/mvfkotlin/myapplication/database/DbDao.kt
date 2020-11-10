package com.mvfkotlin.myapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbEntity: DatabaseEntity): Long

    @Query("SELECT * FROM items")
    suspend fun getAll(): List<DatabaseEntity>
}