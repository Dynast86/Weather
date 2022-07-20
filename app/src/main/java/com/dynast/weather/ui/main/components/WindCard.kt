package com.dynast.weather.ui.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.North
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.extension.util.WeatherCodes
import com.dynast.weather.ui.theme.WeatherTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WindCard(
    modifier: Modifier = Modifier,
    item: WeatherData
) {
    Box(
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .rotate(item.windDirection.toFloat()),
                imageVector = Icons.Default.North, contentDescription = "wind Direction",
            )
            Text(
                text = "${item.windSpeed.toInt()}km/h", fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(text = item.time.format(DateTimeFormatter.ofPattern("a HH시")), fontSize = 12.sp)
        }
    }
}

@Preview(name = "바람_카드")
@Composable
fun WindCardPreview() {
    WeatherTheme {
        WindCard(
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