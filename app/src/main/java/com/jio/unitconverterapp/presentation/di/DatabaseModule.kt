package com.jio.unitconverterapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.jio.unitconverterapp.data.ConverterDAO
import com.jio.unitconverterapp.data.ConverterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Singleton
    @Provides
    fun provideConverterDatabase(app: Application): ConverterDatabase{
        return Room.databaseBuilder(app, ConverterDatabase::class.java,"converter_data_database")
            .fallbackToDestructiveMigration()
            .build()
    }


    fun provideConverterDao(converterDatabase: ConverterDatabase): ConverterDAO{
        return converterDatabase.converterDAO

    }

}