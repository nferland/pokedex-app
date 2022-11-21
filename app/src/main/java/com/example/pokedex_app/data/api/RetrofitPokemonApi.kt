package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitPokemonApi {
    @GET("/api/")
    suspend fun getPokemons(@Query("pokemon") limit: Int = 100000, offset: Int = 0): Response<ResultsDTO>
    @GET("/api/")
    suspend fun getPokemon(@Query("pokemon") id: Int): Response<ResultsDTO>
}