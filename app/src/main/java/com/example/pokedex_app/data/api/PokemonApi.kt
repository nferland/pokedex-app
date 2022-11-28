package com.example.pokedex_app.data.api

import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.data.api.dto.pokemon.Pokemons
import com.example.pokedex_app.data.api.dto.results.ResultsDTO
import com.example.pokedex_app.utils.constants.Resource

interface PokemonApi {
    suspend fun getPokemons(): Pokemons?
    suspend fun getPokemon(pokemonId : String) : PokemonDetails?
}