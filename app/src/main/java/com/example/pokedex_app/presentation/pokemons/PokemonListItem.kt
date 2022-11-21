package com.example.pokedex_app.presentation.pokemons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.RoundPokemonImage
import com.example.pokedex_app.data.api.dto.pokemon.PokemonResult

@Composable
fun PokemonListItem(pokemon: PokemonResult, onClick: () -> Unit) {
    Row(modifier = Modifier
        .wrapContentHeight(align = Alignment.Top)
        .padding(all = 4.dp)
        .clickable(onClick= onClick)
    ) {
        Column(modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(all = 4.dp)
        ) {
            RoundPokemonImage(48, pokemon.imgUrl)
        }
        Column(modifier = Modifier
            .padding(start = 24.dp)
            .align(alignment = Alignment.CenterVertically)
        ) {
            Text(text = pokemon.name)
            Text(text = pokemon.id.toString())
        }

    }
}