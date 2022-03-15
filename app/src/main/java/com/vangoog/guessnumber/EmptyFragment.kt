package com.vangoog.guessnumber

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vangoog.guessnumber.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment() {
    lateinit var binding: FragmentEmptyBinding
    val viewModel by viewModels<GuessViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val num = binding.number.text.toString().toInt()
            viewModel.guess(num)
        }
        viewModel.counter.observe(viewLifecycleOwner){
            binding.tvCounter.setText(it.toInt())
        }
        viewModel.gameState.observe(viewLifecycleOwner) {state ->
            val message = when(state){
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "Start"
                else -> getString(R.string.somehting_goes_wrong)
            }
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)){ dialog, which ->
                    if(state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }
    }
}