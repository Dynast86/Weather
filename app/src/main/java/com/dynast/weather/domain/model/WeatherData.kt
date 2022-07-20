package com.dynast.weather.domain.model

import com.dynast.weather.data.remote.dto.Hourly
import com.dynast.weather.data.remote.dto.WeatherDto
import com.dynast.weather.extension.util.WeatherCodes
import com.dynast.weather.extension.util.WindDirections
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
    val windSpeed: Double = 0.0,

    /**
     * 습도 (퍼센트)
     */
    val humidity: Double = 0.0,
) {
    fun toWindSpeedToString(): String {
        return windSpeed.toString()
    }

    fun toWindDirectionToString(): WindDirections = when (windDirection) {
//        in 17..28 -> WindDirections.NbE
        in 11..33 -> WindDirections.NNE
//        in 39..50 -> WindDirections.NEbN
        in 33..56 -> WindDirections.NE
//        in 61..73 -> WindDirections.NEbE
        in 56..79 -> WindDirections.ENE
//        in 83..95 -> WindDirections.EbN

        in 79..101 -> WindDirections.E
//        in 106..118 -> WindDirections.EbS
        in 101..124 -> WindDirections.ESE
//        in 129..146 -> WindDirections.SEbE
        in 124..146 -> WindDirections.SE
//        in 151..163 -> WindDirections.SEbS
        in 146..169 -> WindDirections.SSE
//        in 174..185 -> WindDirections.SbE

        in 169..191 -> WindDirections.S
//        in 196..208 -> WindDirections.SbW
        in 191..213 -> WindDirections.SSW
//        in 219..230 -> WindDirections.SWbS
        in 213..236 -> WindDirections.SW
//        in 241..253 -> WindDirections.SWbW
        in 236..258 -> WindDirections.WSW
//        in 264..276 -> WindDirections.WbS

        in 258..281 -> WindDirections.W
//        in 287..298 -> WindDirections.WbN
        in 281..304 -> WindDirections.WNW
//        in 309..320 -> WindDirections.NWbW
        in 304..326 -> WindDirections.NW
//        in 331..343 -> WindDirections.NWbN
        in 326..349 -> WindDirections.NNW
//        in 354..359 -> WindDirections.NbW
        else -> WindDirections.N
    }
}

data class IndexedWeatherData(
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
    }.mapValues { item ->
        item.value.map { it.data }
    }
}