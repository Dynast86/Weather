package com.dynast.weather.data.remote.dataSource

import com.dynast.weather.data.api.YoutubeApiService
import com.dynast.weather.data.remote.dto.youtube.YoutubeDto
import javax.inject.Inject

class RemoteYoutubeDataSource @Inject constructor(
    private val apiService: YoutubeApiService
) {
    companion object {
        val TAG: String = RemoteYoutubeDataSource::class.java.simpleName
    }

    suspend fun getYoutubeData(): YoutubeDto {
        return apiService.getYoutubeData()
    }
}