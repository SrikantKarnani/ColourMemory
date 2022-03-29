package com.example.core.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.core.data.models.entity.Scores

@Dao
interface ScoresDao {

    @Insert
    suspend fun insert(scores: Scores)

    @Query("Select * from Scores order by score desc")
    fun getAllScores(): LiveData<List<Scores>>

    @Query("Select count(*) from Scores where score >= :score")
    suspend fun getRank(score : Int) : Int
}