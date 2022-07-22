package com.dynast.weather.domain.model.youtube

data class Thumbnails(
    val default: ThumbnailItem?,
    val high: ThumbnailItem?,
    val maxres: ThumbnailItem?,
    val medium: ThumbnailItem?,
    val standard: ThumbnailItem?
)

data class ThumbnailItem(
    val height: Int,
    val url: String,
    val width: Int
)