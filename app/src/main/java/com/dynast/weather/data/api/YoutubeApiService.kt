package com.dynast.weather.data.api

import com.dynast.weather.data.remote.dto.youtube.YoutubeDto
import retrofit2.http.GET

interface YoutubeApiService {
    companion object {
        const val ApiEndPoint: String = "v3/playlistItems"
        const val playListId = "PLsU45F2D-sEanSDUJ0LUye7uK8A66zDiL"
        const val maxCount = "20"
        const val youtubeApiKey = "AIzaSyAHcOCpvqXaS3VrAki_f--q3o3MwwAE21g"
    }

    @GET("$ApiEndPoint?part=id,snippet,contentDetails,status&playlistId=$playListId&maxResults=$maxCount&key=$youtubeApiKey")
    suspend fun getYoutubeData(): YoutubeDto
}