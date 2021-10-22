package com.example.vittamvino.converters

import com.example.vittamvino.db.producer.Producer
import com.example.vittamvino.models.ProducerRow

class ProducersConverter {

    fun convertProducersToProducerRows(inputList: List<Producer?>): ArrayList<ProducerRow> {
        val outputList = ArrayList<ProducerRow>()

        for (producer in inputList) {
            outputList.add(
                ProducerRow(
                    producer!!.name
                )
            )
        }

        return outputList
    }
}