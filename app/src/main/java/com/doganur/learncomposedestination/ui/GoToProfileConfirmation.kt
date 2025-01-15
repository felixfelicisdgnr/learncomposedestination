package com.doganur.learncomposedestination.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator

@Destination(style = MyDialogStyle::class)
@Composable
fun GoToProfileConfirmation(
    resultNavigator: ResultBackNavigator<Boolean> //Dialogdan geri veri döndürmek için kullanılıyor
) {
    AlertDialog(
        onDismissRequest = {
            resultNavigator.navigateBack(result = false)
        },
        title = {
            Text(text = "Confirm Navigation")
        },
        text = {
            Text("Are you sure you want to go to the Profile Screen?")
        },
        confirmButton = {
            Button(
                onClick = {
                    resultNavigator.navigateBack(result = true)
                }
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    resultNavigator.navigateBack(result = false)
                }
            ) {
                Text("No")
            }
        }
    )
}






















