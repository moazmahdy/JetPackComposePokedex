package com.example.jetpackcomposepokedexv2.di

import com.example.jetpackcomposepokedexv2.data.remot.PokeApi
import com.example.jetpackcomposepokedexv2.repo.PokemonRepo
import com.example.jetpackcomposepokedexv2.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepo(
        api: PokeApi
    ) = PokemonRepo(api)
    
    @Singleton
    @Provides
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}