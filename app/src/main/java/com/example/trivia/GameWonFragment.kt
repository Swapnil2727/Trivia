package com.example.trivia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentGameWonBinding

/**
 * A simple [Fragment] subclass.
 */
class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflate layout for this fragment

        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_won,container,false)

        //onClick Play again

        binding.playAgainButton.setOnClickListener(View.OnClickListener { view: View? ->

            view?.findNavController()?.navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())

        })
        setHasOptionsMenu(true)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu,menu)

        //check if activity found to handle intent, in this case it will handle because our type is text, but This is best practice for complex types

        if(null == getShareIntent()?.resolveActivity(activity!!.packageManager))
        {
            menu.findItem(R.id.share).isVisible = false
        }


    }

    private fun getShareIntent(): Intent? {

        var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
//        This is simple method but we are using different using ShareCompat
//        val shareIntent = Intent(Intent.ACTION_SEND)
//
//        shareIntent.setType("text/plain").
//            putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text,args?.numCorrect,args?.numQuestions))
//
//        return shareIntent
        return activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(getString(R.string.share_success_text,args?.numCorrect,args?.numQuestions))
                .setType("text/plain")
                .intent
        }

    }

    private fun shareSuccess()
    {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId)
        {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
