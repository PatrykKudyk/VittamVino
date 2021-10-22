package com.example.vittamvino.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vittamvino.R
import com.example.vittamvino.models.ProducerRow

class ProducersListRecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<ProducersListRecyclerViewAdapter.ProducersListViewHolder>() {

    private var producers = ArrayList<ProducerRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProducersListViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.listitem_simple_item_with_name, parent, false)
        return ProducersListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProducersListViewHolder, position: Int) {
        holder.initFields()
        holder.setValues(producers[position])
    }

    override fun getItemCount(): Int = producers.size

    fun setItems(list: ArrayList<ProducerRow>) {
        producers = list
    }

    inner class ProducersListViewHolder(private val itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        lateinit var nameTextView: TextView

        fun initFields() {
            nameTextView = itemView.findViewById(R.id.nameTextView)
        }

        fun setValues(producerRow: ProducerRow) {
            nameTextView.text = producerRow.name
        }

    }
}