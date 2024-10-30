package com.example.mtgcards.core.data.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BuildCardObject {
    val scryfallApi: ScryfallApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ScryfallApi::class.java)
    }
}