package com.mvfkotlin.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.databinding.FavoriteItemBinding
import com.mvfkotlin.myapplication.databinding.MoviesItemBinding
import com.mvfkotlin.myapplication.model.Item


class FavoritesItemAdapter internal constructor(
    private var mList: List<Item>,
    private val mListener: FavoritesItemAdapter.FavoriteItemClickListener
) : RecyclerView.Adapter<FavoritesItemAdapter.FavoritesViewHolder>() {

    private var removedPosition: Int = 0
    private lateinit var removedItem: Item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder = FavoritesViewHolder.from(parent)

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) = holder.bind(mList[position], mListener)

    override fun getItemCount(): Int = mList.size

    class FavoritesViewHolder(val binding: FavoriteItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentItem: Item, listener : FavoriteItemClickListener){
            binding.item = currentItem
            binding.clickListener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FavoritesItemAdapter.FavoritesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: FavoriteItemBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.favorite_item,
                        parent, false)
                return FavoritesViewHolder(binding)
            }
        }
    }

    fun setData(list: List<Item>){
        mList.toMutableList().clear()
        notifyDataSetChanged()
        this.mList = list
        notifyDataSetChanged()
    }

    interface FavoriteItemClickListener {
        fun favoriteItemClicked(item: Item)
    }
}
