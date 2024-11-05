package com.example.mtgcards.core.data.networking.responses.models

import com.google.gson.annotations.SerializedName

data class ImageUris(
    @SerializedName("border_crop") val image: String?
)
