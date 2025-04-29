package org.example.project.themes

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Indigo = Color(0xFF3F51B5)
val Orange = Color(0xFFFF9800)
val LightGray = Color(0xFFFAFAFA)
val DeepRed = Color(0xFFD32F2F)
val TextPrimary = Color(0xFF212121)
val TextSecondary = Color(0xFF757575)

val AppLightColors = lightColors(
    primary = Indigo,
    primaryVariant = Indigo,
    secondary = Orange,
    background = LightGray,
    surface = Color.White,
    error = DeepRed,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onError = Color.White
)
