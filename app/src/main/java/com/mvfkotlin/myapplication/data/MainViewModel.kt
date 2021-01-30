package com.mvfkotlin.myapplication.data

import android.widget.Toast
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.mvfkotlin.myapplication.database.DbDao
import com.mvfkotlin.myapplication.database.DbMapper
import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val mainRepository: MainRepository,
    private val dbDao: DbDao,
    private val dbMapper: DbMapper,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // I didn't make this one private because I have to observe it and change its value when the app
    // is running so I can
    // update the data of the recycler view that shows the favorite items
    val favoriteItemsList = MutableLiveData<List<Item>>()

    private val _similarItemsItemsList = MutableLiveData<List<Item>>()
    val similarItemsItemsList: LiveData<List<Item>>
        get() = _similarItemsItemsList

    private val _airingTodayItemsList = MutableLiveData<List<Item>>()
    val airingTodayItemsList: LiveData<List<Item>>
        get() = _airingTodayItemsList

    private val _trendingTvItemsList = MutableLiveData<List<Item>>()
    val trendingTvItemsList: LiveData<List<Item>>
        get() = _trendingTvItemsList

    private val _mostPopularTvItemsList = MutableLiveData<List<Item>>()
    val mostPopularTvItemsList: LiveData<List<Item>>
        get() = _mostPopularTvItemsList

    private val _topRatedTvItemsList = MutableLiveData<List<Item>>()
    val topRatedTvItemsList: LiveData<List<Item>>
        get() = _topRatedTvItemsList

    private val _nowPlayingItemsList = MutableLiveData<List<Item>>()
    val nowPlayingItemsList: LiveData<List<Item>>
        get() = _nowPlayingItemsList

    private val _mostPopularItemsList = MutableLiveData<List<Item>>()
    val mostPopularItemsList: LiveData<List<Item>>
        get() = _mostPopularItemsList

    private val _topRatedItemsList = MutableLiveData<List<Item>>()
    val topRatedItemsList: LiveData<List<Item>>
        get() = _topRatedItemsList

    private val _upcomingMoviesList = MutableLiveData<List<Item>>()
    val upcomingMoviesList: LiveData<List<Item>>
        get() = _upcomingMoviesList

    private val _trendingMoviesList = MutableLiveData<List<Item>>()
    val trendingMoviesList: LiveData<List<Item>>
        get() = _trendingMoviesList

    val toastStatus = MutableLiveData<Boolean?>()

    var movieId: Int? = savedStateHandle.get<Item>("item")?.id

    private fun fetchData(){
        viewModelScope.launch {
            _upcomingMoviesList.value = mainRepository.getUpcomingMovies()
            _trendingMoviesList.value = mainRepository.getTrendingMovies()
            favoriteItemsList.value = mainRepository.getFavoriteItems()
            _nowPlayingItemsList.value = mainRepository.getNowPlayingMovies()
            _mostPopularItemsList.value = mainRepository.getMostPopularMovies()
            _topRatedItemsList.value = mainRepository.getTopRatedMovies()
            _airingTodayItemsList.value = mainRepository.getTvAiringToday()
            _trendingTvItemsList.value = mainRepository.getTrendingTv()
            _mostPopularTvItemsList.value = mainRepository.getPopularTv()
            _topRatedTvItemsList.value = mainRepository.getTopRatedTv()
            _similarItemsItemsList.value = mainRepository.getSimilarMovies(movieId.toString())
        }
    }

    init{
        fetchData()
    }


    fun addItemToDb(item: Item){
        viewModelScope.launch {
            val a = dbDao.insertFavoriteItem(dbMapper.mapFromModelToFavoriteEntity(item))
            Timber.d("Index = $a")
            toastStatus.value = true
            favoriteItemsList.value = mainRepository.getFavoriteItems()
        }
    }

//    fun deleteItemFromDb(item: Item){
//        viewModelScope.launch {
//            dbDao.deleteItem(item.id)
//        }
//    }
}





