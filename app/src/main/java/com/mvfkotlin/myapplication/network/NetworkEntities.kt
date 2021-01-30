package com.mvfkotlin.myapplication.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesNetworkEntity (
    val results: List<MovieNetworkObject>
): Parcelable
@Parcelize
data class MovieNetworkObject (
    val popularity: Double?,
    @Json(name = "vote_count") val voteCount: Int?,
    @Json(name = "poster_path") val posterPath: String?,
    val id: Int?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "original_title") val originalTitle: String?,
    @Json(name = "genre_ids") val genreIds: List<Int>?,
    val title: String?,
    @Json(name = "vote_average") val voteAverage: Double?,
    val overview: String?,
    @Json(name = "release_date") val releaseDate: String?
) : Parcelable

@Parcelize
data class TvsNetworkEntity (
    var results: List<TvNetworkObject>
): Parcelable
@Parcelize
data class TvNetworkObject(
    @Json(name = "original_name") val originalTitle: String?,
    @Json(name = "genre_ids") val genreIds: List<Int>?,
    @Json(name = "name") val title: String?,
    val popularity: Double?,
    @Json(name = "vote_count") val voteCount: Int?,
    @Json(name = "first_air_date") val releaseDate: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    val id: Int?,
    @Json(name = "vote_average") val voteAverage: Double?,
    val overview: String?,
    @Json(name = "poster_path") val posterPath: String?
): Parcelable