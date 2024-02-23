package com.example.comics.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel
)

data class ThumbnailModel(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String,
)
