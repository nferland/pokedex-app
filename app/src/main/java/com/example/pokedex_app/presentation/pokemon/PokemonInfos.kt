package com.example.pokedex_app.presentation.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.components.getBackgroundColorByName

@Composable
fun PokemonInfos(pokemon: PokemonModel?) {
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(32.dp)
        .background(getBackgroundColorByName(pokemon?.info?.types?.get(0)))
        .border(1.dp, Color.DarkGray)
    ) {
        Column(modifier= Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier.padding(16.dp)) {
                Text(text = "${pokemon?.info?.name?.capitalize()}",
                    color = Color.White,
                    fontSize = 32.sp
                )
            }
            Row() {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Row {
                        Text(text = "Height", color = Color.White)
                    }
                    Row {
                        Text(text = "${pokemon?.info?.height} m", color = Color.Black)
                    }
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text(text = "Weight", color = Color.White)
                    }
                    Row {
                        Text(text = "${pokemon?.info?.weight} kg", color = Color.Black)
                    }
                }
            }
        }

    }

}