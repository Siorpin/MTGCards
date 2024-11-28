package com.example.mtgcards.core.data.networking.responses

import com.example.mtgcards.core.data.networking.responses.models.CardFace
import com.example.mtgcards.core.data.networking.responses.models.ImageUris
import com.google.gson.annotations.SerializedName

data class SearchCardResponse(
    @SerializedName("data") val data: List<CardResponseObject>,
    @SerializedName("total_cards") val totalCards: Int
)

class CardResponseObject(
    @SerializedName("card_faces") val cardFaces: List<CardFace>? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("image_uris") val imageUri: ImageUris? = null
) {
    fun checkIfSearchHasFaces(): CardResponseObject {
        return if (cardFaces == null) CardResponseObject(null, name, imageUri)
        else CardResponseObject(null, cardFaces[0].name, cardFaces[0].imageUris)
    }
}