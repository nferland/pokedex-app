package com.example.pokedex_app.presentation.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myapplication.components.PokemonImage
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.components.PokemonTypeList

@Composable
fun PokemonScreen(navController: NavHostController, pokemon: PokemonModel?) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonImage(size = 148, imageUrl = pokemon?.info?.imgUrl)
            PokemonTypeList(types = pokemon?.info?.types)
            PokemonInfos(pokemon)
            PokemonStats(pokemon)
        }
}