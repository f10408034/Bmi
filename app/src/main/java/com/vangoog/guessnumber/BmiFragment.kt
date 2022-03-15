package com.vangoog.guessnumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vangoog.guessnumber.databinding.FragmentBmiBinding


class BmiFragment : Fragment() {
    lateinit var binding: FragmentBmiBinding
    val viewModel by viewModels<BmiViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBmiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bBmi.setOnClickListener {
            viewModel.bmi.observe(viewLifecycleOwner) {bmi ->
                binding.tvResult.setText(bmi.toString())
            }
            val weight = binding.edWeight.text.toString().toFloat()
            val height = binding.edHeight.text.toString().toFloat()
            viewModel.set(weight,height).toString()
        }
    }
}