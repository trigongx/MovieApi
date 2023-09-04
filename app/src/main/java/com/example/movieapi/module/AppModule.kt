package com.example.movieapi.module

import com.example.movieapi.model.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApi(): MovieApi {
        return Retrofit.Builder().baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(MovieApi::class.java)
    }

}