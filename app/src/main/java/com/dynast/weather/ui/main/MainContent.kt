package com.dynast.weather.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.weather.ui.theme.WeatherTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
//    val state = viewModel.weather.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        Column {
            Text(text = "Hello!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    WeatherTheme {
        MainScreen()
    }
}