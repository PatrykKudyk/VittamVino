package com.example.vittamvino.db.wine

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WineDao {
    @Insert
    fun insert(wine: Wine)

    @get:Query("SELECT * FROM wine")
    val allWines: LiveData<List<Wine?>>
}