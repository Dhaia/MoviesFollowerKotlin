package com.mvfkotlin.myapplication.repository

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
    suspend fun getSimilarMovies(movieId: String): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getSimilarMovies(movieId)
            if(response.isSuccessful) {
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }

        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getTrendingTv(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getTrendingTv()
            if(response.isSuccessful) {
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val tvEntityList = moviesBody?.results
                val items = tvEntityList?.let {
                    tvNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }

        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }
    suspend fun getPopularTv(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getPopularTv()
            if(response.isSuccessful) {
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val tvEntityList = moviesBody?.results
                val items = tvEntityList?.let {
                    tvNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }

        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }
    suspend fun getTopRatedTv(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getTopRatedTv()
            if(response.isSuccessful) {
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val tvEntityList = moviesBody?.results
                val items = tvEntityList?.let {
                    tvNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }

        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }
    suspend fun getTvAiringToday(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getTvAiringToday()
            if(response.isSuccessful) {
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val tvEntityList = moviesBody?.results
                val items = tvEntityList?.let {
                    tvNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }

        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getTopRatedMovies(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getTopRatedMovies()
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getNowPlayingMovies(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getNowPlayingMovies("1")
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getMostPopularMovies(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getMostPopularMovies()
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getUpcomingMovies(): List<Item> {
        var returnedList: List<Item> = emptyList()

        try{
            val response = moviesService.getUpcomingMovies("1")
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items
                }

//                if (items != null) {
//                    for(item in items){
//                        dbDao.insertCashingItem(dbMapper.mapFromModelToEntity(item))
//                    }
//                }
//                returnedList = dbMapper.mapFromEntityListToModelList(dbDao.getAll())
                return returnedList
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error U = ${e.message}")
        }

        return returnedList
    }

    suspend fun getTrendingMovies(): List<Item>{
        var returnedList: List<Item> = emptyList()

        try {
            val response = moviesService.getTrendingMovies()
            if(response.isSuccessful){
                Timber.d("Retrofit call Success")

                val moviesBody = response.body()
                val moviesEntityList = moviesBody?.results
                val items = moviesEntityList?.let {
                    movieNetworkMapper.mapFromEntityListToModelList(it) }

                if (items != null) {
                    returnedList = items }

                return returnedList
            }else{ Timber.d("Retrofit Response = %s", response) }
        }catch (e: Exception){
            Timber.e("Retrofit Call Error = ${e.message}")
        }
        return returnedList
    }

    suspend fun getFavoriteItems(): List<Item>{
        val list = dbDao.getAllFavoriteItems()
        return dbMapper.mapFromFavoriteListToModel(list)
    }
}