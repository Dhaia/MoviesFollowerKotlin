package com.mvfkotlin.myapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCashingItem(dbEntityCashing: CashingDatabaseEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteItem(dbEntityCashing: FavoriteDatabaseEntity): Long

    @Query("SELECT * FROM cashing_items")
    suspend fun getAll(): List<CashingDatabaseEntity>

    @Query("SELECT * FROM favorite_items")
    suspend fun getAllFavoriteItems(): List<FavoriteDatabaseEntity>

    @Query("DELETE FROM favorite_items WHERE id = :deletedId")
    suspend fun deleteItem(deletedId: Int)

    @Query("DELETE FROM cashing_items")
    suspend fun clearCashedItems()

//    @Query("DELETE FROM daily_sleep_quality_table")
//    suspend fun clearFavoriteItems()
}