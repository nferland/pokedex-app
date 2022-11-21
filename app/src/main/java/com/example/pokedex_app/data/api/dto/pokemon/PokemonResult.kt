package com.example.pokedex_app.data.api.dto.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResult(
    val name: String,
    val url: String,
    val id: Int,
    val imgUrl: String
) : Parcelable {
    constructor(name: String, url: String) : this(name, url, getPokemonIdFromUrl(url), getImgUrl(url))

}
fun getPokemonIdFromUrl(url : String) : Int {
    return url.substringAfter("pokemon/").substringBefore('/').toInt()
}
fun getImgUrl(url: String) : String {
    val id = url.substringAfter("pokemon/").substringBefore('/').toInt()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}