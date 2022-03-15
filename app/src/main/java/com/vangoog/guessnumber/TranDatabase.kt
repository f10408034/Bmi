package com.vangoog.guessnumber

import androidx.room.Database


@Database(entities = arrayOf(Transaction::class), version = 1)
abstract class TranDatabase {
    abstract fun transactionDao(): TransactionDao
}