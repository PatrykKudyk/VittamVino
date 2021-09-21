package com.example.vittamvino.helpers

import com.example.vittamvino.enums.AdapterTypeEnum
import com.example.vittamvino.models.WineRow

class WinesListSortHelper {

    fun sortList(list: ArrayList<WineRow>, sortType: AdapterTypeEnum): ArrayList<WineRow> {
        return when (sortType) {
            AdapterTypeEnum.Name -> sortByName(list)
            AdapterTypeEnum.Flavour -> sortByFlavour(list)
            AdapterTypeEnum.Producer -> sortByProducer(list)
            AdapterTypeEnum.Rating -> sortByRating(list)
            AdapterTypeEnum.Type -> sortByType(list)
        }
    }

    private fun sortByName(list: ArrayList<WineRow>): ArrayList<WineRow> {
        list.sortBy { it.name }
        return list
    }

    private fun sortByFlavour(list: ArrayList<WineRow>): ArrayList<WineRow> {
        list.sortBy { it.flavour }
        val flavoursMap = HashMap<String, Boolean>()
        for(wine in list){
            if (!flavoursMap.contains(wine.flavour.name)) {
                wine.category = wine.flavour.name
                flavoursMap[wine.flavour.name] = true
            }
            else {
                wine.category = null
            }
        }
        return list
    }

    private fun sortByProducer(list: ArrayList<WineRow>): ArrayList<WineRow> {
        list.sortBy { it.producer }
        val producersMap = HashMap<String, Boolean>()
        for(wine in list){
            if (!producersMap.contains(wine.producer)) {
                wine.category = wine.producer
                producersMap[wine.producer] = true
            }
            else {
                wine.category = null
            }
        }
        return list
    }

    private fun sortByRating(list: ArrayList<WineRow>): ArrayList<WineRow> {
        list.sortByDescending { it.rating }
        return list
    }

    private fun sortByType(list: ArrayList<WineRow>): ArrayList<WineRow> {
        list.sortBy { it.type }
        val typesMap = HashMap<String, Boolean>()
        for(wine in list){
            if (!typesMap.contains(wine.type)) {
                wine.category = wine.type
                typesMap[wine.type] = true
            }
            else {
                wine.category = null
            }
        }
        return list
    }


}