package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.data.api.dto.pokemon.Pokemons
import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitPokemonApi {
    @GET("/api/v2/pokemon/?limit=100000&offset=0")
    suspend fun getPokemons(): Response<Pokemons>
    @GET("/api/v2/pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: String): Response<PokemonDetails>
}