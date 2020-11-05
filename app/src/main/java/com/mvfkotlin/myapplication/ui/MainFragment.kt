package com.mvfkotlin.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.UpcomingAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.ActivityMainBinding
import com.mvfkotlin.myapplication.databinding.FragmentMainBinding
import timber.log.Timber

class MainFragment : Fragment() {

    /**
     * Lazily initialize [MainViewModel]
     */
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val upcomingAdapter = UpcomingAdapter()
        binding.adapter = upcomingAdapter

        viewModel.moviesList.observe(viewLifecycleOwner, {
            it.let ( upcomingAdapter::submitList)
            Timber.d("Data Observed = $it")
        })

        return binding.root
    }
}


//        binding.detailsFragmentButton.setOnClickListener(){view: View ->
//            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment) }
