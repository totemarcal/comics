package com.example.comics.comics_feature.data.mapper

import com.example.comics.core.data.remote.model.ResultModel
import com.example.comics.core.domain.model.ItemVO

fun List<ResultModel>.toComics() = map { item ->
    ItemVO (
        image = "${item.thumbnail.path}.${item.thumbnail.extension}",
        title = item.title,
        subtitle = item.description ?: ""
    )
}