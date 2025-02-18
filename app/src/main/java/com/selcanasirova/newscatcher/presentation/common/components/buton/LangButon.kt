package com.selcanasirova.newscatcher.presentation.common.components.buton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun LangBtn(){
    val colors = LocalCustomColors.current
    Box(modifier = Modifier.width(75.dp).height(26.dp).clip(RoundedCornerShape(16.dp)).background(color = colors.secondaryBackground), contentAlignment = Alignment.Center){
        Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text("EN",
                fontSize = 11.sp, fontWeight = FontWeight(500), lineHeight = 13.sp, color = colors.primaryText
            )
            Box(modifier = Modifier.size(16.dp).clip(RoundedCornerShape(50.dp)).background(color = colors.tertiaryBackground), contentAlignment = Alignment.Center){
                Box(modifier = Modifier.size(10.dp).clip(RoundedCornerShape(50.dp)).background(color = colors.primaryIcon)) {  }
            }
        }
    }
}

@Preview
@Composable
fun LangBtnPreview(){
    LangBtn()
}
