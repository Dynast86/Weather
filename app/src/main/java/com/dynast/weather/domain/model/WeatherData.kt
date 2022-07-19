package com.dynast.weather.domain.model

import com.dynast.weather.data.remote.dto.Hourly
import com.dynast.weather.data.remote.dto.WeatherDto
import com.dynast.weather.extension.util.WeatherCodes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class WeatherData(
    /**
     * 온도 (섭씨)
     */
    val temperature: Double,

    /**
     * 체감 온도
     */
    val apparentTemperature: Double = 0.0,

    /**
     * 시간
     */
    val time: LocalDateTime,

    /**
     * 날씨 코드 (WMO Code)
     */
    val weatherCode: WeatherCodes,

    /**
     * 풍향 (Degree)
     */
    val windDirection: Int,

    /**
     * 풍속 (km/h)
     */
    val windSpeed: Double,

    /**
     * 습도 (퍼센트)
     */
    val humidity: Double = 0.0,
)

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDto.toWeatherData(): WeatherInfo {
    return WeatherInfo(
        todayWeatherData = WeatherData(
            temperature = currentWeather.temperature,
            time = LocalDateTime.parse(currentWeather.time, DateTimeFormatter.ISO_DATE_TIME),
            weatherCode = WeatherCodes.fromWMO(currentWeather.weatherCode),
            windDirection = currentWeather.windDirection,
            windSpeed = currentWeather.windSpeed
        ),
        weekWeatherData = hourly.toWeatherDataMap()
    )
}

fun Hourly.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                temperature = temperatures[index],
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                weatherCode = WeatherCodes.fromWMO(weatherCode[index]),
                windDirection = windDirection[index],
                windSpeed = windSpeed[index],
                humidity = humidity[index]
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}