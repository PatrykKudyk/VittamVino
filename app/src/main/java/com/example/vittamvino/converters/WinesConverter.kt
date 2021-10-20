package com.example.vittamvino.converters

import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.enums.WineFlavourEnum
import com.example.vittamvino.models.WineRow

class WinesConverter {

    fun convertWinesToWineRows(givenList: List<Wine?>): ArrayList<WineRow>{
        val outputList = ArrayList<WineRow>()
//        for (wine in givenList){
////            outputList.add(
////                WineRow(
////                    null,
////                    wine!!.name,
////                    null,
////                    wine.rating,
////                    wine.producer,
////                    wine.type,
////                    WineFlavourEnum.valueOf(wine.flavour)
////                )
////            )
////        }
          for (wine in givenList){
            outputList.add(
                WineRow(
                    null,
                    wine!!.name,
                    null,
                    wine.rating,
                    "producent",
                    "typ",
                    WineFlavourEnum.WhiteSweet
                )
            )
        }

        return outputList
    }
}