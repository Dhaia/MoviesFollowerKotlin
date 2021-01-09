package com.mvfkotlin.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.databinding.MoviesItemBinding
import com.mvfkotlin.myapplication.model.Item

class MoviesAdapter  internal constructor(
    private var mList: List<Item>,
    private val mListener: MoviesItemClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder = MoviesViewHolder.from(parent)

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(mList[position], mListener)

    override fun getItemCount(): Int = mList.size


    class MoviesViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentProduct: Item, listener : MoviesItemClickListener){
            binding.`object` = currentProduct
            binding.movieItemClickListener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MoviesAdapter.MoviesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: MoviesItemBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.movies_item,
                        parent, false)
                return MoviesViewHolder(binding)
            }
        }
    }
    
    fun setData(list: List<Item>){
        this.mList = list
        notifyDataSetChanged()
    }

    interface MoviesItemClickListener {
        fun movieItemClicked(item: Item)
    }
}