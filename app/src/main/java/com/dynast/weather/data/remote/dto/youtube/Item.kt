package com.dynast.weather.data.remote.dto.youtube

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet,
    val status: Status
)