package com.example.myapplication.domain.models

import android.os.Parcelable
import com.example.pokedex_app.data.api.dto.pokemon.*
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Pokemon(
//    val abilities: List<Ability>,
    val base_experience: Int,
//    val forms: List<Form>,
//    val game_indices: List<GameIndice>,
    val height: Int,
//    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
//    val moves: List<Move>,
    val name: String,
    val order: Int,
//    val past_types: List<Any>,
//    val species: Species,
//    val sprites: Sprites,
//    val stats: List<Stat>,
//    val types: List<Type>,
    val weight: Int
    ): Parcelable{
//    constructor(firstname: String, phoneNumber: String) :
//            this(UUID.randomUUID().toString(), firstname, phoneNumber, null)
//    constructor(id: String, firstname: String, phoneNumber: String) :
//            this(id, firstname, phoneNumber, null)
}