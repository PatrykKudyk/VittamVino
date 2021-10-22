package com.example.vittamvino.ui.chooseProducer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.vittamvino.databinding.FragmentChooseProducerBinding
import com.example.vittamvino.db.MyDatabase
import com.example.vittamvino.db.producer.Producer
import com.example.vittamvino.db.producer.ProducerDao

class ChooseProducerViewModel(application: Application) : AndroidViewModel(application) {

    private val producerDao: ProducerDao
//    private val
    val producers: LiveData<List<Producer?>>

    init {
        val db = MyDatabase.getDatabase(application)
        producerDao = db!!.producerDao()
        producers = producerDao.allProducers
    }

    fun initRecyclerView(binding: FragmentChooseProducerBinding) {

    }

    fun refreshProducersInRecyclerView() {

    }
}