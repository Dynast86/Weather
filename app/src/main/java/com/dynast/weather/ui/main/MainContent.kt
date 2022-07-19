package com.dynast.weather.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.weather.collectAsState()
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(192.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            TodayWeatherCard(state = state.value)
        }
    }
}