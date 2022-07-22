package com.dynast.weather.ui.main

import com.dynast.weather.domain.model.youtube.YoutubeData

data class YoutubeState(
    val info: YoutubeData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
