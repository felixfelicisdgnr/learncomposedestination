package com.doganur.learncomposedestination.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator

@Destination()
@Composable
fun ProfileScreen(
    name: String,
    surname: String,
    resultNavigator : ResultBackNavigator<Int>
) {
    var age by remember { mutableStateOf("0") }
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

        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Enter your age") }
        )

        Button(
            onClick = {
                val ageInt = age.toIntOrNull()
                if (ageInt != null) {
                    resultNavigator.navigateBack(ageInt)
                }
            }
        ) {
            Text("Go back")
        }
    }
}