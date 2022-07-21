package com.dynast.weather.ui.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.extension.util.WeatherCodes
import com.dynast.weather.ui.theme.WeatherTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeatherPerDayCard(
    modifier: Modifier = Modifier,
    item: WeatherData
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(item.weatherCode.day))

    Box(
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${item.temperature.toInt()}°", fontSize = 12.sp)

            LottieAnimation(
                modifier = modifier.size(48.dp),
                composition = composition, iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillWidth
            )
            Text(text = item.time.format(DateTimeFormatter.ofPattern("a hh시")), fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
fun WeatherPerDayCardPreview() {
    WeatherTheme {
        WeatherPerDayCard(
            item = WeatherData(
                time = LocalDateTime.parse("2022-07-19T00:00", DateTimeFormatter.ISO_DATE_TIME),
                temperature = 26.5,
                apparentTemperature = 31.4,
                weatherCode = WeatherCodes.fromWMO(2),
                windDirection = 297,
                windSpeed = 3.2,
                humidity = 80.0
            )
        )
    }
}