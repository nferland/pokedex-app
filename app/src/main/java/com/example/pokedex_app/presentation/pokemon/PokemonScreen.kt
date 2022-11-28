package com.example.pokedex_app.presentation.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.example.pokedex_app.components.PokemonImage
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.components.ActionButton
import com.example.pokedex_app.components.PokemonTypeList

@Composable
fun PokemonScreen(navController: NavHostController, pokemon: PokemonModel?) {

    val goBackToList = fun(){
        navController.currentBackStackEntry?.arguments?.clear()
        navController.popBackStack();
    }

    Row {
        ActionButton(text = "x", action = goBackToList)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        PokemonImage(size = 148, imageUrl = pokemon?.info?.imgUrl)
        PokemonTypeList(types = pokemon?.info?.types)
        PokemonInfos(pokemon)
        PokemonStats(pokemon)
    }
}