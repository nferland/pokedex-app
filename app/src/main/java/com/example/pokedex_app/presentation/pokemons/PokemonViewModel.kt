package com.example.pokedex_app.presentation.pokemons

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.PokemonModel
import com.example.pokedex_app.data.api.RetrofitPokemonApiImpl
import com.example.pokedex_app.data.api.dto.pokemon.PokemonDetails
import com.example.pokedex_app.domain.models.PokemonDetail
import com.example.pokedex_app.domain.models.PokemonStats
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class PokemonViewModel(): ViewModel() {

    private var _pokemonList: MutableMap<String, PokemonModel> = mutableStateMapOf()

    val pokemons: Map<String, PokemonModel>
        get() = _pokemonList

    fun putPokemon(pokemon: PokemonModel){
        _pokemonList[pokemon.id] = pokemon
    }

    init {
        val retrofitClass = RetrofitPokemonApiImpl()
        viewModelScope.launch {
            val results = retrofitClass.getPokemons()
            val deferredList = results?.results?.map { pokemonData ->
                async {
                    val id =  pokemonData.url.substringAfter("pokemon/").substringBefore("/")
                    val pokemon = retrofitClass.getPokemon(id)
                    val pokemonModel = createPokeModel(pokemon)
                    putPokemon(pokemonModel)
                }
            }
            deferredList?.awaitAll()
            println("Finished!")
        }
    }

    private fun createPokeModel(pokemon: PokemonDetails?): PokemonModel {
        val stats = pokemon?.stats?.map { stat ->
            PokemonStats(stat.stat.name, stat.base_stat)
        }
        val types = pokemon?.types?.map { type ->
            type.type.name
        }
        val imgUrl = pokemon?.sprites?.other?.official_artwork?.front_default
        val pokemonDetail = PokemonDetail(
            pokemonId = pokemon?.id,
            name = pokemon?.name,
            height = pokemon?.height?.div( 10),
            weight = pokemon?.weight?.div( 10),
            types = types,
            imgUrl = imgUrl,
            stats = stats
        )
        return PokemonModel(pokemonDetail)
    }


}