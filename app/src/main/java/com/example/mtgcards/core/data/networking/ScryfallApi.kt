package com.example.mtgcards.core.data.networking

import com.example.mtgcards.core.data.networking.responses.SearchCardResponse
import com.example.mtgcards.core.data.networking.responses.SingleCardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ScryfallApi {
    @GET("cards/search")
    suspend fun searchCards(@Query("q") name: String): SearchCardResponse

    @GET("cards/named")
    suspend fun getSingleCard(@Query("fuzzy") name: String): SingleCardResponse
}