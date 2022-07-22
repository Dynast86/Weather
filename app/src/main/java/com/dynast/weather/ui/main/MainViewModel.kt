package com.dynast.weather.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynast.weather.domain.useCase.weather.GetWeatherUseCase
import com.dynast.weather.domain.useCase.youtube.GetYoutubeUseCase
import com.dynast.weather.extension.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getYoutubeUseCase: GetYoutubeUseCase
) : ViewModel() {

    private val _weather = MutableStateFlow(WeatherState())
    val weather: StateFlow<WeatherState> get() = _weather

    private val _youtube = MutableStateFlow(YoutubeState())
    val youtube: StateFlow<YoutubeState> get() = _youtube

    fun getWeatherData() = viewModelScope.launch {
        _weather.tryEmit(WeatherState(isLoading = true))
        _weather.emit(
            when (val result = getWeatherUseCase()) {
                is Resource.Success -> WeatherState(info = result.data)
                is Resource.Error -> WeatherState(error = result.message)
            }
        )
    }

    fun getYoutubeData() = viewModelScope.launch {
        _youtube.tryEmit(YoutubeState(isLoading = true, error = null))
        _youtube.emit(
            when (val result = getYoutubeUseCase()) {
                is Resource.Success -> YoutubeState(info = result.data)
                is Resource.Error -> YoutubeState(error = result.message)
            }
        )
    }
}