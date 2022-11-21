package com.example.pokedex_app.presentation.pokemons

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myapplication.utils.constants.NavArgumentKeys
import com.example.myapplication.utils.constants.Routes
import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.data.api.dto.pokemon.PokemonResult

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun PokemonsScreen(navHostController: NavHostController,
                   viewModel: PokemonViewModel
) {
    val navigateToContactScreen = fun(pokemon: PokemonResult) {
        navHostController.currentBackStackEntry?.arguments?.putParcelable(
            NavArgumentKeys.Pokemon.key,
            pokemon
        )
        navHostController.navigate(Routes.Pokemon.route)
    }

    val contacts = remember {
        viewModel.pokemons
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Contacts")})
    },
         content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
//                PokemonListComponent(contacts = contacts, navigateToContactScreen)
            }
        })
}