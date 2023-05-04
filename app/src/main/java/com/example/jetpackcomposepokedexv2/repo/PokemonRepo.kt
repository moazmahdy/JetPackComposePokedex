package com.example.jetpackcomposepokedexv2.repo

import com.example.jetpackcomposepokedexv2.data.remot.PokeApi
import com.example.jetpackcomposepokedexv2.data.remot.responses.Pokemon
import com.example.jetpackcomposepokedexv2.data.remot.responses.PokemonList
import com.example.jetpackcomposepokedexv2.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepo @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (ex: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(name)
        } catch (ex: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}