package com.dynast.weather.ui.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.North
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.extension.util.WeatherCodes
import com.dynast.weather.ui.main.WeatherState
import com.dynast.weather.ui.main.components.preview.PreviewData
import com.dynast.weather.ui.theme.WeatherTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeatherPerDayWind(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    Text(text = "바람", modifier = Modifier.padding(top = 16.dp, bottom = 16.dp), fontSize = 12.sp)

    Row(modifier = Modifier.padding(bottom = 8.dp), verticalAlignment = Alignment.Bottom) {
        state.info?.todayWeatherData?.let { data ->
            Box {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontSize = 48.sp
                        )
                    ) {
                        val speed = data.toWindSpeedToString()
                        append(speed.toString())
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp)) {
                        append(" km/h")
                    }
                })
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.TopEnd)
                        .offset((-8).dp, (16).dp)
                        .rotate(data.windDirection.toFloat()),
                    imageVector = Icons.Default.North, contentDescription = "wind Direction",
                )
            }
            data.toWindDirectionToString().cardinalPoint.let {
                Text(text = it, modifier = Modifier.padding(8.dp))
            }
        }
    }
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        state.info?.weekWeatherData?.get(0)?.let {
            items(items = it) { item ->
                WindCard(item = item)
            }
        }
    }
    Divider(thickness = Dp.Hairline)
}

@Preview(
    showBackground = true,
    name = "풍향_풍속_미리보기"
)
@Composable
fun WeatherPerDayWindPreview() {
    WeatherTheme {
        Column {
            WeatherPerDayWind(
                state = WeatherState(
                    info = WeatherInfo(
                        todayWeatherData = WeatherData(
                            temperature = 29.7,
                            time = LocalDateTime.parse("2022-07-19T16:00", DateTimeFormatter.ISO_DATE_TIME),
                            weatherCode = WeatherCodes.ClearSky,
                            windSpeed = 15.1,
                            windDirection = 258
                        ),
                        weekWeatherData = PreviewData.getWeatherPerDayPreviewData()
                    )
                )
            )
        }
    }
}