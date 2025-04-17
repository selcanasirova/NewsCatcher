package com.selcanasirova.newscatcher.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.selcanasirova.newscatcher.R
import com.selcanasirova.newscatcher.data.Lang
import com.selcanasirova.newscatcher.presentation.common.components.bar.NavBar
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors
import java.util.Stack

@Composable
fun LangScreen(
    onPopBackStack: () -> Unit
) {
    val colors = LocalCustomColors.current
    Scaffold {
        paddingValues->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = colors.primaryBackground)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 18.dp, start = 12.dp)
                    .width(63.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(color = colors.secondaryBackground.copy(alpha = 0.6f))
                    .clickable { onPopBackStack() }, contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(12.dp)) // 12.dp boşluq
                    Icon(
                        painterResource(R.drawable.arrow), contentDescription = "arrow",
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
            LazyColumn {
                items(Lang.entries) { item ->
                    Text(
                        item.language,
                        fontSize = 18.sp, fontWeight = FontWeight(500), lineHeight = 22.sp,
                        modifier = Modifier.padding(20.dp)
                    )
                    Spacer(Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.Black))
                }
            }
        }
    }

}

@Preview
@Composable
fun LangScreenPreview() {
    LangScreen(onPopBackStack = {})
}