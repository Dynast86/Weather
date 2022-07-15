package com.dynast.weather.extension.util

import androidx.annotation.RawRes
import com.dynast.weather.R

sealed class WeatherCodes(
    val title: String,
    @RawRes val day: Int,
    @RawRes val night: Int
) {
    object ClearSky : WeatherCodes(title = "Clear Sky", day = R.raw.ic_sunny_day, night = R.raw.ic_sunny_night)

    object MainlyClear : WeatherCodes(title = "Mainly Clear", day = R.raw.ic_sunny_day, night = R.raw.ic_sunny_night)
    object PartlyCloudy : WeatherCodes(title = "Partly Cloudy", day = R.raw.ic_cloudy_day, night = R.raw.ic_cloudy_night)
    object Overcast : WeatherCodes(title = "Overcast", day = R.raw.ic_cloudy_day, night = R.raw.ic_cloudy_night)

    object Fog : WeatherCodes(title = "Fog", day = R.raw.ic_foggy_day, night = R.raw.ic_foggy_night)
    object DepositingRimeFog : WeatherCodes(title = "Depositing Rime Fog", day = R.raw.ic_foggy_day, night = R.raw.ic_foggy_night)

    object Drizzle : WeatherCodes(title = "Drizzle", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_night)
    object ModerateDrizzle : WeatherCodes(title = "Moderate Drizzle", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_night)
    object DenseDrizzle : WeatherCodes(title = "Dense Drizzle", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_night)

    object FreezingDrizzle : WeatherCodes(title = "Freezing Drizzle", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_night)
    object DenseFreezingDrizzle : WeatherCodes(title = "Dense Freezing Drizzle", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_night)

    object Rain : WeatherCodes(title = "Rain", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)
    object ModerateRain : WeatherCodes(title = "Moderate Rain", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)
    object HeavyRain : WeatherCodes(title = "Heavy Rain", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)

    object FreezingRain : WeatherCodes(title = "Freezing Rain", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)
    object HeavyFreezingRain : WeatherCodes(title = "Heavy Freezing Rain", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)

    object SnowFall : WeatherCodes(title = "Snow Fall", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)
    object ModerateSnowFall : WeatherCodes(title = "Moderate Snow Fall", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)
    object HeavySnowFall : WeatherCodes(title = "Heavy Snow Fall", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)

    object Snow : WeatherCodes(title = "Snow", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)

    object RainShowers : WeatherCodes(title = "Rain Showers", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)
    object ModerateRainShowers : WeatherCodes(title = "Moderate Rain Showers", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)
    object ViolentRainShowers : WeatherCodes(title = "Violent Rain Showers", day = R.raw.ic_rain_shower_day, night = R.raw.ic_rain_shower_day)

    object SnowShowers : WeatherCodes(title = "Snow Showers", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)
    object ModerateSnowShowers : WeatherCodes(title = "Moderate Snow Showers", day = R.raw.ic_snow_day, night = R.raw.ic_snow_night)

    object Thunderstorm : WeatherCodes(title = "Thunderstorm", day = R.raw.ic_thunder, night = R.raw.ic_thunder)
    object ThunderstormRain : WeatherCodes(title = "Thunderstorm Rain", day = R.raw.ic_rainy_thunder_day, night = R.raw.ic_rainy_thunder_day)
    object HeavyThunderstormRain : WeatherCodes(title = "Heavy Thunderstorm Rain", day = R.raw.ic_rainy_thunder_day, night = R.raw.ic_rainy_thunder_day)

    companion object {
        fun fromWMO(code: Int): WeatherCodes {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Fog
                48 -> DepositingRimeFog
                51 -> Drizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> FreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> Rain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> FreezingRain
                67 -> HeavyFreezingRain
                71 -> SnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> Snow
                80 -> RainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SnowShowers
                86 -> ModerateSnowShowers
                95 -> Thunderstorm
                96 -> ThunderstormRain
                99 -> HeavyThunderstormRain
                else -> ClearSky
            }
        }
    }

}