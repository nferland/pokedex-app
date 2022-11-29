package com.example.pokedex_app.presentation.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.ui.theme.*

@Composable
fun PokemonStats(pokemon: PokemonModel?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp)
        .border(1.dp, Color.DarkGray)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Statistics") 
            }
        }
        pokemon?.info?.stats?.forEach{ stat ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)) {
                Column(modifier = Modifier
                    .width(120.dp)
                    .padding(0.dp, 0.dp, 16.dp, 0.dp)) {
                    when (stat.name) {
                        "special-attack" -> {
                            Text(text = "Sp. Attack : ${stat.value}")
                        }
                        "special-defense" -> {
                            Text(text = "Sp. Defense : ${stat.value}")
                        }
                        else -> {
                            Text(text = "${stat.name.capitalize()} : ${stat.value}")
                        }
                    }
                }
                Column(modifier = Modifier
                    .width(stat.value.dp)
                    .height(16.dp)
                    .background(getStatColor(stat.value))) {

                }
            }
        }
    }
}

fun getStatColor(value: Int): Color {
    val percentage  = (value.toFloat() * 100) / 255
    return when(percentage.toInt()) {
        in 0..25 -> low_stat
        in 26..50 -> medium_stat
        in 51..75 -> medium2_stat
        in 76..85 -> high_stat
        in 86..95 -> high2_stat
        else -> { high3_stat}
    }
}