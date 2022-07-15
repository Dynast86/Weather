package com.dynast.weather.data.remote.repository

import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.ui.main.LocationState

interface WeatherRepository {

    suspend fun getWeatherData(location: LocationState): WeatherData
}