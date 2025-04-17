package com.selcanasirova.newscatcher.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.main.details.Details
import java.util.Stack

fun NavGraphBuilder.detailNavGraph(
    navController: NavController,
    onPopBackStack: () -> Unit,
    onNavigateTo: (ScreenRoutes) -> Unit
){
    composable<ScreenRoutes.Details>{
        Details(onNavigateTo,onPopBackStack)
    }
}