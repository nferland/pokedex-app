package com.example.pokedex_app.presentation.pokemons

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.myapplication.domain.models.PokemonModel
import com.example.myapplication.utils.constants.NavArgumentKeys
import com.example.myapplication.utils.constants.Routes

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun PokemonsScreen(navHostController: NavHostController,
                   viewModel: PokemonViewModel
) {
    val navigateToPokemonScreen = fun(pokemon: PokemonModel) {
        navHostController.currentBackStackEntry?.arguments?.putParcelable(
            NavArgumentKeys.Pokemon.key,
            pokemon
        )
        navHostController.navigate(Routes.Pokemon.route)
    }

    val pokemons = remember {
        viewModel.pokemons
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Pokedex", color= Color.White)})
    },
         content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Row() {

                }
                PokemonListComponent(pokemons = pokemons, navigateToPokemonScreen)
            }
        })
}