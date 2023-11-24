package com.example.superheroapp.modelo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.example.superheroapp.databinding.ItemheroesBinding
import com.example.superheroapp.modelo.modelos.Heroes

class heroeAdapter(val heroes: List<Heroes>?):RecyclerView.Adapter<heroeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemheroesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            return holder.bind(heroes!![position])
    }

    override fun getItemCount(): Int {
        return heroes!!.size
    }

    class ViewHolder(private val binding: ItemheroesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind ( heroes: Heroes){
            binding.apply {
                txtid.text = heroes.id.toString()
                txtnombre.text = heroes.nombre_heroe
                txtnivel.text = heroes.nivel.toString()

            }

        }
    }

}