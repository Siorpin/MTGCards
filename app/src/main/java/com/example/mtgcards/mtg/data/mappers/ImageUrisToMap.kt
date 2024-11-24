package com.example.mtgcards.mtg.data.mappers

import com.example.mtgcards.core.data.networking.responses.models.ImageUris



fun ImageUris.toMap(): Map<String, String?> {
    return mapOf(
        "art_crop" to artCrop,
        "image" to image
    )
}