package com.example.jetpackcomposepokedexv2.pokemondetails

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposepokedexv2.data.remot.responses.Pokemon
import com.example.jetpackcomposepokedexv2.repo.PokemonRepo
import com.example.jetpackcomposepokedexv2.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repo: PokemonRepo
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repo.getPokemonInfo(pokemonName);
    }
}