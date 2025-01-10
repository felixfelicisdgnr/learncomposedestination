package com.doganur.learncomposedestination.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.doganur.learncomposedestination.ui.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    destinationsNavigator : DestinationsNavigator
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")

        Button(
            onClick = {
              destinationsNavigator.navigate(ProfileScreenDestination(1, "Doganur"))
            }
        ) {
            Text(
                text = "Go to Profile Screen"
            )
        }
    }
}