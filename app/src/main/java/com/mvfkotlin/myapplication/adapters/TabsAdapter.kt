package com.mvfkotlin.myapplication.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mvfkotlin.myapplication.MyApplication_HiltComponents
import com.mvfkotlin.myapplication.ui.HomeMoviesFragment
import com.mvfkotlin.myapplication.ui.HomeTvFragment

class TabsAdapter(fragment: Fragment):
    FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    private val fragments : ArrayList<Fragment> = arrayListOf(
        HomeMoviesFragment(),
        HomeTvFragment()
    )
}