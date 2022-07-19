package com.dynast.weather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperatures: List<Double>,

    @SerializedName("relativehumidity_2m")
    val humidity: List<Double>,

    @SerializedName("apparent_temperature")
    val apparentTemperature: List<Double>,

    @SerializedName("weathercode")
    val weatherCode: List<Int>,

    @SerializedName("windspeed_10m")
    val windSpeed: List<Double>,
    @SerializedName("winddirection_10m")
    val windDirection: List<Int>

)