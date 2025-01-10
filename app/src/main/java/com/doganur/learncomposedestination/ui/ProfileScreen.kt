package com.doganur.learncomposedestination.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

@Destination()
@Composable
fun ProfileScreen(
    id: Int,
    name: String? = null,
) {
    Text(
        text = "Profile Screen $id $name"
    )
}