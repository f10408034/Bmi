package com.vangoog.lib

class BoxTest constructor(var length: Int, var width: Int, var height: Int){
    fun boxCheck(){
        println("Your box size is $length * $width * $height")
        if ((width >= 15) && (height >= 15)) {
            println(" You can use box3 70$ ")
        } else {
            if (height >= 15 ) {
                println(" You can use box2 60$ ")
            } else {
                println(" You can use box1 50$ ")
            }
        }
    }
}

fun main(){
    println("Please enter your box size")
    print("Box Length :")
    val l = readLine()!!.toInt()
    print("Box Width :")
    val w = readLine()!!.toInt()
    print("Box Height :")
    val h = readLine()!!.toInt()

    val Box1 = BoxTest(l,w,h)
    Box1.boxCheck()
}