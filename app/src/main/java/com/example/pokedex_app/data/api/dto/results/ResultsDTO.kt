package com.example.pokedex_app.data.api.dto.results

import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails

data class ResultsDTO(
    val info: Info,
    val results: List<PokemonDetails>
)