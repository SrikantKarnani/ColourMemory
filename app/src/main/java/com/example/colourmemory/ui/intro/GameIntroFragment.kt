package com.example.colourmemory.ui.intro

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.colourmemory.R
import com.example.colourmemory.databinding.FragmentIntroBinding
import com.example.core.base.BaseFragmentNoVM

/**
 * Created by Srikant on 02/05/2021.
 */

class GameIntroFragment : BaseFragmentNoVM<FragmentIntroBinding>(R.layout.fragment_intro) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnStartGame.setOnClickListener {
            findNavController().navigate(GameIntroFragmentDirections.actionIntroToGameFragment())
        }
    }
}