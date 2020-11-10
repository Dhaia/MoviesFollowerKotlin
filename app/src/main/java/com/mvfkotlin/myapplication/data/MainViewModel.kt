package com.mvfkotlin.myapplication.data

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _upcomingMoviesList = MutableLiveData<List<Item>>()
    val upcomingMoviesList: LiveData<List<Item>>
        get() = _upcomingMoviesList

    private fun fetchData(){
        viewModelScope.launch {
            try {
                _upcomingMoviesList.value = mainRepository.getUpcomingMovies().value
            }catch (e: Exception){
                Timber.e("Exception error = %s", e.message)
            }
        }
    }

    init{
        fetchData()
    }
}





