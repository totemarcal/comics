package com.example.comics.comics_feature.di

import com.example.comics.comics_feature.data.repository.ComicsRepositoryImpl
import com.example.comics.comics_feature.domain.repository.ComicsRepository
import com.example.comics.comics_feature.domain.usecase.GetComicsUseCase
import com.example.comics.comics_feature.domain.usecase.GetComicsUseCaseImpl
import com.example.comics.core.data.remote.ComicsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComicsFeatureModule {

    @Provides
    @Singleton
    fun provideComicsRepository(service: ComicsService): ComicsRepository {
        return ComicsRepositoryImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideGetComicsUseCase(repository: ComicsRepository): GetComicsUseCase {
        return GetComicsUseCaseImpl(repository = repository)
    }
}