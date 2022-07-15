package com.dynast.weather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperatures: List<Double>,
)