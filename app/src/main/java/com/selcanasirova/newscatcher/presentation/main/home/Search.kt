package com.selcanasirova.newscatcher.presentation.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable

fun Search(){
    val colors= LocalCustomColors.current
    var text by remember { mutableStateOf("") }
    TextField(modifier = Modifier.fillMaxWidth()
        .border(1.dp, color = colors.primaryBorder, shape = RoundedCornerShape(16.dp))
        .background(color = colors.primaryBackground),
        value = text,
        onValueChange = {text+it},
        placeholder = {
            Text(
                "Search...",
                fontSize = 11.sp, fontWeight = FontWeight(500), lineHeight = 13.sp, color =colors.primaryBorder
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colors.primaryBackground,
            focusedContainerColor = colors.primaryBackground,
            unfocusedIndicatorColor = colors.primaryBackground,
            focusedIndicatorColor = colors.primaryBackground
        )
    )
}

@Preview
@Composable
fun SearchPreview(){
    Search()
}