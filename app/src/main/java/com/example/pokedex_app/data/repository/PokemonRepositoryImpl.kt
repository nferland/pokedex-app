package com.example.pokedex_app.data.repository

import com.example.myapplication.utils.constants.Resource
import com.example.pokedex_app.data.api.PokemonApi
import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.domain.repository.PokemonRepository

class PokemonRepositoryImpl (val api : PokemonApi) : PokemonRepository {
    override suspend fun loadContacts(): List<PokemonDetails>? {
        when(val result = api.getPokemon()) {
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