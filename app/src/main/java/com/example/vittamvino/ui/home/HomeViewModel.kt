package com.example.vittamvino.ui.home

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vittamvino.R
import com.example.vittamvino.adapters.WinesRecyclerViewAdapter
import com.example.vittamvino.databinding.FragmentHomeBinding
import com.example.vittamvino.db.MyDatabase
import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.db.wine.WineDao
import com.example.vittamvino.enums.AdapterTypeEnum
import com.example.vittamvino.enums.WineFlavourEnum
import com.example.vittamvino.helpers.WinesListSortHelper
import com.example.vittamvino.models.WineRow

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var recyclerViewAdapter: WinesRecyclerViewAdapter
    private var chosenTab = 1
    private var adapterType = AdapterTypeEnum.Name
    private var searchPhrase = ""
    private val wineDao: WineDao
    private val wines: LiveData<List<Wine?>>

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    init {
        val db = MyDatabase.getDatabase(application)
        wineDao = db!!.winesDao()
        wines = wineDao.allWines
    }

    fun initializeRecyclerView(binding: FragmentHomeBinding, context: Context) {
        recyclerViewAdapter = WinesRecyclerViewAdapter(context)
        binding.winesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.winesRecyclerView.adapter = recyclerViewAdapter
    }

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
        binding.categoryNameTV.setBackgroundColor(context.getColor(R.color.colorRed))
        binding.categoryTypeTV.setBackgroundColor(context.getColor(R.color.colorRed))
        binding.categoryProducerTV.setBackgroundColor(context.getColor(R.color.colorRed))
        binding.categoryFlavourTV.setBackgroundColor(context.getColor(R.color.colorRed))
        binding.categoryRatingTV.setBackgroundColor(context.getColor(R.color.colorRed))

        binding.categoryNameTV.setTextColor(context.getColor(R.color.colorRedBackground))
        binding.categoryTypeTV.setTextColor(context.getColor(R.color.colorRedBackground))
        binding.categoryProducerTV.setTextColor(context.getColor(R.color.colorRedBackground))
        binding.categoryFlavourTV.setTextColor(context.getColor(R.color.colorRedBackground))
        binding.categoryRatingTV.setTextColor(context.getColor(R.color.colorRedBackground))
    }

    private fun turnOnCorrectTab(binding: FragmentHomeBinding, context: Context) {
        when (chosenTab) {
            1 -> {
                binding.categoryNameTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
                binding.categoryNameTV.setTextColor(context.getColor(R.color.black))
                recyclerViewAdapter.setItems(
                    WinesListSortHelper().filterAndSortList(
                        mockWines(
                            context
                        ), AdapterTypeEnum.Name, searchPhrase
                    )
                )
                adapterType = AdapterTypeEnum.Name
                binding.winesRecyclerView.scrollToPosition(0)
            }

            2 -> {
                binding.categoryTypeTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
                binding.categoryTypeTV.setTextColor(context.getColor(R.color.black))
                recyclerViewAdapter.setItems(
                    WinesListSortHelper().filterAndSortList(
                        mockWines(
                            context
                        ), AdapterTypeEnum.Type, searchPhrase
                    )
                )
                adapterType = AdapterTypeEnum.Type
                binding.winesRecyclerView.scrollToPosition(0)
            }

            3 -> {
                binding.categoryProducerTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
                binding.categoryProducerTV.setTextColor(context.getColor(R.color.black))
                recyclerViewAdapter.setItems(
                    WinesListSortHelper().filterAndSortList(
                        mockWines(
                            context
                        ), AdapterTypeEnum.Producer, searchPhrase
                    )
                )
                adapterType = AdapterTypeEnum.Producer
                binding.winesRecyclerView.scrollToPosition(0)
            }

            4 -> {
                binding.categoryFlavourTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
                binding.categoryFlavourTV.setTextColor(context.getColor(R.color.black))
                recyclerViewAdapter.setItems(
                    WinesListSortHelper().filterAndSortList(
                        mockWines(
                            context
                        ), AdapterTypeEnum.Flavour, searchPhrase
                    )
                )
                adapterType = AdapterTypeEnum.Flavour
                binding.winesRecyclerView.scrollToPosition(0)
            }

            5 -> {
                binding.categoryRatingTV.setBackgroundColor(context.getColor(R.color.colorRedBackground))
                binding.categoryRatingTV.setTextColor(context.getColor(R.color.black))
                recyclerViewAdapter.setItems(
                    WinesListSortHelper().filterAndSortList(
                        mockWines(
                            context
                        ), AdapterTypeEnum.Rating, searchPhrase
                    )
                )
                adapterType = AdapterTypeEnum.Rating
                binding.winesRecyclerView.scrollToPosition(0)
            }
        }
    }



    fun initSearchAction(binding: FragmentHomeBinding, activity: Activity) {
        binding.searchEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard(activity)
                    performSearch(activity, p0?.text.toString())
                    return true
                }
                return false
            }

        })
    }

    private fun performSearch(activity: Activity, phrase: String) {
        searchPhrase = phrase
        var wines = WinesListSortHelper().filterAndSortList(
            mockWines(activity),
            adapterType,
            phrase.trim().lowercase()
        )
        recyclerViewAdapter.setItems(wines)
    }


    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = activity.currentFocus

        if (view == null) {
            view = View(activity)
        }

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }



//    private fun mockWines(context: Context): ArrayList<WineRow> {
//        return arrayListOf(
//            WineRow(
//                null,
//                "Wino1",
//                context.getDrawable(R.drawable.img),
//                3.5,
//                "Producent1",
//                "Typ1",
//                WineFlavourEnum.RedDry
//            ),
//            WineRow(
//                null,
//                "Wino2",
//                context.getDrawable(R.drawable.img),
//                3.8,
//                "Producent2",
//                "Typ1",
//                WineFlavourEnum.RedSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino3",
//                null,
//                1.2,
//                "Producent1",
//                "Typ2",
//                WineFlavourEnum.RedDry
//            ),
//            WineRow(
//                null,
//                "Wino4",
//                null,
//                4.2112,
//                "Producent3",
//                "Typ2",
//                WineFlavourEnum.WhiteDry
//            ),
//            WineRow(
//                null,
//                "Wino5",
//                context.getDrawable(R.drawable.img),
//                5.0,
//                "Producent3",
//                "Typ6",
//                WineFlavourEnum.RedDry
//            ),
//            WineRow(
//                null,
//                "Wino6",
//                context.getDrawable(R.drawable.img),
//                2.7,
//                "Producent7",
//                "Typ5",
//                WineFlavourEnum.RedDry
//            ),
//            WineRow(
//                null,
//                "Wino7",
//                null,
//                3.211,
//                "Producent21",
//                "Typ6",
//                WineFlavourEnum.RedSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino8",
//                null,
//                3.1,
//                "Producent21",
//                "Typ3",
//                WineFlavourEnum.RedSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino10",
//                context.getDrawable(R.drawable.img),
//                3.22,
//                "Producent12",
//                "Typ1",
//                WineFlavourEnum.RedSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino10",
//                null,
//                3.99,
//                "Producent13",
//                "Typ4",
//                WineFlavourEnum.WhiteSweet
//            ),
//            WineRow(
//                null,
//                "Wino11",
//                context.getDrawable(R.drawable.img),
//                3.0,
//                "Producent14",
//                "Typ3",
//                WineFlavourEnum.WhiteSweet
//            ),
//            WineRow(
//                null,
//                "Wino11",
//                null,
//                3.9,
//                "Producent16",
//                "Typ2",
//                WineFlavourEnum.WhiteSweet
//            ),
//            WineRow(
//                null,
//                "Wino13",
//                null,
//                3.1,
//                "Producent18",
//                "Typ1",
//                WineFlavourEnum.WhiteSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino14",
//                null,
//                3.8,
//                "Producent91",
//                "Typ2",
//                WineFlavourEnum.WhiteSemiSweet
//            ),
//            WineRow(
//                null,
//                "Wino14",
//                context.getDrawable(R.drawable.img),
//                3.2,
//                "Producent91",
//                "Typ1",
//                WineFlavourEnum.WhiteSemiSweet
//            )
//        )
//    }

}