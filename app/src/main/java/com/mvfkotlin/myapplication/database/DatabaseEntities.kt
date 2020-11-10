package com.mvfkotlin.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class DatabaseEntity(
    val popularity: Double,
    val voteCount: Int,
    val posterPath: String,

    @PrimaryKey
    val id: Int,

    val backdropPath: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Double
)