package com.jio.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {

    suspend fun insertResult(conversionResult: ConversionResult)
    suspend fun deleteResult(conversionResult: ConversionResult)
    suspend fun updateResult(conversionResult: ConversionResult)
    suspend fun deleteAllResult()
    fun getAllResult(): Flow<List<ConversionResult>>

}