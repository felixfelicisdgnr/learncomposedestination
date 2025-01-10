package com.doganur.learncomposedestination.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.doganur.learncomposedestination.ui.destinations.GoToProfileConfirmationDestination
import com.doganur.learncomposedestination.ui.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient

@Destination(start = true)
@Composable
fun HomeScreen(
    destinationsNavigator: DestinationsNavigator,
    resultRecipient: ResultRecipient<GoToProfileConfirmationDestination, Boolean> //HomeScreen'de GoToProfileConfirmationDestination'dan dönen veriyi almak için kullanılıyor
) {
    resultRecipient.onNavResult { result -> // Handle the result from the confirmation dialog
        when (result) {
            is NavResult.Canceled -> {
            }

            is NavResult.Value -> {
                if (result.value) {
                    destinationsNavigator.navigate(
                        ProfileScreenDestination(
                            id = 1,
                            name = "Doganur"
                        )
                    ) // Navigate to the ProfileScreen
                } else {
                    println("Navigation to ProfileScreen was canceled by the user.")
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Home Screen",
            fontSize = 24.sp
            )

        Button(
            onClick = {
                destinationsNavigator.navigate(GoToProfileConfirmationDestination) // Navigate to the confirmation dialog
            }
        ) {
            Text(
                text = "Go to Profile Screen",
                fontSize = 16.sp
            )
        }
    }
}
