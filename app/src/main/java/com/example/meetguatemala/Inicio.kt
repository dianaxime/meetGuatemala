package com.example.meetguatemala


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.meetguatemala.databinding.InicioBinding


class Inicio : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.inicio, container, false)
        val binding = DataBindingUtil.inflate<InicioBinding>(inflater, R.layout.inicio, container, false)
        binding.placeuno.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_inicio_to_lugar1)
        }
        binding.placedos.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_inicio_to_lugar2)
        }
        binding.placetres.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_inicio_to_lugar3)
        }
        binding.onlyname.visibility=View.INVISIBLE
        binding.mostrarocultar.setOnClickListener {
            if (binding.onlyname.visibility==View.INVISIBLE){
                binding.onlyname.text=binding.nameedit.text.toString()
                binding.onlyname.visibility=View.VISIBLE
                binding.nameedit.visibility=View.INVISIBLE
                binding.namelabel.visibility=View.INVISIBLE
            }
            else{
                binding.nameedit.visibility=View.VISIBLE
                binding.namelabel.visibility=View.VISIBLE
                binding.onlyname.visibility=View.INVISIBLE
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
