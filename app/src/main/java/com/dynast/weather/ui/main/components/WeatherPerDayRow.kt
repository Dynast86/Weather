package com.dynast.weather.ui.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.ui.main.WeatherState
import com.dynast.weather.ui.main.components.preview.PreviewData
import com.dynast.weather.ui.theme.WeatherTheme

@Composable
fun WeatherPerDayRow(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    Text(text = "시간별 날씨", modifier = Modifier.padding(top = 16.dp, bottom = 16.dp), fontSize = 12.sp)
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        state.info?.weekWeatherData?.get(0)?.let {
            items(items = it) { item ->
                WeatherPerDayCard(item = item)
            }
        }
    }
    Divider(thickness = Dp.Hairline)
}

@Preview(showBackground = true)
@Composable
fun WeatherPerDayRowPreview() {
    WeatherTheme {
        Column {
            WeatherPerDayRow(
                state = WeatherState(
                    info = WeatherInfo(
                        todayWeatherData = null,
                        weekWeatherData = PreviewData.getWeatherPerDayPreviewData()
                    )
                )
            )
        }
    }
}