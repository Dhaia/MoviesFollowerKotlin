package com.mvfkotlin.myapplication.util

import android.widget.ImageView
import com.mvfkotlin.myapplication.R
import com.mvfkotlin.myapplication.R.drawable


fun setRatingImageUtils(rating: Double?, imageView: ImageView){
    if (rating != null) {
        if (rating >= 9) {
            imageView.setImageResource(drawable.five_star)
        } else if (rating >= 8 && rating < 9) {
            imageView.setImageResource(drawable.four_and_half_star)
        } else if (rating >= 7 && rating < 8) {
            imageView.setImageResource(R.drawable.four_star)
        } else if (rating >= 6 && rating < 7) {
            imageView.setImageResource(R.drawable.three_and_half_star)
        } else if (rating >= 5 && rating < 6) {
            imageView.setImageResource(R.drawable.three_star)
        } else if (rating >= 4 && rating < 5) {
            imageView.setImageResource(R.drawable.two_and_half_star)
        } else if (rating >= 3 && rating < 4) {
            imageView.setImageResource(R.drawable.two_stars)
        } else if (rating >= 2 && rating < 3) {
            imageView.setImageResource(R.drawable.one_and_half_star)
        } else if (rating >= 1 && rating < 2) {
            imageView.setImageResource(R.drawable.one_star)
        } else if (rating > 0 && rating < 1) {
            imageView.setImageResource(R.drawable.half_star)
        } else {
            imageView.setImageResource(R.drawable.zero_stars)
        }
    }
}