package com.example.colourmemory.ui.game

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.view.children
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.colourmemory.R
import com.example.colourmemory.databinding.FragmentGameBinding
import com.example.core.base.BaseFragment
import com.example.core.data.models.entity.Scores
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Srikant on 02/05/2021.
 */

@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding, GameViewModel>(R.layout.fragment_game),
    View.OnClickListener {
    override fun getViewModelClass(): Class<GameViewModel> = GameViewModel::class.java

    override fun getViewModelOwner(): ViewModelStoreOwner = this

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_high_scores -> {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToHighScoresFragment())
            }
            R.id.btn_restart -> {
                resetGame()
            }
            else -> {
                if (v is ImageFilterView) {
                    v.clearAnimation()
                    v.animate().rotationBy(360f).setDuration(500).setUpdateListener { animation ->
                        v.crossfade = animation?.animatedFraction ?: 0f
                    }
                    Handler(Looper.getMainLooper()).postDelayed({
                        viewModel.makeMove(v.tag.toString())
                    }, 1500)
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        resetGame()
        binding.color1.setOnClickListener(this)
        binding.color1alter.setOnClickListener(this)
        binding.color2.setOnClickListener(this)
        binding.color2alter.setOnClickListener(this)
        binding.color3.setOnClickListener(this)
        binding.color4.setOnClickListener(this)
        binding.color5.setOnClickListener(this)
        binding.color6.setOnClickListener(this)
        binding.color7.setOnClickListener(this)
        binding.color8.setOnClickListener(this)
        binding.color3alter.setOnClickListener(this)
        binding.color4alter.setOnClickListener(this)
        binding.color5alter.setOnClickListener(this)
        binding.color6alter.setOnClickListener(this)
        binding.color7alter.setOnClickListener(this)
        binding.color8alter.setOnClickListener(this)
        binding.btnHighScores.setOnClickListener(this)
        binding.btnRestart.setOnClickListener(this)
        viewModel.liveScore.observe(viewLifecycleOwner, Observer {
            binding.tvScore.text = it.toString()
        })
        viewModel.tagToDisable.observe(viewLifecycleOwner, Observer {
            binding.root.findViewWithTag<ImageFilterView>(it).apply {
                this.isEnabled = false
                this.alpha = 0f
            }
            binding.root.findViewWithTag<ImageFilterView>((it.toInt() * -1).toString()).apply {
                isEnabled = false
                alpha = 0f
            }
        })
        viewModel.tagToReset.observe(viewLifecycleOwner, Observer {
            binding.root.post {
                binding.root.findViewWithTag<ImageFilterView>(it).apply {
                    this.clearAnimation()
                    animate().rotationBy(360f).setDuration(500).setUpdateListener { animation ->
                        crossfade = 1f- (animation?.animatedFraction ?: 0f)
                    }
                }
            }
        })

        viewModel.matchFinished.observe(viewLifecycleOwner, Observer {
            binding.btnRestart.visibility = View.VISIBLE
            findNavController().navigate(
                GameFragmentDirections.actionGameFragmentToSaveScoreDialog(
                    viewModel.liveScore.value ?: 0, it
                )
            )
        })

        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry?.savedStateHandle
        savedStateHandle?.getLiveData<String?>(RESULT_OF_SAVE)
            ?.observe(currentBackStackEntry, Observer { result ->
                result?.let {
                    viewModel.saveScore(Scores(it, viewModel.liveScore.value ?: 0))
                }
            })
    }

    private fun resetGame() {
        binding.flow.referencedIds = binding.flow.referencedIds.toList().shuffled().toIntArray()
        for (v in binding.main.children) {
            if (v is ImageFilterView) {
                v.post {
                    v.clearAnimation()
                    v.crossfade = 1f
                    v.isEnabled = true
                    v.alpha = 1f
                    Handler(Looper.getMainLooper()).postDelayed({
                        v.animate().rotationBy(360f).setDuration(1000)
                            .setUpdateListener { animation ->
                                v.crossfade = 1f - (animation?.animatedFraction ?: 0f)
                            }
                    }, 2000L)
                }
            }
        }
        binding.btnRestart.visibility = View.GONE
        viewModel.resetGame()
    }

    companion object {
        const val RESULT_OF_SAVE = "RESULT_OF_SAVE"
    }
}