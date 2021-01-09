package com.mvfkotlin.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.MoviesAdapter
import com.mvfkotlin.myapplication.adapters.UpcomingAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.FragmentHomeTvBinding
import com.mvfkotlin.myapplication.databinding.FragmentMainBinding
import com.mvfkotlin.myapplication.model.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeTvFragment : BaseFragment(), UpcomingAdapter.UpcomingItemClickListener, MoviesAdapter.MoviesItemClickListener  {

    private lateinit var binding: FragmentHomeTvBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_tv, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val list: List<Item> = emptyList()
        val airingToday = UpcomingAdapter(list, this)
        val trendingTvAdapter = MoviesAdapter(list, this)
        val mostPopularTvAdapter = MoviesAdapter(list, this)
        val topRatedTvAdapter = MoviesAdapter(list, this)
        binding.airingTodayAdapter = airingToday
        binding.trendingTvAdapter = trendingTvAdapter
        binding.mostPopularTvAdapter = mostPopularTvAdapter
        binding.topRatedTvAdapter = topRatedTvAdapter

        viewModel.airingTodayItemsList.observe(viewLifecycleOwner, {
            airingToday.setData(it)
        })
        viewModel.trendingTvItemsList.observe(viewLifecycleOwner, {
            trendingTvAdapter.setData(it)
        })
        viewModel.mostPopularTvItemsList.observe(viewLifecycleOwner, {
            mostPopularTvAdapter.setData(it)
        })
        viewModel.topRatedTvItemsList.observe(viewLifecycleOwner, {
            topRatedTvAdapter.setData(it)
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