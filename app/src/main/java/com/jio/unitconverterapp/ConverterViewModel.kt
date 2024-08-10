package com.jio.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jio.unitconverterapp.data.Conversion
import com.jio.unitconverterapp.data.ConversionResult
import com.jio.unitconverterapp.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository) : ViewModel() {

    fun getConversions() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs", "Kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "Kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(1, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(1, "Kilometers to Miles", "km", "mi", 0.621371)
    )

    fun addResult(message1: String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0, message1, message2))
        }
    }

    fun updateConverterResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateResult(result)
        }
    }


    fun deleteResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(result)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResult()
        }
    }

}