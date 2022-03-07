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
    var secret = (1..10).random()
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity","secret: $secret")
    }

    fun guess(veiw: View){
        counter++
        binding.tvCounter.text = counter.toString()
        val num = binding.number.text.toString().toInt()
        val message = if (num < secret) "Bigger"
            else if (num > secret) "Smaller"
            else {
                secret = (1..10).random()
                counter = 0
                "You got it"
            }
        AlertDialog.Builder(this)
            .setTitle("Guess")
            .setMessage(message)
            .setPositiveButton("OK"){ dialog , which ->
                Log.d("MainActivity", "Reset ")
            }
            .show()
    }

}

fun main() {

}

