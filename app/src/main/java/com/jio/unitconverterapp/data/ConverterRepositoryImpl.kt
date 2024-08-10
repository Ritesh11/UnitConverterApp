package com.jio.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao: ConverterDAO) : ConverterRepository {
    override suspend fun insertResult(conversionResult: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteResult(conversionResult: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun updateResult(conversionResult: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllResult() {
        TODO("Not yet implemented")
    }

    override fun getAllResult(): Flow<List<ConversionResult>> {
        TODO("Not yet implemented")
    }
}