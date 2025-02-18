package com.selcanasirova.newscatcher.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.main.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    onPopBackStack: () -> Unit,
    onNavigateTo: (ScreenRoutes) -> Unit
){
    composable<ScreenRoutes.Home>{
        HomeScreen()
    }
}