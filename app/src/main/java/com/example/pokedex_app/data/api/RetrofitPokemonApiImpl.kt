package com.example.pokedex_app.data.api

import com.example.myapplication.utils.constants.Resource
import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPokemonApiImpl: PokemonApi {
     private val client: RetrofitPokemonApiImpl = Retrofit.Builder().baseUrl("https://pokeapi.co")
         .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitPokemonApiImpl::class.java);

    override suspend fun getPokemon(): Resource<ResultsDTO?> {
        val response = client.getPokemon()
        return response.body()
    }
}