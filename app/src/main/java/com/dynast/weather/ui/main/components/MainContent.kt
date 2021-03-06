package com.dynast.weather.ui.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.weather.ui.main.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.weather.collectAsState()
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(192.dp)
                        .clickable {
                            if (!state.value.isLoading) scope.launch {
                                viewModel.getWeatherData()
                                viewModel.getYoutubeData()
                            }
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    TodayWeatherCard(state = state.value)
                }
            }

            item { WeatherPerDayRow(state = state.value) }
            item { WeatherPerDayWind(state = state.value) }
        }
    }
}