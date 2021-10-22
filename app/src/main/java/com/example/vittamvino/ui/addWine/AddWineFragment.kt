package com.example.vittamvino.ui.addWine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vittamvino.R
import com.example.vittamvino.databinding.FragmentAddWineBinding

class AddWineFragment : Fragment() {

    private lateinit var viewModel: AddWineViewModel
    private var _binding: FragmentAddWineBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AddWineViewModel::class.java)

        _binding = FragmentAddWineBinding.inflate(inflater, container, false)

        initListeners()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initListeners() {
        binding.addButton.setOnClickListener {
            viewModel.addWine(binding)
            findNavController().popBackStack()
        }

        binding.producerCardView.setOnClickListener {
            findNavController().navigate(R.id.action_nav_add_wine_to_nav_choose_producer)
        }
    }
}