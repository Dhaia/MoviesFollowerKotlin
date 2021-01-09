package com.mvfkotlin.myapplication.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mvfkotlin.myapplication.MainActivity
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.adapters.MoviesAdapter
import com.mvfkotlin.myapplication.data.MainViewModel
import com.mvfkotlin.myapplication.databinding.FragmentDetailsBinding
import com.mvfkotlin.myapplication.model.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailsFragment : BaseFragment(), MoviesAdapter.MoviesItemClickListener {

    override var bottomNavigationViewVisibility = View.GONE

    private val viewModel: MainViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false)

        binding.item = args.item
        binding.viewModel = viewModel

        viewModel.toastStatus.observe(viewLifecycleOwner, {
            Toast.makeText(context, "Item was successfully added", Toast.LENGTH_SHORT).show()
        })

        val list: List<Item> = emptyList()
        val similarAdapter = MoviesAdapter(list, this)
        binding.similarAdapter = similarAdapter
        viewModel.similarItemsItemsList.observe(viewLifecycleOwner, {
            similarAdapter.setData(it)
        })

        return binding.root
    }

    override fun movieItemClicked(item: Item) {
        val action = DetailsFragmentDirections.actionDetailsFragmentSelf(item)
        view?.findNavController()?.navigate(action)
    }
}