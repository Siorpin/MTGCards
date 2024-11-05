package com.example.mtgcards.core.data.networking.responses

import com.example.mtgcards.core.data.networking.responses.models.ImageUris
import com.google.gson.annotations.SerializedName

data class SearchCardResponse(
    @SerializedName("data") val data: List<CardResponseObject>,
    @SerializedName("total_cards") val totalCards: Int
)

data class CardResponseObject(
    @SerializedName("name") val name: String,
    @SerializedName("image_uris") val imageUri: ImageUris
)