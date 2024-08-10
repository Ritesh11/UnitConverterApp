package com.jio.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao: ConverterDAO) : ConverterRepository {
    override suspend fun insertResult(conversionResult: ConversionResult) {
        dao.insertResult(conversionResult)
    }

    override suspend fun deleteResult(conversionResult: ConversionResult) {
        dao.deleteResult(conversionResult)
    }

    override suspend fun updateResult(conversionResult: ConversionResult) {
        dao.updateResult(conversionResult)
    }

    override suspend fun deleteAllResult() {
        dao.deleteAll()
    }

    override fun getAllResult(): Flow<List<ConversionResult>> {
        return dao.getResult()
    }
}