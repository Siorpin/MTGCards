package com.example.mtgcards.core.data.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  BuildApiResponse {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Ustaw poziom logowania
    }
    val client = OkHttpClient.Builder()
        .addInterceptor(logging) // Dodanie interceptora
        .build()

    val scryfallApi: ScryfallApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ScryfallApi::class.java)
    }
}