package com.dynast.weather.data.remote.dataSource

import com.dynast.weather.data.api.WeatherApiService
import com.dynast.weather.data.remote.dto.weather.WeatherDto
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val apiService: WeatherApiService
) {

    suspend fun getWeatherData(latitude: Double, occupation: Double): WeatherDto {
        return apiService.getWeatherData(latitude = latitude, occupation = occupation)
    }
}