package com.dynast.weather.data.remote.dto.youtube

data class YoutubeDto(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)