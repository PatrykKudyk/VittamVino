package com.example.vittamvino.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vittamvino.R
import com.example.vittamvino.controls.RatingControlView
import com.example.vittamvino.models.WineRow

class WinesRecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<WinesRecyclerViewAdapter.WinesViewHolder>() {

    private var wines = ArrayList<WineRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WinesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listitem_wine, parent, false)
        return WinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: WinesViewHolder, position: Int) {
        holder.initFields()
    }

    override fun getItemCount(): Int = wines.size

    inner class WinesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var groupTextView: TextView
        lateinit var wineNameTextView: TextView
        lateinit var imageView: ImageView
        lateinit var ratingView: RatingControlView
        lateinit var producerTextView: TextView
        lateinit var typeTextView: TextView
        lateinit var flavourTextView: TextView

        fun initFields() {
            groupTextView = itemView.findViewById(R.id.groupTextView)
            wineNameTextView = itemView.findViewById(R.id.wineNameTextView)
            imageView = itemView.findViewById(R.id.imageView)
            ratingView = itemView.findViewById(R.id.ratingView)
            producerTextView = itemView.findViewById(R.id.wineProducerTextView)
            typeTextView = itemView.findViewById(R.id.wineTypeTextView)
            flavourTextView = itemView.findViewById(R.id.wineFlavourTextView)
        }

        fun setValues(item: WineRow) {
            if (item.category != null){
                groupTextView.visibility = View.VISIBLE
                groupTextView.text = item.category
            } else {
                groupTextView.visibility = View.GONE
            }

            if (item.image != null){
                imageView.setImageDrawable(item.image)
            } else {
                imageView.setImageDrawable(context.getDrawable(R.drawable.ic_wine))
            }

            wineNameTextView.text = item.name
//            ratingView.setRating(item.rating)
            producerTextView.text = item.producer
            typeTextView.text = item.type
            flavourTextView.text = item.flavour.toString()
        }

    }
}