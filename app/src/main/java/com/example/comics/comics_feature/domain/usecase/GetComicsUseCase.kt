package com.example.comics.comics_feature.domain.usecase

import com.example.comics.comics_feature.domain.repository.ComicsRepository
import com.example.comics.core.data.remote.response.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetComicsUseCase {
    suspend operator fun invoke(): Flow<ItemModel>
}

class GetComicsUseCaseImpl @Inject constructor(
    private val repository: ComicsRepository
): GetComicsUseCase {
    override suspend fun invoke(): Flow<ItemModel> {
        return repository.getComics()
    }
}