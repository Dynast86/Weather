package com.dynast.weather.data.remote.repository

import com.dynast.weather.data.remote.dataSource.RemoteWeatherDataSource
import com.dynast.weather.domain.model.weather.WeatherInfo
import com.dynast.weather.domain.model.weather.toWeatherData
import com.dynast.weather.ui.main.LocationState
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val dataSource: RemoteWeatherDataSource
) : WeatherRepository {

    override suspend fun getWeatherData(
        location: LocationState
    ): WeatherInfo {
        return dataSource.getWeatherData(latitude = location.latitude, occupation = location.longitude).toWeatherData()
    }
}