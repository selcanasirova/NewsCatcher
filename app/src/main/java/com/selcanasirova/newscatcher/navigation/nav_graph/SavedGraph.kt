package com.selcanasirova.newscatcher.navigation.nav_graph

import androidx.compose.ui.graphics.vector.PathNode
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.main.saved.SavedScreen
import java.util.Stack

fun NavGraphBuilder.savedNavGraph(
  navController: NavController,
  onPopBackStack: () -> Unit,
  onNavigateTo: (ScreenRoutes) -> Unit
){
    composable<ScreenRoutes.SavedPage>{
        SavedScreen()
    }
}