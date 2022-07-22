package com.dynast.weather.ui.main

import com.dynast.weather.domain.model.weather.WeatherInfo

data class WeatherState(
    val info: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
