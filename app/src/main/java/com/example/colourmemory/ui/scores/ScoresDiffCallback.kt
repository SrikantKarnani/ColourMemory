package com.example.colourmemory.ui.scores

import androidx.recyclerview.widget.DiffUtil
import com.example.core.data.models.entity.Scores

/**
 * Created by Srikant on 02/05/2021.
 */

class ScoresDiffCallback(val oldList : List<Scores>, val newList : List<Scores>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}