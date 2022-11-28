package com.example.myapplication.domain.models

import android.os.Parcelable
import com.example.pokedex_app.data.api.dto.pokemon.*
import com.example.pokedex_app.domain.models.PokemonDetail
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class PokemonModel(
    val id: String,
    val info: PokemonDetail?
    ): Parcelable {
    constructor(info: PokemonDetail?): this(
        UUID.randomUUID().toString(), info
    )
}