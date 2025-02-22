package com.selcanasirova.newscatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.selcanasirova.newscatcher.navigation.MainNavHost
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.common.theme.NewsCatcherTheme
import com.selcanasirova.newscatcher.presentation.main.home.HomeScreen

//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsCatcherTheme {
                    MainNavHost(
                        startDestination = ScreenRoutes.DetailsRoot
                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsCatcherTheme {
    }
}