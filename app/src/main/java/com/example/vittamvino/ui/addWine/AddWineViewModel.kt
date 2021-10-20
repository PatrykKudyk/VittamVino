package com.example.vittamvino.ui.addWine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.vittamvino.databinding.FragmentAddWineBinding
import com.example.vittamvino.db.MyDatabase
import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.db.wine.WineDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class AddWineViewModel(application: Application): AndroidViewModel(application) {
    private val wineDao: WineDao

    init {
        val db = MyDatabase.getDatabase(application)
        wineDao = db!!.wineDao()
    }


    fun addWine(binding: FragmentAddWineBinding) = runBlocking {
        async(Dispatchers.Default) {
            wineDao.insert(
                Wine(
                    Random.nextInt(),
                    binding.nameEditText.text.toString(),
                    binding.ratingEditText.text.toString().toDouble(),
                    1,
                    1,
                    1
                )
            )
        }
    }

}