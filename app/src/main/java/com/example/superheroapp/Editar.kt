package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroapp.databinding.ActivityEditarBinding
import com.example.superheroapp.modelo.adapter.heroeAdapter
import com.example.superheroapp.modelo.conexion.conexionApi
import com.example.superheroapp.modelo.modelos.Heroes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Editar : AppCompatActivity() {
    lateinit var binding: ActivityEditarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editarHeroes()
    }

    fun editarHeroes(){
//        conexionApi.buildHeroes.Editarheroes().enqueue(object: Callback<List<Heroes>>{
//            override fun onResponse(call: Call<List<Heroes>>, response: Response<List<Heroes>>) {
//
//            }
//
//            override fun onFailure(call: Call<List<Heroes>>, t: Throwable) {
//
//            }
//        })
    }
}