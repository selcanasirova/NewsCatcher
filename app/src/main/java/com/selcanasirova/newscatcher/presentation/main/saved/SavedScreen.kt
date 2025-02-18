package com.selcanasirova.newscatcher.presentation.main.saved

import android.icu.number.Scale
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.selcanasirova.newscatcher.presentation.common.components.bar.NavBar
import com.selcanasirova.newscatcher.presentation.common.components.news.News
import com.selcanasirova.newscatcher.presentation.common.components.news.NewsHeader

@Composable
fun SavedScreen(){
    Scaffold (
        bottomBar = { NavBar() }
    ) {paddingValues->
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 23.dp, vertical = 33.dp)) {
            NewsHeader()
            Spacer(modifier = Modifier.height(31.dp).padding(paddingValues))
            News()
        }
    }


}

@Preview
@Composable
fun SavedScreenPreview(){
    SavedScreen()
}