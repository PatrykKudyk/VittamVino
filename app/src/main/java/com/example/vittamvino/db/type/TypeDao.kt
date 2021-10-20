package com.example.vittamvino.db.type

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TypeDao {

    @Insert
    fun insert(type: Type)

    @get:Query("SELECT * FROM type")
    val allTypes: LiveData<List<Type?>>
}