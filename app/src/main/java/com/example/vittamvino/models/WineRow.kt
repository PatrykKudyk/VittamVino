package com.example.vittamvino.models

import android.graphics.drawable.Drawable
import com.example.vittamvino.enums.WineFlavourEnum

data class WineRow(
    var category: String?,
    var name: String,
    var image: Drawable?,
    val rating: Double,
    val producer: String,
    val type: String,
    val flavour: WineFlavourEnum
)