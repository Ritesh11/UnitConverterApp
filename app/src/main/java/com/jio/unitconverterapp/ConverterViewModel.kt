package com.jio.unitconverterapp

import androidx.lifecycle.ViewModel
import com.jio.unitconverterapp.data.Conversion

class ConverterViewModel: ViewModel() {

    fun getConversions() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs","Kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "Kg","lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd","m", 0.9144),
        Conversion(4, "Meters to Yards", "m","yd", 1.09361),
        Conversion(1, "Miles to Kilometers", "mi","km", 1.60934),
        Conversion(1, "Kilometers to Miles", "km","mi", 0.621371)
    )

}