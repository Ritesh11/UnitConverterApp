package com.jio.unitconverterapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultBlock(modifier: Modifier = Modifier, message1: String, message2: String) {

    Card(
        modifier = modifier.padding(0.dp,20.dp,0.dp,0.dp)
    ) {
        Column(modifier = modifier.padding(10.dp)) {

            Text(
                text = message1,
                fontSize = 20.sp
            )

            Text(
                text = message2,
                fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )

        }

    }

}