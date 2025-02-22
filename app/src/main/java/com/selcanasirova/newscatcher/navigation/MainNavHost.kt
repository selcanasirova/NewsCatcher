package com.selcanasirova.newscatcher.navigation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.selcanasirova.newscatcher.navigation.nav_graph.detailNavGraph
import com.selcanasirova.newscatcher.navigation.nav_graph.homeNavGraph
import com.selcanasirova.newscatcher.navigation.nav_graph.lagnNavGraph
import com.selcanasirova.newscatcher.navigation.nav_graph.savedNavGraph


@Composable
fun MainNavHost(
    startDestination: ScreenRoutes
) {
    val navController = rememberNavController()
//    val allStories = remember { mutableStateListOf<String>() }
    val context = LocalContext.current
//    val focusManager = LocalFocusManager.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation<ScreenRoutes.HomeRoot>(
            startDestination = ScreenRoutes.Home
        ){
            homeNavGraph(
                navController = navController,
                onPopBackStack = navController::popBackStack,
                onNavigateTo = {navController.navigate(it)}

            )
        }
        
        navigation<ScreenRoutes.DetailsRoot>(
            startDestination= ScreenRoutes.Details
        ){
            detailNavGraph(
                navController = navController,
                onPopBackStack = navController::popBackStack,
                onNavigateTo = {navController.navigate(it)}
            )
        }
        
        navigation<ScreenRoutes.LangRoot>(
            startDestination = ScreenRoutes.LangScreen
        ){
            lagnNavGraph(
                navController = navController,
                onPopBackStack = navController::popBackStack,
                onNavigateTo = {navController.navigate(it)}
            )
        }
        
        navigation<ScreenRoutes.SavedRoot>(
            startDestination = ScreenRoutes.SavedPage
        ){
            savedNavGraph(
                navController = navController,
                onPopBackStack = navController::popBackStack,
                onNavigateTo = {navController.navigate(it)}
            )
        }

       
    }
}
