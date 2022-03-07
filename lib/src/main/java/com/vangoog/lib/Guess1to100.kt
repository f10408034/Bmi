package com.vangoog.lib

import kotlin.random.Random

fun main(){
    val secret = Random.nextInt(100)+1
    println(secret)
    var max = 100
    var min = 1
    val limit = 3
    var count = 0
    var num = 0

    for (i in 0..limit){
        println("Please enter a number between $min to $max ")
        num = readLine()!!.toInt()
        println(count)
        if (count <= limit) {
            count++
            if (num > secret) {
                max = num
            } else {
                if (num < secret) {
                    min = num
                } else {
                    println("You got it, the secret number is $num")
                    break
                }
            }
        } else {
            println("Exceeded times, hahaha loser!! ")
            break
        }
    }
//    while (num != secret) {
//        println("Please enter a number between $min to $max ")
//        num = readLine()!!.toInt()
//        readLine()?.let {
//            count++
//            if (count != limit) {
//                num = it.toInt()
//                if (num > secret) {
//                    max = num
//                } else if (num < secret) {
//                    min = num
//                } else {
//                    println("You got it, the secret number is $num")
//                }
//            }else {
//                println("Exceeded times, hahaha loser!! ")
//            }
//
//        }
//    }
}


class Guess1to100 {
}