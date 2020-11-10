package com.mvfkotlin.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.UpcomingAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View?
    {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val upcomingAdapter = UpcomingAdapter()
        binding.adapter = upcomingAdapter

        viewModel.upcomingMoviesList.observe(viewLifecycleOwner, {
            it.let ( upcomingAdapter::submitList)
            Timber.d("Data Observed = $it")
        })

        return binding.root
    }
}


//        binding.detailsFragmentButton.setOnClickListener(){view: View ->
//            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment) }
