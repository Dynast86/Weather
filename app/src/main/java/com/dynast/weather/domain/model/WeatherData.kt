package com.dynast.weather.domain.model

import com.dynast.weather.data.remote.dto.WeatherDto
import com.dynast.weather.extension.util.WeatherCodes

data class WeatherData(
    val temperature: Double,
    val time: String,
    val weatherCode: WeatherCodes,
    val windDirection: Int,
    val windSpeed: Double
)

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        temperature = currentWeather.temperature,
        time = currentWeather.time,
        weatherCode = WeatherCodes.fromWMO(currentWeather.weatherCode),
        windDirection = currentWeather.windDirection,
        windSpeed = currentWeather.windSpeed
    )
}