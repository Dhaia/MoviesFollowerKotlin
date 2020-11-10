package com.mvfkotlin.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mvfkotlin.myapplication.databinding.ListItemBinding
import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.network.MovieNetworkObject


class UpcomingAdapter : ListAdapter<Item, UpcomingAdapter.UpcomingViewHolder> (Companion) {

    class UpcomingViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater)

        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.`object` = currentItem
        holder.binding.executePendingBindings()
    }
}