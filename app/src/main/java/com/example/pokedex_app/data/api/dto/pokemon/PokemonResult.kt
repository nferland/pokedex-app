package com.example.pokedex_app.data.api.dto.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResult(
    val name: String,
    val url: String,
    val imgUrl: String,
    val id: Int
) : Parcelable {
    constructor(name: String, url: String) : this(name, url, getImgUrl(url), getPokemonIdFromUrl(url))

}
fun getPokemonIdFromUrl(url : String) : Int {
    return url.substringAfter("pokemon/").substringBefore('/').toInt()
}
fun getImgUrl(url: String) : String {
    val id = url.substringAfter("pokemon/").substringBefore('/').toInt()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}