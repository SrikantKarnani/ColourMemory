package com.example.colourmemory.ui.scores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.colourmemory.databinding.RowScoresBinding
import com.example.core.data.models.entity.Scores

/**
 * Created by Srikant on 02/05/2021.
 */

class ScoresAdapter(val list: MutableList<Scores> = mutableListOf()) : RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {
    inner class ScoresViewHolder(private val binding: RowScoresBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(scores: Scores) {
            binding.scores = scores
        }
    }

    fun updateList(newList: List<Scores>){
        val calculateDiff = DiffUtil.calculateDiff(ScoresDiffCallback(list, newList), true)
        list.clear()
        list.addAll(newList)
        calculateDiff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoresViewHolder {
        return ScoresViewHolder(RowScoresBinding.inflate((parent.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater), parent, false))
    }

    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) {
        holder.bind(list[position].apply { rank = (position + 1).toString() })
    }

    override fun getItemCount(): Int = list.size
}