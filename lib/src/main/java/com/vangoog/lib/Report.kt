package com.vangoog.lib

import com.vangoog.lib.FindReport as FindReport1

interface Report {
    fun print()
}

class FinanceReport : Report {
    override fun print() {
        println("Finance")
    }

}

class FindReport : Report{
    override fun print() {
        println("Finance")
    }
}

fun main(){
    val financeReport = FinanceReport()
    financeReport.print()
    //anonymous class
    object : Report {
        override fun print() {
            println("Health!!")
        }
    }.print()
}