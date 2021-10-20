package com.example.vittamvino.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vittamvino.R
import com.example.vittamvino.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.initializeRecyclerView(binding, requireContext())
        viewModel.initializeTabsWithListeners(binding, requireContext())
        viewModel.initSearchAction(binding, requireActivity())

        bindWinesList()
        initFabListener()


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFabListener() {
        binding.addWineButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_add_wine)
        }
    }

    private fun bindWinesList() {
        viewModel.wines.observe(requireActivity(), Observer { wine ->
            wine?.let{
                viewModel.handleTabs(binding, requireContext())
            }
        })
    }

}