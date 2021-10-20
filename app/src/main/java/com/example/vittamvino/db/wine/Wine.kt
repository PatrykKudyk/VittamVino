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
    val producerId: Int,
    @ColumnInfo
    val typeId: Int,
    @ColumnInfo
    val flavourId: Int
)