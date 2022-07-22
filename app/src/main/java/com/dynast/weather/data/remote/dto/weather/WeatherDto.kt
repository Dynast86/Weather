package com.dynast.weather.data.remote.dto.weather

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    val elevation: Double,

    @SerializedName("generationtime_ms")
    val generations: Double,
    val hourly: Hourly,

    val latitude: Double,
    val longitude: Double,

    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)