package com.example.mtgcards.mtg.presentation.cardScreen.models

import com.example.mtgcards.R

fun getManaImages(mana: String): Int {
    return when(mana) {
        "0" -> R.drawable._0m
        "1" -> R.drawable._1m
        "2" -> R.drawable._2m
        "3" -> R.drawable._3m
        "4" -> R.drawable._4m
        "5" -> R.drawable._5m
        "6" -> R.drawable._6m
        "7" -> R.drawable._7m
        "8" -> R.drawable._8m
        "9" -> R.drawable._9m
        "10" -> R.drawable._10m
        "11" -> R.drawable._11m
        "12" -> R.drawable._12m
        "13" -> R.drawable._13m
        "14" -> R.drawable._14m
        "15" -> R.drawable._15m
        "16" -> R.drawable._16m
        "17" -> R.drawable._17m
        "18" -> R.drawable._18m
        "19" -> R.drawable._19m
        "20" -> R.drawable._20m
        "B" -> R.drawable.blackm
        "U" -> R.drawable.bluem
        "R" -> R.drawable.redm
        "W" -> R.drawable.whitem
        "G" -> R.drawable.greenm

        else -> R.drawable.voidm
    }
}