package com.example.myapplication.utils.constants

sealed class Routes(val route: String) {
    object PokemonList : Routes("pokemon_list")
    object Pokemon : Routes("pokemon")
}