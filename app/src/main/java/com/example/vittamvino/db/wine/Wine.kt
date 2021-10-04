package com.example.vittamvino.db.wine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wine")
class Wine(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val rating: Double,
    @ColumnInfo
    val producer: String,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val flavour: String
)