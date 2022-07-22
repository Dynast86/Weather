package com.dynast.weather.data.remote.repository

import com.dynast.weather.data.remote.dataSource.RemoteYoutubeDataSource
import com.dynast.weather.domain.model.youtube.YoutubeData
import com.dynast.weather.domain.model.youtube.toYoutube
import javax.inject.Inject

class YoutubeRepositoryImpl @Inject constructor(
    private val dataSource: RemoteYoutubeDataSource
) : YoutubeRepository {

    override suspend fun getYoutubeData(): YoutubeData {
        return dataSource.getYoutubeData().toYoutube()
    }
}