package com.vangoog.guessnumber

class NumberGame {

    enum class GameState {
        INIT, BIGGER, SMALLER, BINGO, END
    }

    var secret = 0
    var counter = 0
    var end = false
    init {
        reset()
    }
    fun reset(){

        secret = (1..10).random()
        counter = 0
        end = false
    }

    fun guess(num: Int): GameState{
        counter++
        val message = if (num > secret) GameState.SMALLER
        else if (num < secret) GameState.BIGGER
            else {
            end =true
            GameState.BINGO
        }
        return message
    }
}