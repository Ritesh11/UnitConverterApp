package com.jio.unitconverterapp

import androidx.compose.runtime.Composable


@Composable
fun TopScreen(list: List<Conversion>) {
    ConversionMenu(list = list)
}