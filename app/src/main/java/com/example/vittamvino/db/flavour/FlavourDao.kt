package com.example.vittamvino.db.flavour

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FlavourDao {
    @Insert
    fun insert(flavour: Flavour)

    @get:Query("SELECT * FROM flavour")
    val allFlavours: LiveData<List<Flavour?>>
}