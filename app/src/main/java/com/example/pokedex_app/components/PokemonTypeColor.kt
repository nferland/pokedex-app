package com.example.pokedex_app.components

import com.example.pokedex_app.ui.theme.*

fun getColorByName(pokeType: String?): androidx.compose.ui.graphics.Color {
    return when(pokeType) {
        "fire" -> fire
        "water" -> water
        "electric" -> electric
        "grass" -> grass
        "ice" -> ice
        "fighting" -> fighting
        "poison" -> poison
        "ground" -> ground
        "flying" -> flying
        "psychic" -> psychic
        "bug" -> bug
        "rock" -> rock
        "ghost" -> ghost
        "dragon" -> dragon
        "dark" -> dark
        "steel" -> steel
        "fairy" -> fairy
        else -> normal
    }
}

fun getBackgroundColorByName(pokeType: String?): androidx.compose.ui.graphics.Color {
    return when(pokeType) {
        "fire" -> fireBackground
        "water" -> waterBackground
        "electric" -> electricBackground
        "grass" -> grassBackground
        "ice" -> iceBackground
        "fighting" -> fightingBackground
        "poison" -> poisonBackground
        "ground" -> groundBackground
        "flying" -> flyingBackground
        "psychic" -> psychicBackground
        "bug" -> bugBackground
        "rock" -> rockBackground
        "ghost" -> ghostBackground
        "dragon" -> dragonBackground
        "dark" -> darkBackground
        "steel" -> steelBackground
        "fairy" -> fairyBackground
        else -> normalBackground
    }
}