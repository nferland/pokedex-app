package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.data.api.dto.pokemon.Pokemons
import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import com.example.pokedex_app.utils.constants.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPokemonApiImpl: PokemonApi {
     private val client: RetrofitPokemonApi = Retrofit.Builder().baseUrl("https://pokeapi.co")
         .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitPokemonApi::class.java);

    override suspend fun getPokemons(): Pokemons? {
        val response = client.getPokemons()
        return response.body()
    }

    override suspend fun getPokemon(pokemonId: String): PokemonDetails? {
        val response = client.getPokemon(pokemonId)
        return response.body()
    }
}