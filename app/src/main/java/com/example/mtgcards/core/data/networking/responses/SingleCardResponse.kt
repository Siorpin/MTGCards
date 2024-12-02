package com.example.mtgcards.core.data.networking.responses

import com.example.mtgcards.core.data.networking.responses.models.CardFace
import com.example.mtgcards.core.data.networking.responses.models.ImageUris
import com.google.gson.annotations.SerializedName

class SingleCardResponse (
    @SerializedName("card_faces") val cardFaces: List<CardFace>? = null,
    @SerializedName("name") val name: String,
    @SerializedName("mana_cost") val manaCost: String,
    @SerializedName("oracle_text") val oracleText: String,
    @SerializedName("image_uris") val imageUris: ImageUris,
    @SerializedName("set_name") val setName: String,
    @SerializedName("color_identity") val colorIdentity: List<String>,
    @SerializedName("legalities") val legalities: Map<String, String>
) {
    fun checkIfHasFaces(): MutableList<SingleCardResponse> {
        val facesList = mutableListOf<SingleCardResponse>()

        if (cardFaces == null) facesList.add(SingleCardResponse(
            null,
            name,
            manaCost,
            oracleText,
            imageUris,
            setName,
            colorIdentity,
            legalities
        ))
        else {
            cardFaces.forEach{ face ->
                facesList.add(SingleCardResponse(
                    cardFaces,
                    face.name,
                    face.manaCost,
                    face.oracleText,
                    face.imageUris,
                    setName,
                    colorIdentity,
                    legalities
                ))
            }
        }

        return facesList
    }
}