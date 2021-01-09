package com.mvfkotlin.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.databinding.MoviesItemBinding
import com.mvfkotlin.myapplication.databinding.UpcomingItemBinding
import com.mvfkotlin.myapplication.model.Item


class UpcomingAdapter  internal constructor(
    private var mList: List<Item>,
    private val mListener: UpcomingItemClickListener
) : RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder = UpcomingViewHolder.from(parent)

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) = holder.bind(mList[position], mListener)

    override fun getItemCount(): Int = mList.size


    class UpcomingViewHolder(val binding: UpcomingItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentProduct: Item, listener : UpcomingItemClickListener){
            binding.`object` = currentProduct
            binding.upcomingItemClickListener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): UpcomingViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: UpcomingItemBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.upcoming_item,
                        parent, false)
                return UpcomingViewHolder(binding)
            }
        }
    }

    fun setData(list: List<Item>){
        this.mList = list
        notifyDataSetChanged()
    }

    interface UpcomingItemClickListener {
        fun upcomingItemClicked(item: Item)
    }
}
