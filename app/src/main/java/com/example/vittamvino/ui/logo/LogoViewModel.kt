package com.example.vittamvino.ui.logo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.vittamvino.db.MyDatabase
import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.db.wine.WineDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class LogoViewModel(application: Application): AndroidViewModel(application) {

    private val wineDao: WineDao

    init {
        val db = MyDatabase.getDatabase(application)
        wineDao = db!!.wineDao()
    }

    fun initDb() = runBlocking{
//        async(Dispatchers.Default) {
//            wineDao.insert(
//                Wine(
//                    Random.nextInt(),
//                    "wino",
//                    1.0,
//                    1,
//                    1,
//                    1
//                )
//            )
//        }
    }

}