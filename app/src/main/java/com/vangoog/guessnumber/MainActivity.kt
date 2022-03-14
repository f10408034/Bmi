package com.vangoog.guessnumber

import android.app.AlertDialog
import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout
import com.vangoog.guessnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<GuessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counter.observe(this){
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(this) {state ->
            val message = when(state){
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "Start"
                else -> getString(R.string.somehting_goes_wrong)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)){ dialog, which ->
                    if(state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }

    }
    fun guess(veiw: View) {
        val num = binding.number.text.toString().toInt()
        viewModel.guess(num)
    }
}

