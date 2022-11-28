package com.example.pokedex_app.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.myapplication.domain.models.PokemonModel
import com.google.gson.Gson

class PokemonType : NavType<PokemonModel>(isNullableAllowed = true){
    override fun get(bundle: Bundle, key: String): PokemonModel? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): PokemonModel {
        return Gson().fromJson(value, PokemonModel::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: PokemonModel) {
        bundle.putParcelable(key, value)
    }

    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}