package com.vangoog.lib

import kotlin.random.Random

fun main(){
//  val secret = (1..10).random()
    val secret = Random.nextInt(10) + 1
    println(secret)
    val limit = 3
    var count = 0
    while(true){
        println("Please enter a number(1-10):")
        val s = readLine()
        val number = s!!.toInt()
//        print(number)
        if (count < limit) {
            count++
            if (number > secret) {
                println("Smaller")
            } else if (number < secret) {
                println("Bigger")
            } else {
                println("You got it")
                break;
            }
        }  else {
            println ("hahaha")
            break
        }
    }
}

class Guess {
}