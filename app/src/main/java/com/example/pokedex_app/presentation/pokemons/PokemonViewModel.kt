package com.example.pokedex_app.presentation.pokemons

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.domain.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {

    private var _pokemonList: MutableMap<Int, PokemonDetails> = mutableStateMapOf()

    val pokemons: Map<Int, PokemonDetails>
        get() = _pokemonList

    fun putPokemon(pokemon: PokemonDetails){
        _pokemonList[pokemon.id] = pokemon
    }

    init {
        viewModelScope.launch {
            val pokemons = pokemonRepository.loadPokemons()
            pokemons?.forEach {
                    pokemon: PokemonDetails ->  putPokemon(pokemon)
            }
        }
    }

}