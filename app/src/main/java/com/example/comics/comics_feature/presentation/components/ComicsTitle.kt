package com.example.comics.comics_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComicsTitle(
    title: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .widthIn(max = 100.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            fontSize = 12.sp,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun ComicsPreview() {
    ComicsTitle(
        title = "Título",
        modifier = Modifier
    )
}