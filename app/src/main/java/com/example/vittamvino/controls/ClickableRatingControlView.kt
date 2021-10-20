package com.example.vittamvino.controls

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class ClickableRatingControlView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    init{
        orientation = HORIZONTAL

    }
}