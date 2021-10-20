package com.example.vittamvino.controls

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.vittamvino.R

class ClickableRatingControlView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val star1: ImageView
    private val star2: ImageView
    private val star3: ImageView
    private val star4: ImageView
    private val star5: ImageView
    private val ratingTextView: TextView

    var rating: Int

    init{
        orientation = HORIZONTAL
        rating = 0
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.control_clickable_rating, this)

        star1 = view.findViewById(R.id.star1)
        star2 = view.findViewById(R.id.star2)
        star3 = view.findViewById(R.id.star3)
        star4 = view.findViewById(R.id.star4)
        star5 = view.findViewById(R.id.star5)
        ratingTextView = view.findViewById(R.id.ratingTextView)

        setListeners()
        setRatingTextView()
    }

    private fun setListeners() {
        star1.setOnClickListener{
            star1.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star2.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star3.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star4.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star5.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))

            rating = 1
            setRatingTextView()
        }

        star2.setOnClickListener{
            star1.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star2.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star3.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star4.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star5.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))

            rating = 2
            setRatingTextView()
        }

        star3.setOnClickListener{
            star1.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star2.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star3.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star4.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))
            star5.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))

            rating = 3
            setRatingTextView()
        }

        star4.setOnClickListener{
            star1.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star2.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star3.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star4.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star5.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_empty))

            rating = 4
            setRatingTextView()
        }

        star5.setOnClickListener{
            star1.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star2.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star3.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star4.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))
            star5.setImageDrawable(this.context.getDrawable(R.drawable.ic_star_full))

            rating = 5
            setRatingTextView()
        }
    }

    private fun setRatingTextView() {
        when (rating){
            0 -> ratingTextView.text = "0/5"
            1 -> ratingTextView.text = "1/5"
            2 -> ratingTextView.text = "2/5"
            3 -> ratingTextView.text = "3/5"
            4 -> ratingTextView.text = "4/5"
            5 -> ratingTextView.text = "5/5"
        }
    }
}