package com.example.trivia

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.trivia.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 */
class FragmentTitle : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title, container, false)
        // Inflate the layout for this fragment


        //navigate to gamefragment on button click
        binding.playGameBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fragmentTitle_to_gameFragment) )


        //Menu enabled

        setHasOptionsMenu(true)
        return binding.root





//        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
//        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }
}
