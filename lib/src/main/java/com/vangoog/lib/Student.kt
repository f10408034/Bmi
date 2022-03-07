package com.vangoog.lib
            //constructor 可以省略不寫
open class Student constructor(var name: String, var english: Int, var math: Int){
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
        println("$name\t$english\t$math\t${average()}")
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
    val hank = Student("Hank")
//    val tom  = Student()
    val jack = Student("Jack",85,65)
//    jack.name = "jack"
//    jack.english = 85f
//    jack.math = 65f
    jack.print()
    hank.print()
//    tom.print()
}