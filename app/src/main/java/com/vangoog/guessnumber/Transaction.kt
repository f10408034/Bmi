package com.vangoog.guessnumber

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val account: String,
    @ColumnInfo(name="CreateAt")
    val date: String,
    @ColumnInfo(name = "amount")
    val amount:Int,

    val type:Int) {

}