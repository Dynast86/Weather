package com.dynast.weather.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynast.weather.domain.useCase.weather.GetWeatherUseCase
import com.dynast.weather.extension.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {
    companion object {
        val TAG: String = MainViewModel::class.java.simpleName
    }

    private val _weather = MutableStateFlow(WeatherState())
    val weather: StateFlow<WeatherState> get() = _weather

    fun getWeatherData() = viewModelScope.launch {
        _weather.tryEmit(WeatherState(isLoading = true, error = null))
        _weather.emit(
            when (val result = getWeatherUseCase()) {
                is Resource.Success -> {
                    WeatherState(info = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    WeatherState(info = null, isLoading = false, error = result.message)
                }
            }
        )
    }
}