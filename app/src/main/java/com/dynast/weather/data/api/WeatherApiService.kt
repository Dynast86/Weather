package com.dynast.weather.data.api

import com.dynast.weather.data.remote.dto.weather.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    companion object {
        const val ApiEndPoint: String = "v1/forecast"
    }

    @GET("$ApiEndPoint?current_weather=true" +
            "&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,weathercode,windspeed_10m,winddirection_10m&timezone=Asia%2FSeoul" +
            "&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,shortwave_radiation_sum,et0_fao_evapotranspiration")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") occupation: Double,
    ): WeatherDto
}