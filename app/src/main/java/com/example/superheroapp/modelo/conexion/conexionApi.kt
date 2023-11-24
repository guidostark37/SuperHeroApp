package com.example.superheroapp.modelo.conexion

import com.example.superheroapp.modelo.interfaces.ServicioApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConexion{

    private  var builder =Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        var buildHeroes = builder.create(ServicioApi::class.java)
}