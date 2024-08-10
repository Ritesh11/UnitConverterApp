package com.jio.unitconverterapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jio.unitconverterapp.presentation.viewmodel.ConverterViewModel
import com.jio.unitconverterapp.presentation.viewmodel.ConverterViewmodelFactory
import com.jio.unitconverterapp.compose.converter.TopScreen
import com.jio.unitconverterapp.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewmodelFactory,
    modifier: Modifier = Modifier,
    viewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = viewModel.getConversions()
    val historyList = viewModel.resultList.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(
            list,
            viewModel.selectedConversion,
            viewModel.inputText,
            viewModel.typedValue
        ) { message1, message2 ->
            viewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(historyList, { item ->
            viewModel.deleteResult(item)
        }, {
            viewModel.deleteAll()
        })
    }


}