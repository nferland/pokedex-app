package com.example.pokedex_app.data.api.dto.results

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)