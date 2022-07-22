package com.dynast.weather.domain.model.youtube

data class PlaylistItem(
    val videoId: String,
    val videoPublishedAt: String,
    val etag: String,
    val id: String,
    val kind: String,
    val privacyStatus: String,

    val snippetChannelId: String,
    val snippetChannelTitle: String,
    val snippetDescription: String,
    val playlistId: String,
    val position: Int,
    val publishedAt: String,

    val resourceKindId: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoOwnerChannelId: String,
    val videoOwnerChannelTitle: String
)
