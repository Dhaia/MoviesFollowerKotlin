package com.mvfkotlin.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.TabsAdapter
import com.mvfkotlin.myapplication.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.VISIBLE
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View?
    {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val pager = binding.pager
        val adapter = TabsAdapter(this)
        pager.isUserInputEnabled = false
        pager.adapter = adapter

        val tablayout: TabLayout = binding.tabLayout
        val names:Array<String> = arrayOf("Movies","Tv Shows")
        TabLayoutMediator(tablayout,pager){tab, position ->
            tab.text = names[position]
        }.attach()

        return binding.root
    }
}
