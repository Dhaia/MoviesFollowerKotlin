package com.mvfkotlin.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// An entity for cashing
@Entity(tableName = "cashing_items")
data class CashingDatabaseEntity(
    val popularity: Double?,
    val voteCount: Int?,
    val posterPath: String?,

    @PrimaryKey
    val id: Int?,

    val backdropPath: String?,
    val originalTitle: String?,
    val genreIds: List<Int>?,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val voteAverage: Double?
)

@Entity(tableName = "favorite_items")
data class FavoriteDatabaseEntity(
    val popularity: Double?,
    val voteCount: Int?,
    val posterPath: String?,

    @PrimaryKey
    val id: Int?,

    val backdropPath: String?,
    val originalTitle: String?,
    val genreIds: List<Int>?,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val voteAverage: Double?
)