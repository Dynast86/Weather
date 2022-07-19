package com.dynast.weather.domain.model

data class WeatherInfo(
    val weekWeatherData: Map<Int, List<WeatherData>>?,
    val todayWeatherData: WeatherData?
)
