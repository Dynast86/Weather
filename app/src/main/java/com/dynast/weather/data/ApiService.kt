package com.dynast.weather.data

import com.dynast.weather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val ApiEndPoint: String = "v1/forecast"
    }

    @GET("$ApiEndPoint?current_weather=true&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,weathercode,windspeed_10m,winddirection_10m&timezone=Asia%2FSeoul")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") occupation: Double,
    ): WeatherDto
}