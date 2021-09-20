package com.example.vittamvino.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vittamvino.R
import com.example.vittamvino.databinding.FragmentHomeBinding

class HomeViewModel : ViewModel() {

    private var chosenTab = 1

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun initializeTabsWithListeners(binding: FragmentHomeBinding, context: Context) {
        handleTabs(binding, context)
        initTabsOnClickListeners(binding, context)
    }

    private fun initTabsOnClickListeners(binding: FragmentHomeBinding, context: Context) {
        binding.categoryNameTV.setOnClickListener {
            chosenTab = 1
            handleTabs(binding, context)
        }

        binding.categoryTypeTV.setOnClickListener {
            chosenTab = 2
            handleTabs(binding, context)
        }

        binding.categoryProducerTV.setOnClickListener {
            chosenTab = 3
            handleTabs(binding, context)
        }

        binding.categoryFlavourTV.setOnClickListener {
            chosenTab = 4
            handleTabs(binding, context)
        }

        binding.categoryRatingTV.setOnClickListener {
            chosenTab = 5
            handleTabs(binding, context)
        }
    }

    private fun handleTabs(binding: FragmentHomeBinding, context: Context) {
        turnOffAllTabs(binding, context)
        turnOnCorrectTab(binding, context)
    }

    private fun turnOffAllTabs(binding: FragmentHomeBinding, context: Context) {
        binding.categoryNameTV.setBackgroundColor(context.getColor(R.color.colorRedGradientLight))
        binding.categoryTypeTV.setBackgroundColor(context.getColor(R.color.colorRedGradientLight))
        binding.categoryProducerTV.setBackgroundColor(context.getColor(R.color.colorRedGradientLight))
        binding.categoryFlavourTV.setBackgroundColor(context.getColor(R.color.colorRedGradientLight))
        binding.categoryRatingTV.setBackgroundColor(context.getColor(R.color.colorRedGradientLight))

    }

    private fun turnOnCorrectTab(binding: FragmentHomeBinding, context: Context) {
        when (chosenTab) {
            1 -> {
                binding.categoryNameTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
            }

            2 -> {
                binding.categoryTypeTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))

            }

            3 -> {
                binding.categoryProducerTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))

            }

            4 -> {
                binding.categoryFlavourTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))

            }

            5 -> {
                binding.categoryRatingTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))

            }
        }
    }
}