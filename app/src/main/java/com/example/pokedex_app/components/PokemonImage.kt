package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex_app.R

@Composable
fun PokemonImage(size: Int, imageUrl: String?) {
    Column() {
        if (imageUrl == null){
            Image(
                painter = painterResource(id = R.drawable.missing_no),
                modifier = Modifier.size(size.dp),
                contentDescription = "Account",
                colorFilter = ColorFilter.tint(color = Color.LightGray),
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
            )
        }else{
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                modifier = Modifier.size(size.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Pokemon",
            )
        }
    }
}