package com.example.comics.comics_feature.data.repository

import com.example.comics.comics_feature.domain.repository.ComicsRepository
import com.example.comics.core.data.remote.ComicsService
import com.example.comics.core.data.remote.response.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val service: ComicsService
): ComicsRepository {
    override suspend fun getComics(): Flow<ItemModel> {
        return service.getComics()
    }
}