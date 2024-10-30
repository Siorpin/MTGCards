package com.example.mtgcards.core.data.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface ScryfallApi {
    @GET("cards/named")
    suspend fun getCardByName(@Query("fuzzy") name: String): ScryfallCardResponse
}