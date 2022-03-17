package com.vangoog.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TtsSpan
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vangoog.guessnumber.databinding.ActivityMainBinding
import kotlin.concurrent.thread

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
        val t1 = Transaction(1,"Se7en", "1231321564", 3000, 1)
        val database = Room.databaseBuilder(this,
                            TranDatabase::class.java,"trans.db")
            .build()
        thread {
            database.transactionDao().insert(t1)
        }
    }

    private fun initFragments() {
        fragments.add(0, GuessFragment())
        fragments.add(1, BmiFragment())
//        val guess1to10Fragment = EmptyFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.container, guess1to10Fragment)
//        transaction.commit()


        //passing arguments with Fragment
        val p = Person("Hank", 66.5f, 1.7f)
        val bundle = Bundle().apply {
            putString("NAME", "Hank")
            putParcelable("PERSON", p)
        }
        fragments[0].arguments = bundle

        //Kotlin way
        supportFragmentManager.beginTransaction().run {
            add(R.id.container, fragments[0])
            commit()
        }
    }
    fun changFragment(num: Int){

    }

}

