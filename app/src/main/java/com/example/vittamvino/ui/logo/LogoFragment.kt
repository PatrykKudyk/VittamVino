package com.example.vittamvino.ui.logo

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vittamvino.R
import com.example.vittamvino.databinding.FragmentHomeBinding
import com.example.vittamvino.databinding.FragmentLogoBinding
import com.example.vittamvino.ui.home.HomeViewModel

class LogoFragment: Fragment() {

    private var _binding: FragmentLogoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLogoBinding.inflate(inflater, container, false)
        val root: View = binding.root


//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        Handler().postDelayed({
            findNavController().navigate(R.id.action_logo_fragment_to_nav_home)
        }, 4000)

        return root
    }

    override fun onStart() {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        super.onStart()
    }

    override fun onStop() {
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        super.onStop()
    }
}