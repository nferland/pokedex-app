package com.example.pokedex_app.presentation.pokemons

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex_app.data.api.dto.pokemon.PokemonResult

@Composable
fun PokemonListComponent(pokemons: Map<String, PokemonResult>, navigateToPokemonScreen: (contact: PokemonResult) -> Unit){
    val itemOnClick = fun (pokemon: PokemonResult){
        navigateToPokemonScreen(pokemon)
    }

    val pokemonList = pokemons.values.toList();

    LazyColumn() {
        itemsIndexed(pokemonList){ index, pokemon ->
            PokemonListItem(pokemon = pokemon) { itemOnClick(pokemon) }
            if (index < pokemonList.lastIndex){
                Divider(color = Color.LightGray, thickness = 1.dp, startIndent = 82.dp)
            }
        }
    }
}