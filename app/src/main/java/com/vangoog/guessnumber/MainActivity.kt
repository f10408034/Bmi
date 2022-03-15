package com.vangoog.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TtsSpan
import androidx.fragment.app.Fragment
import com.vangoog.guessnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding
    val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments()
        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_a ->{
                    supportFragmentManager.beginTransaction().run{
                        replace(R.id.container, fragments[0])
                        commit()
                    }
                    true
                }
                R.id.action_bmi ->{
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.container, fragments[1])
                        commit()
                    }
                    true
                }
                R.id.action_camera ->{
                    true
                }
                else -> true
            }
        }
        //insert database
        
    }

    private fun initFragments() {
        fragments.add(0, GuessFragment())
        fragments.add(1, BmiFragment())
//        val guess1to10Fragment = EmptyFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.container, guess1to10Fragment)
//        transaction.commit()

        //Kotlin way
        supportFragmentManager.beginTransaction().run {
            add(R.id.container, fragments[0])
            commit()
        }


    }
}

