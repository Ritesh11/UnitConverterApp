package com.jio.unitconverterapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.jio.unitconverterapp.data.ConverterDAO
import com.jio.unitconverterapp.data.ConverterDatabase
import com.jio.unitconverterapp.data.ConverterRepository
import com.jio.unitconverterapp.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application): ConverterDatabase {
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "converter_data_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


   /* @Provides
    @Singleton
    fun provideConverterDao(converterDatabase: ConverterDatabase): ConverterDAO {
        return converterDatabase.converterDAO

    }*/


    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDatabase): ConverterRepository{
        return ConverterRepositoryImpl(db.converterDAO)
    }

}