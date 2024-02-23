package com.example.comics.core.presentation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.comics.core.presentation.navigation.BottomNavigationBar
import com.example.comics.core.presentation.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content ={
            NavigationGraph(navController = navController)
        }
    )
}