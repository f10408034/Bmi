package com.vangoog.lib
            //constructor 可以省略不寫
open class Student constructor(var name: String, var english: Int, var math: Int){
    companion object {
        var pass = 60
        fun test(){

        }
    }
    constructor(): this("",0,0){
        println("hi")
    }
    constructor(name: String): this(name, 0,0){
    }
//    Fields
//    var name: String? = null
//    var english: Float  = 0f
//    var math:Float = 0f
//    Methods
    fun print(){
        print("$name\t$english\t$math\t${average()}")
        if (average() < pass) println("*") else println()
    }
    fun average() = (english+math)/2
    fun highest() = if (english > math) english else math
    fun grading() = when (average()/10){
        in 9..10 -> 'A'
        8 -> 'B'
        7 -> 'C'
        6 -> 'D'
        else -> 'F'
    }
}

fun main() {
    val hank = Student("Hank",60,40)
//    val tom  = Student()
    val jack = Student("Jack",85,65)
//    jack.name = "jack"
//    jack.english = 85f
//    jack.math = 65f
    Student.pass = 60
    jack.print()
    hank.print()
//    tom.print()
}