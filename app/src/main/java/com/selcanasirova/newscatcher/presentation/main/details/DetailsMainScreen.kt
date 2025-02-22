package com.selcanasirova.newscatcher.presentation.main.details


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.selcanasirova.newscatcher.R
import com.selcanasirova.newscatcher.navigation.ScreenRoutes
import com.selcanasirova.newscatcher.presentation.common.components.bar.NavBar
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable
fun Details(
    onNavigateTo: (ScreenRoutes) -> Unit
){
    val colors = LocalCustomColors.current
    Scaffold(
        bottomBar = { NavBar(onNavigateTo ) }
    ) {paddingValues ->
        Column(modifier = Modifier.background(color = colors.primaryBackground).padding(paddingValues)) {
            Box(){
                Image(
                    painterResource(R.drawable.download), contentDescription = "Detail img",
                    modifier = Modifier
//                .fillMaxHeight(0.6f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)) {
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Box(modifier = Modifier.width(119.dp).height(30.dp).clip(RoundedCornerShape(32.dp)).background(color = colors.secondaryBackground.copy(alpha = 0.6f)), contentAlignment = Alignment.Center){
                            Row(modifier = Modifier.padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Icon(
                                    painterResource(R.drawable.arrow), contentDescription = "arrow",
                                    modifier = Modifier.size(13.dp)
                                )
                                Text("Factbox: Who is still buying Russian crude oil?",
                                    maxLines = 1,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 12.sp,
                                    overflow = TextOverflow.Ellipsis)
                            }
                        }
                        Box(modifier = Modifier.size(35.dp).clip(RoundedCornerShape(32.dp)).background(color = colors.secondaryBackground.copy(alpha = 0.48f)), contentAlignment = Alignment.Center){
                            Icon(
                                painterResource(R.drawable.group4), contentDescription = "arrow",
                                modifier = Modifier.size(13.dp)
                            )
                        }
                    }

                    Row (modifier = Modifier.fillMaxWidth().padding(end = 17.dp),horizontalArrangement = Arrangement.End){
                        Box(modifier = Modifier.width(187.dp).clip(RoundedCornerShape(16.dp)).background(colors.fourthBackground.copy(alpha = 0.95f)), contentAlignment = Alignment.Center){
                            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                                Row (modifier = Modifier.fillMaxWidth().drawBehind {
                                    drawLine(
                                        color = colors.primaryText,
                                        start = Offset(0f, size.height),
                                        end = Offset(size.width, size.height),
                                        strokeWidth = 1.dp.toPx()
                                    )
                                }.padding(vertical = 19.dp, horizontal = 21.dp), verticalAlignment = Alignment.CenterVertically){
                                    Image(
                                        painterResource(R.drawable.save_icon), contentDescription = "saved icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                    Text("Save", fontSize = 16.sp, fontWeight = FontWeight(500), lineHeight = 19.sp, color = colors.primaryText,
                                        modifier = Modifier.padding(start = 36.dp))

                                }
                                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 19.dp, horizontal = 21.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painterResource(R.drawable.share_icon), contentDescription = "share icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                    Text("Share",  fontSize = 16.sp, fontWeight = FontWeight(500), lineHeight = 19.sp, color = colors.primaryText,
                                        modifier = Modifier.padding(start = 36.dp))
                                }

                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-30).dp)
                    .zIndex(2f)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                        .background(color = colors.primaryBackground)
                        .fillMaxWidth()
                        .padding(33.dp)
                ){  Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .background(color = colors.secondaryBackground)
                    ) {
                        Text(
                            "Finance",
                            modifier = Modifier.padding(vertical = 3.dp, horizontal = 19.dp),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 12.sp,
                            color = colors.primaryText
                        )
                    }
                    Text("Factbox: Who is still buying Russian crude oil?",
                        fontSize = 26.sp, fontWeight = FontWeight(700), lineHeight = 31.sp, color = colors.primaryText
                    )
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            Text("Jennifer Wars",
                                fontSize = 12.sp, fontWeight = FontWeight(700), lineHeight = 15.sp, color = colors.tertiaryText)
                        }
                        Text("Australia, Britain, Canada and the United States have imposed outright bans on Russian oil purchases following Moscow's invasion of Ukraine, but members of the European Union are split.",
                            fontSize = 15.sp, fontWeight = FontWeight(700), lineHeight = 18.sp, color = colors.primaryText)
                    }
                    Text("(Reuters) - Australia, Britain, Canada and the United States have imposed outright bans on Russian oil purchases following Moscow's invasion of Ukraine, but members of the European Union are split.EU foreign ministers failed to agree on Monday on sanctioning Russian gas and oil supplies, which account for 40% and 27% of the bloc's total use of those commodities respectively.Germany, the EU's top user of Russian crude oil and the Netherlands, a key trading hub, argue that the EU couldn't cut its dependence on Russian supplies overnight.",
                        fontSize = 12.sp, fontWeight = FontWeight(500), lineHeight = 15.sp, color = colors.secondaryText)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Text("Read more ...",
                            fontSize = 12.sp, fontWeight = FontWeight(700), lineHeight = 15.sp, color = colors.tertiaryText)
                    }
                }
                }

            }

        }

    }
}

@Preview
@Composable
fun DetailsRreview(){
    Details(onNavigateTo = {})
}