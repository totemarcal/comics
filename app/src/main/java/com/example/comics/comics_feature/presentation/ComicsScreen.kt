package com.example.comics.comics_feature.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.comics.R
import com.example.comics.comics_feature.data.mapper.toComics
import com.example.comics.comics_feature.presentation.components.ComicsContent
import com.example.comics.comics_feature.presentation.state.ComicsState
import com.example.comics.core.data.remote.response.DataModel
import com.example.comics.core.data.remote.response.ItemModel
import com.example.comics.core.util.UtilFunctions
import com.example.comics.theme.black
import com.example.comics.theme.white

@Composable
fun ComicsScreen(
    uiState: ComicsState,
    navigateToDetail: (Int) -> Unit
) {
    val comics = uiState.comics.collectAsState(initial = ItemModel(data = DataModel(results = emptyList())))

    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        text = stringResource(id = R.string.comics_title),
                        color = white
                        )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            ComicsContent(
                comics = comics.value.data.results.toComics(),
                values = paddingValues,
                onClick = { comicsId ->
                    UtilFunctions.logInfo("COMICS_ID", comicsId.toString())
                    navigateToDetail(comicsId)
                }
            )
        }
    )
}