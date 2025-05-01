package org.example.project.themes


import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val BrightOrange = Color(0xFFF4511E)
val DarkOrangeShadow = Color(0xFFBF360C)
val SoftWhite = Color(0xFFFFFFFF)
val LightLineGray = Color(0xFFEEEEEE)

// Text and error colors
val DeepRed = Color(0xFFD32F2F)
val TextPrimary = Color(0xFF212121)
val TextSecondary = Color(0xFF757575)

val AppLightColors = lightColors(
    primary = BrightOrange,
    primaryVariant = DarkOrangeShadow,
    secondary = BrightOrange,
    background = SoftWhite,
    surface = SoftWhite,
    error = DeepRed,
    onPrimary = SoftWhite,
    onSecondary = SoftWhite,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onError = SoftWhite
)
