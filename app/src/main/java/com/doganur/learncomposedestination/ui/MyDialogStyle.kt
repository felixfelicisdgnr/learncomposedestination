package com.doganur.learncomposedestination.ui

import androidx.compose.ui.window.DialogProperties
import com.ramcosta.composedestinations.spec.DestinationStyle

object MyDialogStyle : DestinationStyle.Dialog{
    override val properties: DialogProperties
        get() = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
}