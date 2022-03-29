package com.example.colourmemory.ui.scores

import androidx.hilt.lifecycle.ViewModelInject
import com.example.core.base.BaseViewModel
import com.example.core.data.repository.ScoresRepository

/**
 * Created by Srikant on 02/05/2021.
 */

class ScoresViewModel @ViewModelInject constructor(private val scoresRepository: ScoresRepository) :
    BaseViewModel() {
    fun getAllScores() = scoresRepository.getAllScores()
}