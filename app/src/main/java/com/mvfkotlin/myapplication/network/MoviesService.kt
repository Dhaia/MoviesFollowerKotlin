package com.mvfkotlin.myapplication.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/upcoming?api_key=&=en-US")
    suspend fun getUpcomingMovies(@Query("page") query: String): Response<MoviesNetworkEntity>

    @GET("trending/movie/week?api_key=")
    suspend fun getTrendingMovies(): Response<MoviesNetworkEntity>

    @GET("movie/now_playing?api_key=&language=en-US")
    suspend fun getNowPlayingMovies(@Query("page") pageNumber: String?): Response<MoviesNetworkEntity>

    @GET("movie/popular?api_key=&language=en-US")
    suspend fun getMostPopularMovies(): Response<MoviesNetworkEntity>

    @GET("movie/top_rated?api_key=&language=en-US")
    suspend fun getTopRatedMovies(): Response<MoviesNetworkEntity>

    @GET("tv/airing_today?api_key=")
    suspend fun getTvAiringToday(): Response<TvsNetworkEntity>

    @GET("trending/tv/week?api_key=")
    suspend fun getTrendingTv(): Response<TvsNetworkEntity>

    @GET("tv/popular?api_key=")
    suspend fun getPopularTv(): Response<TvsNetworkEntity>

    @GET("tv/top_rated?api_key=")
    suspend fun getTopRatedTv(): Response<TvsNetworkEntity>

    @GET("movie/{movie_id}/similar?api_key=&language=en-US&page=1")
    suspend fun getSimilarMovies(@Path("movie_id") id: String?): Response<MoviesNetworkEntity>
}