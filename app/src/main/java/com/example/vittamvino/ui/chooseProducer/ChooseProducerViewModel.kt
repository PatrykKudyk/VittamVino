package com.example.vittamvino.ui.chooseProducer

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vittamvino.adapters.ProducersListRecyclerViewAdapter
import com.example.vittamvino.databinding.FragmentChooseProducerBinding
import com.example.vittamvino.db.MyDatabase
import com.example.vittamvino.db.producer.Producer
import com.example.vittamvino.db.producer.ProducerDao
import com.example.vittamvino.models.ProducerRow

class ChooseProducerViewModel(application: Application) : AndroidViewModel(application) {

    private val producerDao: ProducerDao
    private lateinit var recyclerAdapter: ProducersListRecyclerViewAdapter
    val producers: LiveData<List<Producer?>>

    init {
        val db = MyDatabase.getDatabase(application)
        producerDao = db!!.producerDao()
        producers = producerDao.allProducers
    }

    fun initRecyclerView(binding: FragmentChooseProducerBinding, context: Context) {
        recyclerAdapter = ProducersListRecyclerViewAdapter(context)
        binding.producersRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.producersRecyclerView.adapter = recyclerAdapter
    }

    fun refreshProducersInRecyclerView(producers: ArrayList<ProducerRow>) {
        recyclerAdapter.setItems(producers)
    }
}