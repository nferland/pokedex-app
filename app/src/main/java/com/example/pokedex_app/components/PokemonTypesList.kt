package com.example.pokedex_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokemonTypeList(types: List<String>?) {
    Row{
        types?.forEach {type ->
            Column(modifier = Modifier
                .padding(2.dp)
                .background(getColorByName(type), RoundedCornerShape(10.dp))
                .border(1.dp, Color.DarkGray, RoundedCornerShape(10.dp))) {
                Text(text = type.capitalize(), modifier = Modifier.padding(4.dp, 2.dp), color = Color.White)
            }
        }
    }
}

