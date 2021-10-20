package com.example.vittamvino.db.producer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProducerDao {

    @Insert
    fun insert(producer: Producer)

    @get:Query("SELECT * FROM producer")
    val allProducers: LiveData<List<Producer?>>

}