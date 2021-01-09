package com.mvfkotlin.myapplication.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.FavoritesItemAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.FragmentFavoritesBinding
import com.mvfkotlin.myapplication.model.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import java.util.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class FavoritesFragment : BaseFragment(), FavoritesItemAdapter.FavoriteItemClickListener {

    override var bottomNavigationViewVisibility: Int = View.VISIBLE
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentFavoritesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorites, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        var list: List<Item> = emptyList()
        val favoritesItemAdapter = FavoritesItemAdapter(list, this)
        binding.adapter = favoritesItemAdapter

        // If you add an item to the DB, you can't see it in the recycler view instantly, you must
        // close the app and open it again !
        viewModel.favoriteItemsList.observe(viewLifecycleOwner, {
            favoritesItemAdapter.setData(it)
            Timber.d("lol")
        })

        return binding.root
    }

    override fun favoriteItemClicked(item: Item) {
        val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailsFragment(item)
        view?.findNavController()?.navigate(action)
    }
}
