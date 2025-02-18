package com.selcanasirova.newscatcher.presentation.common.components.news


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
fun News() {
    val colors = LocalCustomColors.current
    LazyColumn {
        items(MainNewsData.entries) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(colors.primaryBackground)
                    .padding(vertical =  16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start)

                ) {
                    Column(
                        modifier = Modifier
                            .height(80.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(32.dp))
                                .background(color = colors.secondaryBackground)
                        ) {
                            Text(
                                item.btn,
                                modifier = Modifier.padding(vertical = 3.dp, horizontal = 19.dp),
                                fontSize = 10.sp,
                                fontWeight = FontWeight(500),
                                lineHeight = 12.sp,
                                color = colors.primaryText
                            )
                        }
                        Text(
                            item.details,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            lineHeight = 19.sp,
                            color = colors.primaryText
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(item.nameWriter
                            , fontSize = 10.sp, fontWeight = FontWeight(500), lineHeight = 12.sp, color = colors.secondaryText
                            )
                            Text(item.date
                            , fontSize = 12.sp, fontWeight = FontWeight(700), lineHeight = 15.sp, color = colors.primaryText)
                            }
                    }

                    Box(
                        modifier = Modifier
                            .width(102.dp).height(80.dp)
                            .clip(RoundedCornerShape(18.dp))
                    ) {
                        Image(
                            painter = painterResource(item.img),
                            contentDescription = "news img",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun NewsPreview(){
    News()
}
