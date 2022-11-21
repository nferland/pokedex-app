package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex_app.R

@Composable
fun RoundPokemonImage(size: Int, imageUrl: String?) {
    Column() {
        if (imageUrl == null){
            Image(
                painter = painterResource(id = R.drawable.missing_no),
                modifier = Modifier.size(size.dp).clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color.Gray, CircleShape),
                contentDescription = "Account",
                colorFilter = ColorFilter.tint(color = Color.LightGray),
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
            )
        }else{
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                modifier = Modifier.size(size.dp).clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop,
                contentDescription = "Account",
            )
        }
    }
}