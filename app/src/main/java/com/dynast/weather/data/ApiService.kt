package com.dynast.weather.data

import com.dynast.weather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        val TAG: String = ApiService::class.java.simpleName
        const val ApiEndPoint: String = "v1/forecast"
    }

    @GET("$ApiEndPoint?&hourly=temperature_2m&current_weather=true")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") occupation: Double,
    ): WeatherDto
}