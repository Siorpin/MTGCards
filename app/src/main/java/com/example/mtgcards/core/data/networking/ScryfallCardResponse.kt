package com.example.mtgcards.core.data.networking

import com.google.gson.annotations.SerializedName

data class ScryfallCardResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image_uris") val imageUris: ImageUris
)

data class ImageUris(
    @SerializedName("normal") val normalImage: String
)
