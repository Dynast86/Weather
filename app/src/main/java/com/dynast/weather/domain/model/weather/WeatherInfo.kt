package com.dynast.weather.domain.model.weather

data class WeatherInfo(
    val weekWeatherData: Map<Int, List<WeatherData>>?,
    val todayWeatherData: WeatherData?
)
