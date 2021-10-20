package com.example.vittamvino.db.producer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producer")
class Producer(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String
)