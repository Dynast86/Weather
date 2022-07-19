package com.dynast.weather.domain.useCase.weather

import android.location.Location
import com.dynast.weather.data.remote.repository.WeatherRepository
import com.dynast.weather.domain.location.LocationTracker
import com.dynast.weather.domain.model.WeatherData
import com.dynast.weather.domain.model.WeatherInfo
import com.dynast.weather.extension.di.IoDispatcher
import com.dynast.weather.extension.util.Resource
import com.dynast.weather.ui.main.LocationState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
    @IoDispatcher val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Resource<WeatherInfo> {
        return try {
            withContext(context = coroutineDispatcher) {
                val location: Location? = locationTracker.getCurrentLocation()
                val resultDeferred = async {
                    repository.getWeatherData(
                        location = if (location == null) {
                            LocationState()
                        } else {
                            LocationState(latitude = location.latitude, longitude = location.longitude)
                        }
                    )
                }
                Resource.Success(data = resultDeferred.await())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "알수없는 에러가 발생했습니다.")
        }
    }
}