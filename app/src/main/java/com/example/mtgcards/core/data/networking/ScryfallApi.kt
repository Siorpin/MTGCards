package com.example.mtgcards.core.data.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface ScryfallApi {
    @GET("cards/search")
    suspend fun getCardByName(@Query("q") name: String): ScryfallCardResponse
}