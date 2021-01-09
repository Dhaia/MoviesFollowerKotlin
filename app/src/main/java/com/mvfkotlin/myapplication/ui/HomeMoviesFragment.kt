package com.mvfkotlin.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.MoviesAdapter
import com.mvfkotlin.myapplication.adapters.UpcomingAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.FragmentHomeMoviesBinding
import com.mvfkotlin.myapplication.databinding.FragmentMainBinding
import com.mvfkotlin.myapplication.model.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeMoviesFragment : BaseFragment(), UpcomingAdapter.UpcomingItemClickListener, MoviesAdapter.MoviesItemClickListener {

    private lateinit var binding: FragmentHomeMoviesBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home_movies, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val list: List<Item> = emptyList()
        val upcomingAdapter = UpcomingAdapter(list, this)
        val moviesAdapterAdapter = MoviesAdapter(list, this)
        val nowPlayingAdapterAdapter = MoviesAdapter(list, this)
        val mostPopularAdapterAdapter = MoviesAdapter(list, this)
        val topRatedAdapterAdapter = MoviesAdapter(list, this)
        binding.upcomingAdapter = upcomingAdapter
        binding.trendingMoviesAdapter = moviesAdapterAdapter
        binding.nowPlayingMoviesAdapter = nowPlayingAdapterAdapter
        binding.mostPopularMoviesAdapter = mostPopularAdapterAdapter
        binding.topRatedMoviesAdapter = topRatedAdapterAdapter

        viewModel.upcomingMoviesList.observe(viewLifecycleOwner, {
            upcomingAdapter.setData(it)
        })
        viewModel.trendingMoviesList.observe(viewLifecycleOwner, {
            moviesAdapterAdapter.setData(it)
        })
        viewModel.nowPlayingItemsList.observe(viewLifecycleOwner, {
            nowPlayingAdapterAdapter.setData(it)
        })
        viewModel.mostPopularItemsList.observe(viewLifecycleOwner, {
            mostPopularAdapterAdapter.setData(it)
        })
        viewModel.topRatedItemsList.observe(viewLifecycleOwner, {
            topRatedAdapterAdapter.setData(it)
        })

        return binding.root
    }

    override fun movieItemClicked(item: Item) {
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(item)
        view?.findNavController()?.navigate(action)
    }

    override fun upcomingItemClicked(item: Item) {
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(item)
        view?.findNavController()?.navigate(action)
    }
}