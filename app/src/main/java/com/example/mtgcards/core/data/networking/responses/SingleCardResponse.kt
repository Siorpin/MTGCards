package com.example.mtgcards.core.data.networking.responses

import com.example.mtgcards.core.data.networking.responses.models.ImageUris
import com.google.gson.annotations.SerializedName

data class SingleCardResponse (
    @SerializedName("name") val name: String,
    @SerializedName("mana_cost") val manaCost: String,
    @SerializedName("oracle_text") val oracleText: String,
    @SerializedName("set_name") val setName: String,
    @SerializedName("image_uris") val imageUris: ImageUris
)