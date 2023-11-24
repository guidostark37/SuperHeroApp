package com.example.superheroapp.modelo.interfaces

import com.example.superheroapp.modelo.modelos.Heroes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServicioApi {

    @GET("heroes")
    fun Cargarheroes():Call<List<Heroes>>

    @GET("api/heroes/{id}")
    fun CargarheroesId(@Path("id")id:String):Call<Heroes>

    @POST("heroes")
    fun Guardarheroes(
        @Body heroes: Heroes
    ):Call<Heroes>

    @DELETE("api/heroes/{id}")
    fun Borrarheroes(
        @Path("id")id:String
    ):Call<Heroes>

    @PUT("api/heroes/{id}")
    fun Editarheroes(
        @Path("id")id:String,
        @Body heroes: Heroes

    ):Call<Heroes>
}