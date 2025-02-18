package com.selcanasirova.newscatcher.presentation.common.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Immutable
data class ApplicationColors(
    val primaryBackground: Color,
    val secondaryBackground:Color,
    val tertiaryBackground: Color,
    val fourthBackground: Color,

    val primaryText: Color,
    val secondaryText: Color,
    val tertiaryText: Color,

    val primaryBorder: Color,

    val primaryIcon: Color
)

//private val DarkColorScheme = darkColorScheme(
//
//)

private val LightColorScheme = ApplicationColors(
    primaryBackground = Natural1,
    secondaryBackground = Natural400,
    tertiaryBackground = Natural500,
    fourthBackground = Natural200,

    primaryText = Natural700,
    secondaryText = Natural600,
    tertiaryText = Blue,

    primaryBorder = Natural300,

    primaryIcon = Brown
)

val LocalCustomColors = staticCompositionLocalOf { LightColorScheme }

@Composable
fun NewsCatcherTheme(
    systemBarColor: Color = Natural1,
//    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    navigationBarColor: Color = LocalCustomColors.current.primaryBackground,
    content: @Composable () -> Unit
) {
    val colors = LightColorScheme

    val systemUIController = rememberSystemUiController()
    systemUIController.setSystemBarsColor(
        color = systemBarColor
    )
    systemUIController.setNavigationBarColor(
        color = navigationBarColor
    )

    CompositionLocalProvider(LocalCustomColors provides colors) {
        MaterialTheme (content = content)
    }


}

