package com.doganur.learncomposedestination.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination

@Destination()
@Composable
fun ProfileScreen(
    name: String,
    surname: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Screen")

        Text(
            text = "Name: $name",
            fontSize = 20.sp,
            color = Color.Red
        )

        Text(
            text = "Surname: $surname",
            fontSize = 20.sp,
            color = Color.Blue
        )
    }
}