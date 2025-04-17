package com.selcanasirova.newscatcher.presentation.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.common.components.bar.NavBar
import com.selcanasirova.newscatcher.presentation.common.components.buton.LangBtn
import com.selcanasirova.newscatcher.presentation.common.components.news.News
import com.selcanasirova.newscatcher.presentation.common.components.news.NewsHeader
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable
fun HomeScreen(
    onNavigateTo: (ScreenRoutes) -> Unit
) {
    val colors = LocalCustomColors.current

    Scaffold(
        bottomBar = { NavBar(onNavigateTo) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 23.dp)
                .padding(top = 33.dp)
                .background(color = colors.primaryBackground)
        ) {
            NewsHeader()
            Spacer(modifier = Modifier.height(41.dp))
            MainNews(onNavigateTo)
            Spacer(modifier = Modifier.height(25.dp))
            Search()
            Spacer(modifier = Modifier.height(13.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                LangBtn(onNavigateTo)
            }
            News(onNavigateTo)
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(onNavigateTo = {})
}