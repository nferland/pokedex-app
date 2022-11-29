package com.example.pokedex_app.presentation.pokemons

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.example.myapplication.domain.models.PokemonModel
import com.example.myapplication.utils.constants.NavArgumentKeys
import com.example.myapplication.utils.constants.Routes

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun PokemonsScreen(navHostController: NavHostController,
                   viewModel: PokemonViewModel
) {
    var pokemonSearch by remember { mutableStateOf(TextFieldValue("")) }

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
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                        androidx.compose.material.OutlinedTextField(value = pokemonSearch,
                            onValueChange = { pokemonSearch = it },
                            label = { Text("Pokemon Name") })
                    }
                }
                PokemonListComponent(pokemons = pokemons, navigateToPokemonScreen, pokemonSearch)
            }
        })
}