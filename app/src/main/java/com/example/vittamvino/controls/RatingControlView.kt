package com.example.vittamvino.controls

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.vittamvino.R

class RatingControlView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val star1: ImageView
    private val star2: ImageView
    private val star3: ImageView
    private val star4: ImageView
    private val star5: ImageView
    private val ratingTextView: TextView
    var wineRating = 0.0

    init {
        orientation = HORIZONTAL
        weightSum = 10f
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.control_rating, this)

        star1 = view.findViewById(R.id.star1)
        star2 = view.findViewById(R.id.star2)
        star3 = view.findViewById(R.id.star3)
        star4 = view.findViewById(R.id.star4)
        star5 = view.findViewById(R.id.star5)
        ratingTextView = view.findViewById(R.id.ratingTextView)
    }

    fun setRating(givenRating: Double) {
        wineRating = givenRating
        val ratingInt = givenRating.toInt()
        val ratingDecimal = givenRating - ratingInt
        makeAllStarsEmpty()
        handleIntRating(ratingInt)
        handleDecimalRating(ratingInt, ratingDecimal)
        ratingTextView.text = calculateRating(ratingInt, ratingDecimal) + " / 5.0"
    }

    private fun calculateRating(ratingInt: Int, ratingDecimal: Double): String {
        return ratingInt.toString() + "." + (ratingDecimal * 10.0).toInt().toString()
    }

    private fun handleDecimalRating(ratingInt: Int, ratingDecimal: Double) {
        val correctStar = when (ratingInt) {
            0 -> star1
            1 -> star2
            2 -> star3
            3 -> star4
            4 -> star5
            else -> return
        }
        when (ratingDecimal){
            in 0.0..0.25 -> correctStar.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
            in 0.25..0.75 -> correctStar.setImageDrawable(context.getDrawable(R.drawable.ic_star_half))
            else -> correctStar.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
        }
    }

    private fun handleIntRating(ratingInt: Int) {
        when (ratingInt) {
            0 -> return
            1 -> {
                star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
            }
            2 -> {
                star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star2.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
            }
            3 -> {
                star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star2.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star3.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
            }
            4 -> {
                star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star2.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star3.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star4.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
            }
            5 -> {
                star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star2.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star3.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star4.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
                star5.setImageDrawable(context.getDrawable(R.drawable.ic_star_full))
            }
        }
    }

    private fun makeAllStarsEmpty() {
        star1.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
        star2.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
        star3.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
        star4.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
        star5.setImageDrawable(context.getDrawable(R.drawable.ic_star_empty))
    }

}