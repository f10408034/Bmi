package com.vangoog.lib

class GraduateStudent(name: String, english: Int, math: Int)
    : Student(name,english,math){
    constructor(name: String): this(name, 0,0)
    constructor(): this("",0,0)

}

fun main() {
    var jenny = GraduateStudent("Jenny")
    jenny.print()

}