package com.example.colourmemory.ui.game

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.data.models.entity.Scores
import com.example.core.data.repository.ScoresRepository
import com.example.core.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Srikant on 02/05/2021.
 */

class GameViewModel @ViewModelInject constructor(private val scoresRepository: ScoresRepository) :
    BaseViewModel() {
    private val _liveScore = SingleLiveEvent<Int>()
    val liveScore: LiveData<Int> = _liveScore
    private var pairsMatched = 0
    private val _tagToDisable = SingleLiveEvent<String>()
    val tagToDisable: LiveData<String> = _tagToDisable
    private val _matchFinished = SingleLiveEvent<Int>()
    val matchFinished: LiveData<Int> = _matchFinished
    private val _tagToReset = SingleLiveEvent<String>()
    val tagToReset: LiveData<String> = _tagToReset
    var previousOpenedTag: Int? = null

    fun resetGame() {
        _liveScore.postValue(0)
        previousOpenedTag = null
        pairsMatched = 0
    }

    fun makeMove(tag: String) {
        if (previousOpenedTag == null) {
            previousOpenedTag = tag.toInt()
        } else {
            if (previousOpenedTag == tag.toInt() * -1) {
                pairsMatched++
                _liveScore.value = ((_liveScore.value ?: 0) + 2)
                _tagToDisable.postValue(tag)
                if (pairsMatched == 8) {
                    getRank(_liveScore.value ?: 0)
                }
            } else {
                _tagToReset.value = previousOpenedTag.toString()
                _liveScore.postValue((_liveScore.value ?: 0) - 1)
                _tagToReset.value = tag
            }
            previousOpenedTag = null
        }
    }

    fun saveScore(scores: Scores) = viewModelScope.launch(Dispatchers.IO) {
        scoresRepository.saveScore(scores)
    }

    private fun getRank(score: Int) = viewModelScope.launch(Dispatchers.IO) {
        _matchFinished.postValue(scoresRepository.getRank(score) + 1)
    }
}