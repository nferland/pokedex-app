package com.example.pokedex_app.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.myapplication.domain.models.Pokemon
import com.google.gson.Gson

class PokemonType : NavType<Pokemon>(isNullableAllowed = true){
    override fun get(bundle: Bundle, key: String): Pokemon? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): Pokemon {
        return Gson().fromJson(value, Pokemon::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Pokemon) {
        bundle.putParcelable(key, value)
    }

    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}