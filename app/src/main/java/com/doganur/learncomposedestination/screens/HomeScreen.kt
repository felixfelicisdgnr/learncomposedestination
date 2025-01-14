package com.doganur.learncomposedestination.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.doganur.learncomposedestination.screens.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(start = true)
@Composable
fun HomeScreen(
    destinationsNavigator: DestinationsNavigator
) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")

        TextField(
            value = name,
            onValueChange = {
                name = it
                showError = false
            },
            label = { Text("Enter your name") }
        )

        TextField(
            value = surname,
            onValueChange = {
                surname = it
                showError = false
            },
            label = { Text("Enter your surname") }
        )

        if (showError) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Please fill in all fields",
                color = Color.Red,
            )
        }

        Button(
            onClick = {
                if (name.isBlank() || surname.isBlank()) {
                    showError = true
                } else {
                    destinationsNavigator.navigate(ProfileScreenDestination(name = name, surname = surname))
                }
            }
        ) {
            Text(
                text = "Go to Profile Screen"
            )
        }
    }
}



