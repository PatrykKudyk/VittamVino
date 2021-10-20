package com.example.vittamvino.db.type

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type")
class Type(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String
)