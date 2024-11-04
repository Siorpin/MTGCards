package com.example.mtgcards.core.data.networking

import com.google.gson.annotations.SerializedName

data class ScryfallCardResponse(
    @SerializedName("data") val data: List<CardResponseObject>,
    @SerializedName("total_cards") val totalCards: Int
)

data class CardResponseObject(
    @SerializedName("name") val name: String,
    @SerializedName("image_uris") val imageUri: ImageUris
)

data class ImageUris(
    @SerializedName("border_crop") val image: String?
)
