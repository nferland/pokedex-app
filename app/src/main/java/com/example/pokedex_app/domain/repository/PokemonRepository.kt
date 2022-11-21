package com.example.pokedex_app.domain.repository

import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails

interface PokemonRepository {
    suspend fun loadPokemons(): List<PokemonDetails>?
}