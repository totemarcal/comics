package com.example.comics.comics_feature.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.comics.core.domain.model.ItemVO

@Composable
fun ComicsContent(
    comics: List<ItemVO>,
    values: PaddingValues,
    onClick: (comicsId: Int) -> Unit
    ) {
    Box(modifier = Modifier.background(Color.Black)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = values,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            items(comics) { comic ->

                comic?.let {
                    ComicsItem(
                        title = it.title,
                        imageUrl = it.image,
                        id = 0,
                        onClick = { comicsId ->
                            onClick(comicsId)
                        }
                    )
                }
            }
        }
    }
}
