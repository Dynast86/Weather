package com.dynast.weather.ui.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.ui.main.WeatherState
import com.dynast.weather.ui.main.components.preview.PreviewData
import com.dynast.weather.ui.theme.WeatherTheme

@Composable
fun WeatherPerDayRow(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        state.info?.weekWeatherData?.get(0)?.let {
            items(items = it) { item ->
                WeatherPerDayCard(item = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPerDayRowPreview() {
    WeatherTheme {
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