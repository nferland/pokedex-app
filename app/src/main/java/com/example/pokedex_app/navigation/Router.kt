package com.example.pokedex_app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.myapplication.utils.constants.NavArgumentKeys
import com.example.myapplication.utils.constants.Routes
import com.example.pokedex_app.data.api.RetrofitPokemonApiImpl
import com.example.pokedex_app.data.api.dto.pokemon.PokemonResult
import com.example.pokedex_app.data.repository.PokemonRepositoryImpl
import com.example.pokedex_app.presentation.pokemon.PokemonScreen
import com.example.pokedex_app.presentation.pokemons.PokemonViewModel
import com.example.pokedex_app.presentation.pokemons.PokemonsScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Router(navController: NavHostController){
    val pokemonsViewModel = PokemonViewModel(PokemonRepositoryImpl(RetrofitPokemonApiImpl()));
    NavHost(
        navController = navController,
        startDestination = Routes.PokemonList.route
    ) {
        composable(
            route = Routes.PokemonList.route,
            arguments = listOf(
                navArgument(NavArgumentKeys.Pokemon.key) {
                    type = PokemonType()
                }
            )
        ) {
            PokemonsScreen(
                navController,
                pokemonsViewModel
            ) { navController.currentBackStackEntry?.arguments?.clear() }
        }
        composable(
            route = Routes.Pokemon.route,
            content = {
                val pokemon = navController.previousBackStackEntry?.arguments?.getParcelable<PokemonResult>(
                    NavArgumentKeys.Pokemon.key)
                PokemonScreen(navController, pokemon?.id)
            }
        )
    }
}