package com.jio.unitconverterapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier) {

    var displayText by remember {
        mutableStateOf("Select the conversion type")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero) // To assign the dropdown the same width as TextView
    }

    val icon = if (expanded) {
        Icons.Filled.ArrowDropDown
    } else {
        Icons.Filled.KeyboardArrowUp
    }


    OutlinedTextField(
        value = displayText,
        onValueChange = { displayText = it },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                textFieldSize = it.size.toSize()
            },
        label = { Text(text = "Conversion type")},
        trailingIcon = {
            Icon(icon, contentDescription = "icon",
            modifier.clickable { expanded = !expanded })
        }, readOnly = false
    )

}