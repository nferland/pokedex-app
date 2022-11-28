package com.example.pokedex_app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
class PokemonStats (val id: String, val name: String, val value: Int) : Parcelable {
    constructor(name: String, value: Int) : this(
        UUID.randomUUID().toString(), name, value
    )
}