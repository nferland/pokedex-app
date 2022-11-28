package com.example.pokedex_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.domain.models.PokemonModel
import com.example.myapplication.utils.constants.NavArgumentKeys
import com.example.myapplication.utils.constants.Routes
import com.example.pokedex_app.navigation.PokemonType
import com.example.pokedex_app.presentation.pokemon.PokemonScreen
import com.example.pokedex_app.presentation.pokemons.PokemonViewModel
import com.example.pokedex_app.presentation.pokemons.PokemonsScreen
import com.example.pokedex_app.ui.theme.PokedexappTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexappTheme { // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@RequiresApi(33)
@Composable
fun MainScreen(){
    val navController: NavHostController = rememberNavController()
    val pokemonViewModel = PokemonViewModel()

    NavHost(navController = navController, startDestination = Routes.PokemonList.route){
        composable(
            route = Routes.PokemonList.route,
            arguments = listOf(navArgument(NavArgumentKeys.Pokemon.key){
                type=PokemonType()
            })
        ){
            val onContactAdded = fun(){navController.currentBackStackEntry?.arguments?.clear()}
            PokemonsScreen(navHostController = navController, viewModel = pokemonViewModel)
        }
        composable(
            route = Routes.Pokemon.route,
        ){
            val pokemon = navController.previousBackStackEntry?.arguments?.getParcelable<PokemonModel>(NavArgumentKeys.Pokemon.key);
            PokemonScreen(navController, pokemon)
        }
    }
}