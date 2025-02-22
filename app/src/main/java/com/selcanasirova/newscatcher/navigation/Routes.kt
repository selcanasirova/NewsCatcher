package com.selcanasirova.newscatcher.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoutes{

    @Serializable
    data object Home: ScreenRoutes()

    @Serializable
    data object HomeRoot: ScreenRoutes()

    @Serializable
    data object Details: ScreenRoutes()

    @Serializable
    data object DetailsRoot: ScreenRoutes()

    @Serializable
    data object LangScreen: ScreenRoutes()

    @Serializable
    data object LangRoot: ScreenRoutes()

    @Serializable
    data object SavedPage: ScreenRoutes()

    @Serializable
    data object SavedRoot: ScreenRoutes()
}