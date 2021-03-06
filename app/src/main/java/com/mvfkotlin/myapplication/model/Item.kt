package com.mvfkotlin.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// The model that is used by the app
@Parcelize
data class Item (
    val popularity: Double?,
    val voteCount: Int?,
    val posterPath: String?,
    val id: Int?,
    val backdropPath: String?,
    val originalTitle: String?,
    val genreIds: List<Int>?,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val voteAverage: Double?
): Parcelable