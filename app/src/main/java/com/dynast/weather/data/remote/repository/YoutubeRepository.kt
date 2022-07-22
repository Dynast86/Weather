package com.dynast.weather.data.remote.repository

import com.dynast.weather.domain.model.youtube.YoutubeData

interface YoutubeRepository {

    suspend fun getYoutubeData(): YoutubeData
}