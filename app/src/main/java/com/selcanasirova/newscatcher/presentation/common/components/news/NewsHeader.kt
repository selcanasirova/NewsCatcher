package com.selcanasirova.newscatcher.presentation.common.components.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable
fun NewsHeader(){
    val colors = LocalCustomColors.current
    Column(verticalArrangement = Arrangement.spacedBy(45.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(28.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(18.dp).clip(RoundedCornerShape(50.dp)).background(color = colors.primaryText)) {  }
            Text("News Catcher",
                fontSize = 20.sp, fontWeight = FontWeight(700), lineHeight = 24.sp, color = colors.primaryText
            )
        }
        Text("March 26th, 2022",
            fontSize = 13.sp, fontWeight = FontWeight(500), lineHeight = 16.sp, color = colors.secondaryText
        )
    }
}


@Preview
@Composable
fun NewsHeaderPreview(){
    NewsHeader()
}