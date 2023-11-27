package com.example.superheroapp.modelo.conexion

import com.example.superheroapp.modelo.interfaces.ServicioApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object conexionApi {
    var builder = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var buildHeroes = builder.create(ServicioApi::class.java)
}