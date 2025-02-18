package com.selcanasirova.newscatcher.presentation.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.selcanasirova.newscatcher.data.MainNewsData
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable
fun MainNews(){
    val colors = LocalCustomColors.current
    LazyRow (modifier = Modifier
        , horizontalArrangement = Arrangement.spacedBy(27.dp)){
        items(MainNewsData.entries) { item ->
            Box( modifier = Modifier.width(320.dp).height(180.dp).clip(RoundedCornerShape(16.dp))){
                Image(
                    painterResource(item.img), contentDescription = "img",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column ( modifier = Modifier.fillMaxSize().padding(15.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Box(modifier = Modifier.clip(
                        RoundedCornerShape(32.dp)
                    ).background(color = colors.secondaryBackground.copy(alpha = 0.6f))){
                        Text("News",
                            modifier = Modifier.padding(horizontal = 28.dp, vertical = 5.dp),
                            fontSize = 11.sp, fontWeight = FontWeight(500), lineHeight = 13.sp, color = colors.primaryText
                        )
                    }
                    Text(item.news,
                        fontSize = 18.sp, lineHeight = 22.sp,
                        fontWeight = FontWeight(700), color = colors.primaryText)

                }
                }
        }

    }
}

@Preview
@Composable
fun MainNewsPreview() {
    MainNews()
}