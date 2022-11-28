package com.example.pokedex_app.presentation.pokemons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.PokemonImage
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.components.PokemonTypeList
import com.example.pokedex_app.components.getBackgroundColorByName

@Composable
fun PokemonListItem(pokemon: PokemonModel, onClick: () -> Unit) {
    Row(modifier = Modifier
        .wrapContentHeight(align = Alignment.Top)
        .padding(all = 4.dp)
        .clickable(onClick = onClick)
        .background(getBackgroundColorByName(pokemon.info?.types?.get(0)))
        .fillMaxWidth()
    ) {
        Row(){
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(all = 4.dp)) {
                PokemonImage(64, pokemon.info?.imgUrl)
            }
            Column(modifier = Modifier
                .padding(start = 24.dp)
                .align(alignment = Alignment.CenterVertically)) {
                Text(text = "${pokemon.info?.pokemonId} - ${pokemon.info?.name?.capitalize()}", color= Color.White)
                PokemonTypeList(pokemon.info?.types)
            }
        }
    }
}