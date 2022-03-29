package com.example.core.data.repository

import com.example.core.data.cache.dao.ScoresDao
import com.example.core.data.models.entity.Scores
import javax.inject.Inject

class ScoresRepository @Inject constructor(
    private val scoresDao: ScoresDao
) {
    suspend fun saveScore(score: Scores) {
        scoresDao.insert(score)
    }

    suspend fun getRank(score:Int) : Int{
       return scoresDao.getRank(score)
    }

    fun getAllScores() = scoresDao.getAllScores()
}