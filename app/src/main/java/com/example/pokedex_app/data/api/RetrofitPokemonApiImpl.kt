package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import com.example.pokedex_app.utils.constants.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPokemonApiImpl: PokemonApi {
     private val client: RetrofitPokemonApi = Retrofit.Builder().baseUrl("https://pokeapi.co")
         .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitPokemonApi::class.java);

    override suspend fun getPokemons(): Resource<ResultsDTO?> {
        val response = client.getPokemons()
        return if(response.isSuccessful){
            Resource.Success(response.body())
        }else {
            Resource.Error(Exception(response.errorBody().toString()))
        }
    }

    override suspend fun getPokemon(pokemonId: Int): ResultsDTO? {
        val response = client.getPokemon(pokemonId)
        return response.body()
    }
}