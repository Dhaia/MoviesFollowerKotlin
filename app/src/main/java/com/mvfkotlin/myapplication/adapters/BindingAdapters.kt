package com.mvfkotlin.myapplication.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.util.setGenres
import com.mvfkotlin.myapplication.util.setRatingImageUtils
import timber.log.Timber


@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {
    if (url != null && url.isNotBlank()) {
        val finalUrl = "https://image.tmdb.org/t/p/w780$url"

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(25))
            .placeholder(R.drawable.ic_baseline_image_not_supported_24)
        Glide.with(this.context)
            .load(finalUrl)
            .apply(requestOptions)
            .into(this)
        Timber.d("Set the Image")
    }
}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        Timber.d("Setting the Adapter")
        this.adapter = adapter
    }
}

@BindingAdapter(value = ["setRating"])
fun TextView.bindText(rating: Double?){
    val text: TextView = this
    text.text = rating.toString()
}

@BindingAdapter(value = ["setRatingImage"])
fun ImageView.bindImage(rating: Double?){
    setRatingImageUtils(rating, this)
}

@BindingAdapter(value = ["setGenresTextView"])
fun TextView.bindGenresText(list: List<Int>){
    val text = this
    text.text = setGenres(list)
}

@BindingAdapter(value = ["setVoteCount"])
fun TextView.bindTextVoteCount(voteCount: Int?){
    val text: TextView = this
    text.text = voteCount.toString()
}