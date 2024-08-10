package com.jio.unitconverterapp.compose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jio.unitconverterapp.data.Conversion
import java.math.BigDecimal
import java.math.RoundingMode


@Composable
fun TopScreen(list: List<Conversion>) {

    val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }

    val inputText: MutableState<String> = remember {
        mutableStateOf("")
    }

    val typedValue = remember {
        mutableStateOf("0.0")
    }


    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            Log.i("MyTag", "User entered $input")
            typedValue.value = input
        }

        if (typedValue.value != "0.0") {
            val inputValue = typedValue.value.toDouble()
            val multipleBy = selectedConversion.value!!.multiplyBy
            val result = BigDecimal(inputValue * multipleBy)
            val roundingMode= RoundingMode.DOWN

            val roundOffValue = result.setScale(2, roundingMode)


            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equals to"
            val message2 = "$roundOffValue ${selectedConversion.value!!.convertTo}"

            ResultBlock(message1 = message1, message2 = message2)

        }

    }
}