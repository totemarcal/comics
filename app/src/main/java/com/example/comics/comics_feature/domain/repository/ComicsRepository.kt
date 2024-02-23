package com.example.comics.comics_feature.domain.repository

import com.example.comics.core.data.remote.response.ItemModel
import kotlinx.coroutines.flow.Flow

interface ComicsRepository {

    suspend fun getComics(): Flow<ItemModel>
}