package com.selcanasirova.newscatcher.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoutes{

    @Serializable
    data object Home: ScreenRoutes()

    @Serializable
    data object Details: ScreenRoutes()

    @Serializable
    data object LangScreen: ScreenRoutes()

    @Serializable
    data object SavedPage: ScreenRoutes()
}