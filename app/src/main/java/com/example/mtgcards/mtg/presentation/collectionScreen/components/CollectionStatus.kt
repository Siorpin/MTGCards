//package com.example.mtgcards.mtg.presentation.collectionScreen.components
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.mtgcards.mtg.domain.Card
//
//@Composable
//fun CollectionStatus(
//    cardList: List<Card>,
//    modifier: Modifier = Modifier
//) {
//    val cardsAmount = cardList.size
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier
//            .size(75.dp)
//    ) {
//        CollectionCircle(
//            cardList = cardList,
//            size = 70.dp,
//            borderWith = 3.dp
//        )
//        Text(cardsAmount.toString())
//    }
//}