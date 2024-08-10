package com.jio.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jio.unitconverterapp.data.ConverterRepository

class ConverterViewmodelFactory(private val repository: ConverterRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
}