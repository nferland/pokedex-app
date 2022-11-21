package com.example.pokedex_app.data.repository

import com.example.pokedex_app.utils.constants.Resource
import com.example.pokedex_app.data.api.PokemonApi
import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.domain.repository.PokemonRepository

class PokemonRepositoryImpl (val api : PokemonApi) : PokemonRepository {
    override suspend fun loadPokemons(): List<PokemonDetails>? {
        when(val result = api.getPokemons()) {
            is Resource.Success -> {
                return result.data?.results
            }
            is Resource.Error -> {
                // Handle error
                throw Exception("Error to handle")
            }
        }
    }
}