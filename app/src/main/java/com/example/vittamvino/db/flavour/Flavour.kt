package com.example.vittamvino.db.flavour

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flavour")
class Flavour(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String
)