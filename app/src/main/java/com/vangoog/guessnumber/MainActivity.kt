package com.vangoog.guessnumber

import android.app.AlertDialog
import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.vangoog.guessnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var game = NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun guess(veiw: View){
        val num = binding.number.text.toString().toInt()
        val state = game.guess(num)
        val message = when(state){
            NumberGame.GameState.BIGGER -> getString(R.string.bigger)
            NumberGame.GameState.SMALLER -> getString(R.string.smaller)
            NumberGame.GameState.BINGO -> getString(R.string.bingo)
            else -> getString(R.string.somehting_goes_wrong)


        }

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)){ dialog, which ->
                if (game.end) game.reset()
                updateUI()
            }
            .show()
        updateUI()
    }

    private fun updateUI() {
        binding.tvCounter.text = game.counter.toString()
    }

}

