package com.doganur.learncomposedestination.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.learncomposedestination.ui.destinations.GoToProfileConfirmationDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient

@Destination(start = true)
@Composable
fun HomeScreen(
    destinationsNavigator: DestinationsNavigator,
    resultRecipient: ResultRecipient<GoToProfileConfirmationDestination, String> // HomeScreen'de GoToProfileConfirmationDestination'dan dönen veriyi almak için kullanılıyor
) {
    var name by remember { mutableStateOf("") }

    resultRecipient.onNavResult { result -> // Handle the result from the confirmation dialog
        when (result) {
            is NavResult.Canceled -> {
                println("Navigation to ProfileScreen was canceled by the user.")
            }

            is NavResult.Value -> {
                if (result.value.isNotEmpty()) {
                    name = result.value
                } else {
                    println("No name provided by the user.")
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Home Screen",
                fontSize = 24.sp
            )

            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name!",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            Button(
                onClick = {
                    destinationsNavigator.navigate(GoToProfileConfirmationDestination) // Navigate to the confirmation dialog
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Enter Your Name",
                    fontSize = 16.sp
                )
            }
        }
    }
}
