package com.selcanasirova.newscatcher.presentation.common.components.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.selcanasirova.newscatcher.R
import com.selcanasirova.newscatcher.presentation.common.theme.LocalCustomColors

@Composable
fun NavBar() {
    val colors = LocalCustomColors.current
    val backgroundColor = colors.primaryBackground
    val borderColor = colors.primaryText

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .drawBehind {
                drawLine(
                    color = borderColor,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 3.dp.toPx()
                )
            },
        containerColor = backgroundColor
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(R.drawable.home_icon), contentDescription = "Home", modifier = Modifier.size(35.dp)) },
            selected = true,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
        )
        NavigationBarItem(
            icon = { Icon(painterResource(R.drawable.save_icon), contentDescription = "Saved", modifier = Modifier.size(35.dp)) },
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
        )
    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    NavBar()
}
