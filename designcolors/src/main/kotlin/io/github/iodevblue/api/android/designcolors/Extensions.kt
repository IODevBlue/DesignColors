package io.github.iodevblue.api.android.designcolors

import androidx.annotation.ColorInt
import androidx.annotation.ColorLong
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

/**
 * Converts an Android [ColorInt] (Int) to a Jetpack Compose [Color].
 *
 * Example usage:
 * ```kotlin
 * val composeColor = androidColorInt.toComposeColor()
 * ```
 *
 * @receiver An Android color represented as an [Int] ([ColorInt]).
 * @return A Jetpack Compose [Color] equivalent of the provided Android color.
 */
@ColorInt
fun Int.toComposeColor(): Color {
    return Color(this)
}

/**
 * Converts a packed ARGB color represented as [Long] to a Jetpack Compose [Color].
 *
 * Example usage:
 * ```kotlin
 * val composeColor = androidColorLong.toComposeColor()
 * ```
 *
 * @receiver A packed ARGB color value as a [Long].
 * @return A Jetpack Compose [Color] equivalent of the provided ARGB [Long] color.
 */
@ColorLong
fun Long.toComposeColor(): Color {
    return Color(this)
}

/**
 * Converts a Jetpack Compose [Color] to an Android [ColorInt] (Int).
 *
 * Example usage:
 * ```kotlin
 * val androidColorInt = composeColor.toColorInt()
 * ```
 *
 * @receiver The Jetpack Compose [Color] to convert.
 * @return A packed ARGB color as an [Int], usable in the Android view system.
 */
fun Color.toColorInt(): Int {
    return this.toArgb()
}
