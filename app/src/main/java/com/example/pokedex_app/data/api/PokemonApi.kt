package com.example.pokedex_app.data.api

import com.example.myapplication.utils.constants.Resource
import com.example.pokedex_app.data.api.dto.results.ResultsDTO

interface PokemonApi {
    suspend fun getPokemon(): Resource<ResultsDTO?>
}