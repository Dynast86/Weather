package com.dynast.weather.data.remote.dataSource

import com.dynast.weather.data.ApiService
import com.dynast.weather.data.remote.dto.WeatherDto
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getWeatherData(latitude: Double, occupation: Double): WeatherDto {
        return apiService.getWeatherData(latitude = latitude, occupation = occupation)
    }
}