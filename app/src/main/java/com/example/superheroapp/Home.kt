package com.example.superheroapp

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.superheroapp.databinding.ActivityHomeBinding
import com.example.superheroapp.modelo.adapter.heroeAdapter
import com.example.superheroapp.modelo.conexion.Apiconexion
import com.example.superheroapp.modelo.modelos.Heroes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CargarHeroes()
    }

    fun CargarHeroes(){
            Apiconexion.buildHeroes.Cargarheroes().enqueue(object : Callback<List<Heroes>>{

                override fun onResponse(
                    call: Call<List<Heroes>>,
                    response: Response<List<Heroes>>
                ) {
                   var body = response.body()
                        binding.recHeroes.adapter = heroeAdapter(body)
                }

                override fun onFailure(call: Call<List<Heroes>>, t: Throwable) {
                    Toast.makeText(this@Home, t.message.toString(), Toast.LENGTH_SHORT).show()
                }
            })





    }



}