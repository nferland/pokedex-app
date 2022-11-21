package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import com.example.pokedex_app.utils.constants.Resource

interface PokemonApi {
    suspend fun getPokemons(): Resource<ResultsDTO?>
    suspend fun getPokemon(pokemonId : Int) : ResultsDTO?
}