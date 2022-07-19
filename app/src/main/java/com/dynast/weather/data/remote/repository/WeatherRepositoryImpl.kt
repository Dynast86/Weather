package com.dynast.weather.data.remote.repository

import com.dynast.weather.data.remote.dataSource.RemoteWeatherDataSource
import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.domain.model.toWeatherData
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