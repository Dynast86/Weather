package com.dynast.weather.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.extension.util.WeatherCodes
import com.dynast.weather.ui.theme.WeatherTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayWeatherCard(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(192.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), contentAlignment = Alignment.Center
        ) {
            state.info?.todayWeatherData?.apply {
                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(weatherCode.day))

                Column(modifier = modifier.fillMaxWidth()) {
                    Text(text = time.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시mm분")))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Column {
                            Text(text = "${temperature}°C", fontSize = 64.sp)
                            Text(text = "풍량 : ${windDirection}°")
                            Text(text = "풍속 : ${windSpeed}km/h")
                        }
                        Box(modifier = modifier.size(120.dp)) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                LottieAnimation(
                                    modifier = modifier.size(96.dp),
                                    composition = composition, iterations = LottieConstants.IterateForever,
                                    contentScale = ContentScale.FillWidth
                                )
                                Text(text = weatherCode.title)
                            }
                        }
                    }
                }
            } ?: run {
                Text(text = "Now Loading...")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodayWeatherCardPreview() {
    WeatherTheme {
        TodayWeatherCard(
            state = WeatherState(
                info = WeatherInfo(
                    todayWeatherData = WeatherData(
                        temperature = 29.7,
                        time = LocalDateTime.parse("2022-07-19T16:00", DateTimeFormatter.ISO_DATE_TIME),
                        weatherCode = WeatherCodes.ClearSky,
                        windSpeed = 15.1,
                        windDirection = 258
                    ), weekWeatherData = null
                )
            )
        )
    }
}