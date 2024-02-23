package com.example.comics.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.comics.comics_feature.presentation.ComicsViewModel
import com.example.comics.comics_feature.presentation.ComicsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Comics.route
    ) {
        composable(BottomNavItem.Comics.route) {
            val viewModel: ComicsViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            ComicsScreen(
                uiState = uiState,
                navigateToDetail = {

                }
            )
        }
        composable(BottomNavItem.ComicsSearch.route){

        }
        composable(BottomNavItem.ComicsFavorite.route){

        }
    }
}