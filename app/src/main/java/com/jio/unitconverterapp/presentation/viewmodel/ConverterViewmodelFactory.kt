package com.jio.unitconverterapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jio.unitconverterapp.data.ConverterRepository
import javax.inject.Inject

class ConverterViewmodelFactory @Inject constructor(private val repository: ConverterRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
}