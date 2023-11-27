package com.example.superheroapp.modelo.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.example.superheroapp.databinding.ItemheroesBinding
import com.example.superheroapp.modelo.conexion.conexionApi
import com.example.superheroapp.modelo.modelos.Heroes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class heroeAdapter(val heroes: MutableList<Heroes>?, val editar : (heroe: Heroes) -> Unit):RecyclerView.Adapter<heroeAdapter.heroeHolder>() {
    override fun getItemCount(): Int {
        return  heroes!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): heroeHolder {
        val binding = ItemheroesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return heroeHolder(binding)
    }

    override fun onBindViewHolder(holder: heroeHolder, position: Int) {
        var heroe = heroes?.get(position)
        holder.binding.apply {

            txtid.text = heroe!!.id.toString()
            txtnombre.text = heroe.nombre_heroe
            txtnivel.text = heroe.nivel.toString()

            btnborrar.setOnClickListener {
                AlertDialog.Builder(holder.binding.root.context)
                    .setMessage("Desea eliminar el heroe ${heroe.nombre_heroe}?")
                    .setPositiveButton("si"){view,b->
                        conexionApi.buildHeroes.Borrarheroes(heroe.id.toString())
                        heroes!!.remove(heroe)
                        this@heroeAdapter.notifyItemRemoved(position)

                    }
                    .setNegativeButton("No") { _, _ ->
                        Toast.makeText(holder.binding.root.context, "se cancelo", Toast.LENGTH_SHORT)
                            .show()
                    }.create().show()

            }

            btnedit.setOnClickListener {
                editar.invoke(heroe)

            }

        }
    }

    class heroeHolder( val binding: ItemheroesBinding):RecyclerView.ViewHolder(binding.root)
}