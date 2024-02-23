package com.example.comics.comics_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.comics.comics_feature.domain.usecase.GetComicsUseCase
import com.example.comics.comics_feature.presentation.state.ComicsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    getComicsUseCase: GetComicsUseCase
): ViewModel() {
    var uiState by mutableStateOf(ComicsState())
        private set

    init {
        runBlocking {
            val comics = getComicsUseCase.invoke()
            uiState = uiState.copy(comics = comics)
        }
    }
}