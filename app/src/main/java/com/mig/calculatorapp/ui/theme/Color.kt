package com.mig.calculatorapp.ui.theme

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ButtonNumbers = "#FFA10A".toColor()
val ButtonOps = "#0D1321".toColor()
val ButtonsDels = "#1D2D44".toColor()