package com.mvfkotlin.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvfkotlin.myapplication.network.RetrofitService
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    // The internal MutableLiveData that stores the upcoming movies
    private val _upcomingMovies = MutableLiveData<MoviesProperty>()
    // The external LiveData that stores the upcoming movies
    val upcomingMovies: LiveData<MoviesProperty>
        get() = _upcomingMovies

    private val _moviesList = MutableLiveData<List<MovieObject>>()
    val moviesList: LiveData<List<MovieObject>>
        get() = _moviesList

    private fun fetchData(){
        viewModelScope.launch {
            try {
                val response = RetrofitService.movies_api.getMovies("1")
                if(response.isSuccessful){
                    _upcomingMovies.value = response.body()
                    _moviesList.value = _upcomingMovies.value?.results
                    Timber.d("Retrofit call Success = %s", _moviesList)
                }else{
                    Timber.d("Retrofit call Failed = %s", response)
                }
            }catch (e: Exception){
                Timber.e("Exception error = %s", e.message)
            }
        }
    }

    init{
        fetchData()
    }
}





