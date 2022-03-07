package com.vangoog.lib

fun main() {
    var p: Int
    for (i in 2..9) {
        for (j in 1..9) {
            p = i * j
//            println("$i*$j=${if (p < 10) "0" else ""}$p")

            var space = if (p < 10) "0" else ""
                println("$i*$j=$space$p")

        }
        println("")
    }
}
class Night {
}