package com.example.comics.comics_feature.presentation.state

import com.example.comics.core.data.remote.response.ItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class ComicsState(
    val comics: Flow<ItemModel> = emptyFlow()
)
