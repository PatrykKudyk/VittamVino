package com.example.vittamvino.ui.addProducer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vittamvino.R
import com.example.vittamvino.databinding.FragmentAddProducerBinding
import com.example.vittamvino.databinding.FragmentAddWineBinding
import com.example.vittamvino.ui.addWine.AddWineViewModel

class AddProducerFragment: Fragment() {


    private lateinit var viewModel: AddProducerViewModel
    private var _binding: FragmentAddProducerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AddProducerViewModel::class.java)

        _binding = FragmentAddProducerBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}