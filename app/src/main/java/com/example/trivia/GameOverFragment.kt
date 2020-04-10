package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(
            inflater, R.layout.fragment_game_over, container, false)

        binding.tryAgainButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameOverFragment_to_gameFragment))
        return  binding.root
    }

}
