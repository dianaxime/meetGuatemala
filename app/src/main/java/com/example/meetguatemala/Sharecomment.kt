package com.example.meetguatemala


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.meetguatemala.databinding.FragmentSharecommentBinding
import com.example.meetguatemala.models.Comentario


class Sharecomment : Fragment() {
    var comentario: Comentario = Comentario()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sharecomment, container, false)
        val binding: FragmentSharecommentBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sharecomment, container, false)
        binding.micomentario.text=comentario.getcomentario()
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun getShareIntent() : Intent {
        return ShareCompat.IntentBuilder.from(activity)
            .setText(comentario.getcomentario())
            .setType("text/plain")
            .intent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}
