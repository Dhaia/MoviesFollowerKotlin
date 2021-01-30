package com.mvfkotlin.myapplication.di

import com.mvfkotlin.myapplication.network.MoviesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDbService(retrofit: Retrofit): MoviesService{
        return retrofit.create(MoviesService::class.java)
    }
}