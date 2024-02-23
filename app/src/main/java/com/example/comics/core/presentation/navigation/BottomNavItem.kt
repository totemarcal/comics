package com.example.comics.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Comics : BottomNavItem(
        title = "Comics",
        icon = Icons.Default.Draw,
        route = "comics_screen"
    )

    object ComicsSearch : BottomNavItem(
        title = "Pesquisar",
        icon = Icons.Default.Search,
        route = "comics_search_screen"
    )

    object ComicsFavorite : BottomNavItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite,
        route = "comics_favorite_screen"
    )
}