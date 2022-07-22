package com.dynast.weather.data.remote.dto.youtube

data class Thumbnails(
    val default: ThumbnailItem?,
    val high: ThumbnailItem?,
    val maxres: ThumbnailItem?,
    val medium: ThumbnailItem?,
    val standard: ThumbnailItem?
)