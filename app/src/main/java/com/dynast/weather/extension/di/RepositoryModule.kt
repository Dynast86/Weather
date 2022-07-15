package com.dynast.weather.extension.di

import com.dynast.weather.data.remote.dataSource.RemoteWeatherDataSource
import com.dynast.weather.data.remote.repository.WeatherRepository
import com.dynast.weather.data.remote.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideWeatherRepository(dataSource: RemoteWeatherDataSource): WeatherRepository = WeatherRepositoryImpl(dataSource = dataSource)
}