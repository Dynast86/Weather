package com.dynast.weather.ui.main

import com.dynast.weather.domain.model.WeatherData

data class WeatherState(
    val info: WeatherData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
