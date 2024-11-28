package com.example.mtgcards.core.data.networking.responses.models

import com.google.gson.annotations.SerializedName

data class CardFace(
    @SerializedName("name") val name: String,
    @SerializedName("mana_cost") val manaCost: String,
    @SerializedName("oracle_text") val oracleText: String,
    @SerializedName("image_uris") val imageUris: ImageUris
)
