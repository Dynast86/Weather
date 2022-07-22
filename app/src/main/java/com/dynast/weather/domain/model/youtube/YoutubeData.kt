package com.dynast.weather.domain.model.youtube

import com.dynast.weather.data.remote.dto.youtube.YoutubeDto

data class YoutubeData(
    val nextPageToken: String,
    val items: List<PlaylistItem> = emptyList(),
    val resultsPerPage: Int,
    val totalResults: Int
)

fun YoutubeDto.toYoutube(): YoutubeData {
    return YoutubeData(
        nextPageToken = nextPageToken,
        resultsPerPage = pageInfo.resultsPerPage,
        totalResults = pageInfo.totalResults,
        items = items.map { item ->
            PlaylistItem(
                videoId = item.contentDetails.videoId,
                videoPublishedAt = item.contentDetails.videoPublishedAt,
                etag = item.etag,
                id = item.id,
                kind = item.kind,
                privacyStatus = item.status.privacyStatus,

                snippetChannelId = item.snippet.channelId,
                snippetChannelTitle = item.snippet.channelTitle,
                snippetDescription = item.snippet.description,
                playlistId = item.snippet.playlistId,
                position = item.snippet.position,
                publishedAt = item.snippet.publishedAt,

                resourceKindId = item.snippet.resourceId.kind,
                thumbnails = Thumbnails(
                    default = item.snippet.thumbnails.default?.let { ThumbnailItem(it.height, it.url, it.width) },
                    high = item.snippet.thumbnails.high?.let { ThumbnailItem(it.height, it.url, it.width) },
                    maxres = item.snippet.thumbnails.maxres?.let { ThumbnailItem(it.height, it.url, it.width) },
                    medium = item.snippet.thumbnails.medium?.let { ThumbnailItem(it.height, it.url, it.width) },
                    standard = item.snippet.thumbnails.standard?.let { ThumbnailItem(it.height, it.url, it.width) },
                ),
                title = item.snippet.title,
                videoOwnerChannelId = item.snippet.videoOwnerChannelId,
                videoOwnerChannelTitle = item.snippet.videoOwnerChannelTitle
            )
        }
    )
}
