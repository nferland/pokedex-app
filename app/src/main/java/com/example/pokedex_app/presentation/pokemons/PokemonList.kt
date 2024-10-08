package com.example.pokedex_app.presentation.pokemons

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.models.PokemonModel

@Composable
fun PokemonListComponent(
    pokemons: Map<String, PokemonModel>,
    navigateToPokemonScreen: (contact: PokemonModel) -> Unit,
    searchValue : TextFieldValue
){
    val itemOnClick = fun (pokemon: PokemonModel){
        navigateToPokemonScreen(pokemon)
    }

    val pokemonUnsortedList = pokemons.values.toList()
    val pokemonList = pokemonUnsortedList.sortedBy { it.info?.pokemonId }

    LazyColumn() {
        itemsIndexed(pokemonList){ index, pokemon ->
            if(searchValue.text == "" || pokemon.info?.name?.contains(searchValue.text) == true) {
                PokemonListItem(pokemon = pokemon) { itemOnClick(pokemon) }
            }
        }
    }
}