package com.mvfkotlin.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.mvfkotlin.myapplication.database.DbDao
import com.mvfkotlin.myapplication.database.DbMapper
import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.network.*
import timber.log.Timber
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val movieNetworkMapper: MovieNetworkMapper,
    private val tvNetworkMapper: TvNetworkMapper,
    private val dbMapper: DbMapper,
    private val dbDao: DbDao,
    private val moviesService: MoviesService
){
    suspend fun getUpcomingMovies(): MutableLiveData<List<Item>> {
        val upcomingBody = MutableLiveData<MoviesNetworkEntity>()
        val upcomingItems = MutableLiveData<List<Item>>()

        try{
            val response = moviesService.getUpcomingMovies("1")
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                upcomingBody.value = response.body()
                val upcomingEntityList = upcomingBody.value?.results
                upcomingItems.value = upcomingEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it)
                }
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }

        return upcomingItems
    }
}