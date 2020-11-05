package com.mvfkotlin.myapplication.network

import com.mvfkotlin.myapplication.data.MovieObject
import com.mvfkotlin.myapplication.data.MoviesProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Service {
    @GET("movie/upcoming?api_key=&=en-US")
    suspend fun getMovies(@Query("page") query: String): Response<MoviesProperty>
}

object RetrofitService {
    val movies_api = retrofit.create(Service::class.java)
}

