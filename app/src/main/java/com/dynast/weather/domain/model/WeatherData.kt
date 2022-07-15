package com.dynast.weather.domain.model

import com.dynast.weather.data.remote.dto.WeatherDto

data class WeatherData(
    val temperature: Double,
    val time: String,
    val weatherCode: Int,
    val windDirection: Int,
    val windSpeed: Double
)

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        temperature = currentWeather.temperature,
        time = currentWeather.time,
        weatherCode = currentWeather.weatherCode,
        windDirection = currentWeather.windDirection,
        windSpeed = currentWeather.windSpeed
    )
}