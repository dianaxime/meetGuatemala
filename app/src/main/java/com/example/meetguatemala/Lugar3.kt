package com.example.meetguatemala


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.meetguatemala.databinding.MeetatitlanBinding
import com.example.meetguatemala.models.Comentario

class Lugar3 : Fragment() {
    var comentario: Comentario = Comentario()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.meetatitlan, container, false)
        val binding = DataBindingUtil.inflate<MeetatitlanBinding>(inflater, R.layout.meetatitlan, container, false)
        binding.coment.setOnClickListener {
            comentario.setcomentario(binding.comentario.text.toString())
            Navigation.findNavController(it).navigate(R.id.action_lugar3_to_sharecomment)
        }
        return binding.root
    }


}
