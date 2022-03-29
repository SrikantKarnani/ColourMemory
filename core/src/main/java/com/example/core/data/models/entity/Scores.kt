package com.example.core.data.models.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Scores(
    val name: String,
    val score: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
){
    @Ignore var rank : String?=null
}
