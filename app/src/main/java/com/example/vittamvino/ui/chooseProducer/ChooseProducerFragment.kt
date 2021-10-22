package com.example.vittamvino.ui.chooseProducer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vittamvino.R
import com.example.vittamvino.converters.ProducersConverter
import com.example.vittamvino.databinding.FragmentChooseProducerBinding

class ChooseProducerFragment : Fragment() {

    private lateinit var viewModel: ChooseProducerViewModel
    private var _binding: FragmentChooseProducerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ChooseProducerViewModel::class.java)
        _binding = FragmentChooseProducerBinding.inflate(inflater, container, false)

        viewModel.initRecyclerView(binding, requireContext())
        bindProducersList()
        initListeners()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindProducersList() {
        viewModel.producers.observe(requireActivity(), Observer { wine ->
            wine?.let {
                viewModel.refreshProducersInRecyclerView(
                    ProducersConverter().convertProducersToProducerRows(
                        viewModel.producers.value!!
                    )
                )
            }
        })
    }

    private fun initListeners() {
        binding.addProducerFab.setOnClickListener {
            findNavController().navigate(R.id.action_nav_choose_producer_to_nav_add_producer)
        }
    }
}
