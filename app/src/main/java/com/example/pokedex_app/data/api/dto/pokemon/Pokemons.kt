package com.example.pokedex_app.data.api.dto.pokemon

data class Pokemons(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)