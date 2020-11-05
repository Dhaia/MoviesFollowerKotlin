package com.mvfkotlin.myapplication.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MoviesProperty (
    var results: List<MovieObject>
): Parcelable

@Parcelize
data class MovieObject (
    var popularity: Double? = null,
    @Json(name = "vote_count") var voteCount: Int? = null,
    var video: Boolean? = null,
    @Json(name = "poster_path") var posterPath: String? = null,
    var id: Int? = null,
    var adult: Boolean? = null,
    @Json(name = "backdrop_path") var backdropPath: String? = null,
    @Json(name = "original_title") var originalTitle: String? = null,
    @Json(name = "genre_ids") var genreIds: List<Int>? = null,
    var title: String? = null,
    @Json(name = "vote_average") var voteAverage: Double? = null,
    var overview: String? = null,
    @Json(name = "release_date") var releaseDate: String? = null
) : Parcelable