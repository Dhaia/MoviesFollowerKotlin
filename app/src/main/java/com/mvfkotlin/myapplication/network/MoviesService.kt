package com.mvfkotlin.myapplication.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/upcoming?api_key=&=en-US")
    suspend fun getUpcomingMovies(@Query("page") query: String): Response<MoviesNetworkEntity>
}