package com.example.pokedex_app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonDetail (
    val name: String?,
    val pokemonId: Int?,
    val types: List<String>?,
    val stats: List<PokemonStats>?,
    val imgUrl: String?,
    val weight: Float?,
    val height: Float?) : Parcelable