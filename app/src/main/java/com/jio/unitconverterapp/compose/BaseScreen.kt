package com.jio.unitconverterapp.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.sqlite.db.SupportSQLiteOpenHelper
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

    val configuration = LocalConfiguration.current

    var isLandscape by remember {
        mutableStateOf(false)
    }

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(
                modifier = modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    viewModel.selectedConversion,
                    viewModel.inputText,
                    viewModel.typedValue,
                    isLandscape
                ) { message1, message2 ->
                    viewModel.addResult(message1, message2)
                }
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(historyList, { item ->
                    viewModel.deleteResult(item)
                }, {
                    viewModel.deleteAll()
                })
            }
        }else -> {
            isLandscape = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    list,
                    viewModel.selectedConversion,
                    viewModel.inputText,
                    viewModel.typedValue,
                    isLandscape
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
    }


}