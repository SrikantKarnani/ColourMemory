package com.example.colourmemory.ui.game

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.colourmemory.R
import com.example.core.data.models.entity.Scores
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

/**
 * Created by Srikant on 02/05/2021.
 */

class SaveScoreDialog : DialogFragment() {

    val args by navArgs<SaveScoreDialogArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_save_score, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogStyle)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<MaterialTextView>(R.id.tv_score)?.text = getString(R.string.scores, args.score, args.rank)
        view?.findViewById<MaterialButton>(R.id.btn_cancel)?.setOnClickListener {
            navigateBackToFragment(null)
        }
        view?.findViewById<MaterialButton>(R.id.btn_save)?.setOnClickListener {
            if(view?.findViewById<TextInputEditText>(R.id.tiel_name)?.text.isNullOrBlank()){
                Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                navigateBackToFragment(
                    Scores(
                        view?.findViewById<TextInputEditText>(R.id.tiel_name)?.text.toString(),
                        args.score
                    )
                )
            }
        }
    }


    private fun navigateBackToFragment(scores: Scores?) {
        //Setting the result in the stateHandle of the previousBackStackEntry before navigating back to Fragment A
        //will allow Fragment A to access the result in the stateHandle of its currentBackStackEntry
        val savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(GameFragment.RESULT_OF_SAVE, scores?.name)
        findNavController().navigateUp()
    }

}