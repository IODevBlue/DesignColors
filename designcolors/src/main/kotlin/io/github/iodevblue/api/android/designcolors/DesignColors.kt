package io.github.iodevblue.api.android.designcolors

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.toArgb

/**
 * A comprehensive Singleton object providing access to a wide range of predefined color palettes
 * from major design systems and popular brands. This utility is ideal for ensuring design consistency
 * and implementing established design language standards in applications.
 *
 * It includes color definitions for: *
 * - Material Design Colors specified in the [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation).
 * - **Flat UI**: A popular, vibrant color palette used widely in web design. Access the official palettes [here](https://flatuicolors.com/).
 * - **Apple Human Interface Guidelines**: The official color standards for iOS, macOS, and other Apple platforms. See the guidelines [here](https://developer.apple.com/design/human-interface-guidelines/foundations/color).
 * - **Atlassian Design System**: The official color guidelines used in products like Jira and Confluence. Explore the colors [here](https://atlassian.design/foundations/color/).
 * - **Bootstrap**: The color variables and themes from the world's most popular front-end toolkit. Find the color docs [here](https://getbootstrap.com/docs/5.3/customize/color/).
 * - **Microsoft Fluent UI**: The core color system for Microsoft's cross-platform design language. The color definitions are available [here](https://developer.microsoft.com/en-us/fluentui#/styles/web/colors).
 * - **Curated Brand Colors**: A collection of official colors from various mainstream companies.
 *
 *
 * @author IO DevBlue
 * @since 1.0.0
 */
object DesignColors {

    /** Utility class for the [DesignColors] library. */
    object Util {

        /**
         * Convert an Android [androidx.annotation.ColorInt] to a Jetpack Compose [Color][androidx.compose.ui.graphics.Color].
         * @param color An Android color represented as an [Int].
         * @return A Jetpack Compose [Color][androidx.compose.ui.graphics.Color] equivalent of the provided [androidx.annotation.ColorInt].
         */
        @JvmStatic
        fun toComposeColor(@androidx.annotation.ColorInt color: Int): androidx.compose.ui.graphics.Color {
            return androidx.compose.ui.graphics.Color(color)
        }

        /**
         * Convert a packed ARGB color represented as [Long] to a Jetpack Compose [android.graphics.Color].
         *
         * @param color A packed ARGB color value as a [Long].
         * @return A Jetpack Compose [androidx.compose.ui.graphics.Color] equivalent of the provided [Long] color.
         */
        @JvmStatic
        fun toComposeColor(color: Long): androidx.compose.ui.graphics.Color {
            return androidx.compose.ui.graphics.Color(color)
        }

        /**
         * Converts a Jetpack Compose [Color][androidx.compose.ui.graphics.Color] to an Android Color Int.
         *
         * @param color The [androidx.compose.ui.graphics.Color] to convert.
         * @return A packed ARGB color as an [Int], usable in the Android view system.
         */
        @JvmStatic
        @androidx.annotation.ColorInt
        fun fromComposeColor(color: androidx.compose.ui.graphics.Color): Int {
            return color.toArgb()
        }

        /**
         * Adds transparency to the provided [color] using an alpha value from 0–255.
         *
         * @param color The color to which an alpha value will be added.
         * @param alphaValue The alpha value as an [Int]. Range: `0` (fully transparent) to `255` (fully opaque).
         * @return A color [Int] with the provided alpha value applied.
         */
        @JvmStatic
        fun addAlpha(@androidx.annotation.ColorInt color: Int, @androidx.annotation.IntRange(from = 0, to = 255) alphaValue: Int): Int =
            _root_ide_package_.android.graphics.Color.argb(alphaValue, _root_ide_package_.android.graphics.Color.red(color), _root_ide_package_.android.graphics.Color.green(color), _root_ide_package_.android.graphics.Color.blue(color))

        /**
         * Adds transparency to the provided [color] using an alpha value from 0F–1F.
         *
         * @param color The color to which an alpha value will be added.
         * @param alphaValue The alpha value as a [Float]. Range: `0F` (fully transparent) to `1F` (fully opaque).
         * Values outside this range will be coerced into it.
         * @return A color [Int] with the provided alpha value applied.
         */
        @JvmStatic
        fun addAlpha(@androidx.annotation.ColorInt color: Int, @androidx.annotation.FloatRange(from = 0.0, to = 1.0) alphaValue: Float): Int {
            val alpha = (alphaValue * 255).toInt().coerceIn(0, 255)
            return _root_ide_package_.android.graphics.Color.argb(alpha, _root_ide_package_.android.graphics.Color.red(color), _root_ide_package_.android.graphics.Color.green(color), _root_ide_package_.android.graphics.Color.blue(color))
        }

        /**
         * Validates if the given color is a light or dark color.
         *
         * @param color The color whose brightness should be determined.
         * @return `true` if [color] is a dark color, `false` if otherwise.
         */
        @JvmStatic fun isDarkColor(color: Int): Boolean {
            val darkness = (1 - (0.2126 * _root_ide_package_.android.graphics.Color.red(color) + 0.7152 * _root_ide_package_.android.graphics.Color.green(color) + 0.0722 * _root_ide_package_.android.graphics.Color.blue(color)) / 255 * (_root_ide_package_.android.graphics.Color.alpha(color) / 255))
            return darkness >= 0.5
        }

        /**
         * Separates the RGB values of a color integer.
         *
         * @param color The color integer.,
         * @return An [IntArray] containing the RGB values in this order: {red, green, blue}.
         */
        @JvmStatic fun getRGB(@androidx.annotation.ColorInt color: Int): IntArray {
            val red = (color shr 16) and 0xFF
            val green = (color shr 8) and 0xFF
            val blue = color and 0xFF
            return intArrayOf(red, green, blue)
        }

        /**
         * Creates a color from the provided [red], [green] and [blue] values.
         * @param red The **RED** component
         * @param green The **GREEN** component
         * @param blue The **BLUE** component
         * @return A color [Int].
         */
        @JvmStatic fun createColor(
            @androidx.annotation.IntRange(from = 0, to = 255) red: Int,
            @androidx.annotation.IntRange(from = 0, to = 255) green: Int,
            @androidx.annotation.IntRange(from = 0, to = 255) blue: Int
        ):  Int {
            return (red shl 16) or (green shl 8) or blue
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // DESIGN SYSTEMS
    ///////////////////////////////////////////////////////////////////////////
    /** The Material Design color system helps you apply color to your UI in a meaningful way. */
    object MaterialDesign {

        @androidx.annotation.ColorInt
        @JvmStatic val RED_50 = _root_ide_package_.android.graphics.Color.rgb(255, 235, 238)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_100 = _root_ide_package_.android.graphics.Color.rgb(255, 205, 210)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_200 = _root_ide_package_.android.graphics.Color.rgb(239, 154, 154)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_300 = _root_ide_package_.android.graphics.Color.rgb(229, 115, 115)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_400 = _root_ide_package_.android.graphics.Color.rgb(239, 83, 80)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_500 = _root_ide_package_.android.graphics.Color.rgb(244, 67, 54)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_600 = _root_ide_package_.android.graphics.Color.rgb(229, 57, 53)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_700 = _root_ide_package_.android.graphics.Color.rgb(211, 47, 47)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_800 = _root_ide_package_.android.graphics.Color.rgb(198, 40, 40)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_900 = _root_ide_package_.android.graphics.Color.rgb(183, 28, 28)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 138, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 82, 82)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_A400 = _root_ide_package_.android.graphics.Color.rgb(255, 23, 68)
        @androidx.annotation.ColorInt
        @JvmStatic val RED_A700 = _root_ide_package_.android.graphics.Color.rgb(213, 0, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val PINK_50 = _root_ide_package_.android.graphics.Color.rgb(252, 228, 236)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_100 = _root_ide_package_.android.graphics.Color.rgb(248, 187, 208)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_200 = _root_ide_package_.android.graphics.Color.rgb(244, 143, 177)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_300 = _root_ide_package_.android.graphics.Color.rgb(240, 98, 146)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_400 = _root_ide_package_.android.graphics.Color.rgb(236, 64, 122)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_500 = _root_ide_package_.android.graphics.Color.rgb(233, 30, 99)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_600 = _root_ide_package_.android.graphics.Color.rgb(216, 27, 91)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_700 = _root_ide_package_.android.graphics.Color.rgb(194, 24, 91)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_800 = _root_ide_package_.android.graphics.Color.rgb(173, 20, 87)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_900 = _root_ide_package_.android.graphics.Color.rgb(136, 14, 79)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 128, 171)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 64, 129)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_A400 = _root_ide_package_.android.graphics.Color.rgb(245, 0, 87)
        @androidx.annotation.ColorInt
        @JvmStatic val PINK_A700 = _root_ide_package_.android.graphics.Color.rgb(197, 17, 98)

        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_50 = _root_ide_package_.android.graphics.Color.rgb(243, 229, 245)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_100 = _root_ide_package_.android.graphics.Color.rgb(225, 190, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_200 = _root_ide_package_.android.graphics.Color.rgb(206, 147, 216)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_300 = _root_ide_package_.android.graphics.Color.rgb(186, 104,200)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_400 = _root_ide_package_.android.graphics.Color.rgb(171, 71, 188)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_500 = _root_ide_package_.android.graphics.Color.rgb(156, 39, 176)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_600 = _root_ide_package_.android.graphics.Color.rgb(142, 36, 170)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_700 = _root_ide_package_.android.graphics.Color.rgb(123, 31, 162)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_800 = _root_ide_package_.android.graphics.Color.rgb(106, 27, 154)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_900 = _root_ide_package_.android.graphics.Color.rgb(74, 20, 140)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_A100 = _root_ide_package_.android.graphics.Color.rgb(234, 128, 252)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_A200 = _root_ide_package_.android.graphics.Color.rgb(224, 64, 251)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_A400 = _root_ide_package_.android.graphics.Color.rgb(213, 0, 249)
        @androidx.annotation.ColorInt
        @JvmStatic val PURPLE_A700 = _root_ide_package_.android.graphics.Color.rgb(170, 0, 255)

        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_50 = _root_ide_package_.android.graphics.Color.rgb(237, 231, 246)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_100 = _root_ide_package_.android.graphics.Color.rgb(209, 196, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_200 = _root_ide_package_.android.graphics.Color.rgb(179, 157, 219)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_300 = _root_ide_package_.android.graphics.Color.rgb(149, 117, 205)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_400 = _root_ide_package_.android.graphics.Color.rgb(126, 87, 194)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_500 = _root_ide_package_.android.graphics.Color.rgb(103, 58, 183)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_600 = _root_ide_package_.android.graphics.Color.rgb(94, 53, 177)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_700 = _root_ide_package_.android.graphics.Color.rgb(81, 45, 168)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_800 = _root_ide_package_.android.graphics.Color.rgb(69, 39, 160)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_900 = _root_ide_package_.android.graphics.Color.rgb(49, 27, 146)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_A100 = _root_ide_package_.android.graphics.Color.rgb(179, 136, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_A200 = _root_ide_package_.android.graphics.Color.rgb(124, 77, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_A400 = _root_ide_package_.android.graphics.Color.rgb(101, 31, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_PURPLE_A700 = _root_ide_package_.android.graphics.Color.rgb(98, 0, 234)

        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_50 = _root_ide_package_.android.graphics.Color.rgb(232, 234, 246)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_100 = _root_ide_package_.android.graphics.Color.rgb(197, 202, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_200 = _root_ide_package_.android.graphics.Color.rgb(159, 168, 218)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_300 = _root_ide_package_.android.graphics.Color.rgb(121, 134, 203)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_400 = _root_ide_package_.android.graphics.Color.rgb(92, 107, 192)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_500 = _root_ide_package_.android.graphics.Color.rgb(63, 81, 181)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_600 = _root_ide_package_.android.graphics.Color.rgb(57, 73, 171)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_700 = _root_ide_package_.android.graphics.Color.rgb(48, 63, 159)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_800 = _root_ide_package_.android.graphics.Color.rgb(40, 53, 147)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_900 = _root_ide_package_.android.graphics.Color.rgb(26, 35, 126)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_A100 = _root_ide_package_.android.graphics.Color.rgb(140, 158, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_A200 = _root_ide_package_.android.graphics.Color.rgb(83, 109, 254)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_A400 = _root_ide_package_.android.graphics.Color.rgb(61, 90, 254)
        @androidx.annotation.ColorInt
        @JvmStatic val INDIGO_A700 = _root_ide_package_.android.graphics.Color.rgb(48, 79, 254)

        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_50 = _root_ide_package_.android.graphics.Color.rgb(227, 242, 253)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_100 = _root_ide_package_.android.graphics.Color.rgb(187, 222, 251)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_200 = _root_ide_package_.android.graphics.Color.rgb(144, 202, 249)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_300 = _root_ide_package_.android.graphics.Color.rgb(100, 181, 246)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_400 = _root_ide_package_.android.graphics.Color.rgb(66, 165, 245)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_500 = _root_ide_package_.android.graphics.Color.rgb(33, 150, 243)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_600 = _root_ide_package_.android.graphics.Color.rgb(30, 136, 229)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_700 = _root_ide_package_.android.graphics.Color.rgb(25, 118, 210)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_800 = _root_ide_package_.android.graphics.Color.rgb(21, 101, 192)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_900 = _root_ide_package_.android.graphics.Color.rgb(13, 71, 161)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_A100 = _root_ide_package_.android.graphics.Color.rgb(130, 177, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_A200 = _root_ide_package_.android.graphics.Color.rgb(68, 138, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_A400 = _root_ide_package_.android.graphics.Color.rgb(41, 121, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_A700 = _root_ide_package_.android.graphics.Color.rgb(41, 98, 255)

        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_50 = _root_ide_package_.android.graphics.Color.rgb(225, 245, 254)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_100 = _root_ide_package_.android.graphics.Color.rgb(179, 229, 252)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_200 = _root_ide_package_.android.graphics.Color.rgb(129, 212, 250)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_300 = _root_ide_package_.android.graphics.Color.rgb(79, 195, 247)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_400 = _root_ide_package_.android.graphics.Color.rgb(41, 182, 246)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_500 = _root_ide_package_.android.graphics.Color.rgb(3, 169, 244)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_600 = _root_ide_package_.android.graphics.Color.rgb(3, 155, 229)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_700 = _root_ide_package_.android.graphics.Color.rgb(2, 136, 209)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_800 = _root_ide_package_.android.graphics.Color.rgb(2, 119, 189)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_900 = _root_ide_package_.android.graphics.Color.rgb(1, 87, 155)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_A100 = _root_ide_package_.android.graphics.Color.rgb(128, 216, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_A200 = _root_ide_package_.android.graphics.Color.rgb(64, 196, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_A400 = _root_ide_package_.android.graphics.Color.rgb(0, 176, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_BLUE_A700 = _root_ide_package_.android.graphics.Color.rgb(0, 145, 234)

        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_50 = _root_ide_package_.android.graphics.Color.rgb(224, 247, 250)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_100 = _root_ide_package_.android.graphics.Color.rgb(178, 235, 242)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_200 = _root_ide_package_.android.graphics.Color.rgb(128, 222, 234)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_300 = _root_ide_package_.android.graphics.Color.rgb(77, 208, 225)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_400 = _root_ide_package_.android.graphics.Color.rgb(38, 198, 218)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_500 = _root_ide_package_.android.graphics.Color.rgb(0, 188, 212)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_600 = _root_ide_package_.android.graphics.Color.rgb(0, 172, 193)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_700 = _root_ide_package_.android.graphics.Color.rgb(0, 151, 167)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_800 = _root_ide_package_.android.graphics.Color.rgb(0, 131, 143)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_900 = _root_ide_package_.android.graphics.Color.rgb(0, 96, 100)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_A100 = _root_ide_package_.android.graphics.Color.rgb(133, 255, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_A200 = _root_ide_package_.android.graphics.Color.rgb(24, 255, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_A400 = _root_ide_package_.android.graphics.Color.rgb(0, 229, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val CYAN_A700 = _root_ide_package_.android.graphics.Color.rgb(0, 184, 212)

        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_50 = _root_ide_package_.android.graphics.Color.rgb(224, 242, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_100 = _root_ide_package_.android.graphics.Color.rgb(178, 223, 219)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_200 = _root_ide_package_.android.graphics.Color.rgb(128, 203, 196)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_300 = _root_ide_package_.android.graphics.Color.rgb(77, 182, 172)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_400 = _root_ide_package_.android.graphics.Color.rgb(38, 166, 154)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_500 = _root_ide_package_.android.graphics.Color.rgb(0, 150, 136)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_600 = _root_ide_package_.android.graphics.Color.rgb(0, 137, 123)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_700 = _root_ide_package_.android.graphics.Color.rgb(0, 121, 107)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_800 = _root_ide_package_.android.graphics.Color.rgb(0, 105, 92)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_900 = _root_ide_package_.android.graphics.Color.rgb(0, 77, 64)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_A100 = _root_ide_package_.android.graphics.Color.rgb(167, 255, 235)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_A200 = _root_ide_package_.android.graphics.Color.rgb(100, 255, 218)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_A400 = _root_ide_package_.android.graphics.Color.rgb(29, 233, 182)
        @androidx.annotation.ColorInt
        @JvmStatic val TEAL_A700 = _root_ide_package_.android.graphics.Color.rgb(0, 191, 165)

        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_50 = _root_ide_package_.android.graphics.Color.rgb(232, 245, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_100 = _root_ide_package_.android.graphics.Color.rgb(200, 230, 201)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_200 = _root_ide_package_.android.graphics.Color.rgb(165, 214, 167)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_300 = _root_ide_package_.android.graphics.Color.rgb(129, 199, 132)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_400 = _root_ide_package_.android.graphics.Color.rgb(102, 187, 106)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_500 = _root_ide_package_.android.graphics.Color.rgb(76, 175, 80)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_600 = _root_ide_package_.android.graphics.Color.rgb(67, 160, 71)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_700 = _root_ide_package_.android.graphics.Color.rgb(56, 142, 60)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_800 = _root_ide_package_.android.graphics.Color.rgb(46, 125, 50)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_900 = _root_ide_package_.android.graphics.Color.rgb(27, 94, 32)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_A100 = _root_ide_package_.android.graphics.Color.rgb(185, 246, 202)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_A200 = _root_ide_package_.android.graphics.Color.rgb(105, 240, 174)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_A400 = _root_ide_package_.android.graphics.Color.rgb(0, 230, 118)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_A700 = _root_ide_package_.android.graphics.Color.rgb(0, 200, 83)

        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_50 = _root_ide_package_.android.graphics.Color.rgb(241, 248, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_100 = _root_ide_package_.android.graphics.Color.rgb(220, 237, 200)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_200 = _root_ide_package_.android.graphics.Color.rgb(197, 225, 165)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_300 = _root_ide_package_.android.graphics.Color.rgb(174, 213, 219)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_400 = _root_ide_package_.android.graphics.Color.rgb(156, 204, 101)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_500 = _root_ide_package_.android.graphics.Color.rgb(139, 195, 74)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_600 = _root_ide_package_.android.graphics.Color.rgb(124, 179, 66)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_700 = _root_ide_package_.android.graphics.Color.rgb(104, 159, 56)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_800 = _root_ide_package_.android.graphics.Color.rgb(85, 139, 47)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_900 = _root_ide_package_.android.graphics.Color.rgb(51, 105, 30)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_A100 = _root_ide_package_.android.graphics.Color.rgb(204, 255, 144)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_A200 = _root_ide_package_.android.graphics.Color.rgb(178, 255, 89)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_A400 = _root_ide_package_.android.graphics.Color.rgb(118, 255, 3)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT_GREEN_A700 = _root_ide_package_.android.graphics.Color.rgb(100, 221, 23)

        @androidx.annotation.ColorInt
        @JvmStatic val LIME_50 = _root_ide_package_.android.graphics.Color.rgb(249, 251, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_100 = _root_ide_package_.android.graphics.Color.rgb(240, 244, 195)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_200 = _root_ide_package_.android.graphics.Color.rgb(230, 238, 156)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_300 = _root_ide_package_.android.graphics.Color.rgb(220, 231, 117)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_400 = _root_ide_package_.android.graphics.Color.rgb(212, 225, 87)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_500 = _root_ide_package_.android.graphics.Color.rgb(205, 220, 57)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_600 = _root_ide_package_.android.graphics.Color.rgb(192, 202, 51)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_700 = _root_ide_package_.android.graphics.Color.rgb(175, 180, 43)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_800 = _root_ide_package_.android.graphics.Color.rgb(158, 157, 36)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_900 = _root_ide_package_.android.graphics.Color.rgb(130, 119, 23)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_A100 = _root_ide_package_.android.graphics.Color.rgb(244, 255, 129)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_A200 = _root_ide_package_.android.graphics.Color.rgb(238, 255, 65)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_A400 = _root_ide_package_.android.graphics.Color.rgb(198, 255, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val LIME_A700 = _root_ide_package_.android.graphics.Color.rgb(174, 234, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_50 = _root_ide_package_.android.graphics.Color.rgb(255, 253, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_100 = _root_ide_package_.android.graphics.Color.rgb(255, 249, 196)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_200 = _root_ide_package_.android.graphics.Color.rgb(255, 245, 157)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_300 = _root_ide_package_.android.graphics.Color.rgb(255, 241, 118)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_400 = _root_ide_package_.android.graphics.Color.rgb(255, 238, 88)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_500 = _root_ide_package_.android.graphics.Color.rgb(255, 235, 59)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_600 = _root_ide_package_.android.graphics.Color.rgb(253, 216, 53)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_700 = _root_ide_package_.android.graphics.Color.rgb(251, 192, 45)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_800 = _root_ide_package_.android.graphics.Color.rgb(249, 168, 37)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_900 = _root_ide_package_.android.graphics.Color.rgb(245, 127, 23)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 255, 130)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 255, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_A400 = _root_ide_package_.android.graphics.Color.rgb(255, 234, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val YELLOW_A700 = _root_ide_package_.android.graphics.Color.rgb(255, 214, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_50 = _root_ide_package_.android.graphics.Color.rgb(255, 248, 225)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_100 = _root_ide_package_.android.graphics.Color.rgb(255, 236, 179)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_200 = _root_ide_package_.android.graphics.Color.rgb(255, 224, 130)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_300 = _root_ide_package_.android.graphics.Color.rgb(255, 213, 79)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_400 = _root_ide_package_.android.graphics.Color.rgb(255, 202, 40)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_500 = _root_ide_package_.android.graphics.Color.rgb(255, 193, 7)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_600 = _root_ide_package_.android.graphics.Color.rgb(255, 179, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_700 = _root_ide_package_.android.graphics.Color.rgb(255, 160, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_800 = _root_ide_package_.android.graphics.Color.rgb(255, 143, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_900 = _root_ide_package_.android.graphics.Color.rgb(255, 111, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 229, 127)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 215, 64)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_A400 = _root_ide_package_.android.graphics.Color.rgb(255, 196, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val AMBER_A700 = _root_ide_package_.android.graphics.Color.rgb(255, 171, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_50 = _root_ide_package_.android.graphics.Color.rgb(255, 243 , 224)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_100 = _root_ide_package_.android.graphics.Color.rgb(255, 224, 178)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_200 = _root_ide_package_.android.graphics.Color.rgb(255, 204, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_300 = _root_ide_package_.android.graphics.Color.rgb(255, 183, 77)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_400 = _root_ide_package_.android.graphics.Color.rgb(255, 167, 38)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_500 = _root_ide_package_.android.graphics.Color.rgb(255, 152, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_600 = _root_ide_package_.android.graphics.Color.rgb(251, 140, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_700 = _root_ide_package_.android.graphics.Color.rgb(245, 124, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_800 = _root_ide_package_.android.graphics.Color.rgb(239, 108, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_900 = _root_ide_package_.android.graphics.Color.rgb(230, 81, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 209, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 171, 64)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_A400 = _root_ide_package_.android.graphics.Color.rgb(255, 145, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_A700 = _root_ide_package_.android.graphics.Color.rgb(255, 109, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_50 = _root_ide_package_.android.graphics.Color.rgb(251, 233, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_100 = _root_ide_package_.android.graphics.Color.rgb(255, 204, 188)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_200 = _root_ide_package_.android.graphics.Color.rgb(255, 171, 145)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_300 = _root_ide_package_.android.graphics.Color.rgb(255, 138, 101)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_400 = _root_ide_package_.android.graphics.Color.rgb(255, 112, 67)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_500 = _root_ide_package_.android.graphics.Color.rgb(255, 87, 34)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_600 = _root_ide_package_.android.graphics.Color.rgb(244, 81, 30)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_700 = _root_ide_package_.android.graphics.Color.rgb(230, 74, 25)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_800 = _root_ide_package_.android.graphics.Color.rgb(216, 67, 21)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_900 = _root_ide_package_.android.graphics.Color.rgb(191, 54, 12)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_A100 = _root_ide_package_.android.graphics.Color.rgb(255, 158, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_A200 = _root_ide_package_.android.graphics.Color.rgb(255, 110, 64)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_A400 = _root_ide_package_.android.graphics.Color.rgb(255, 61, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val DEEP_ORANGE_A700 = _root_ide_package_.android.graphics.Color.rgb(221, 44, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_50 = _root_ide_package_.android.graphics.Color.rgb(239, 235, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_100 = _root_ide_package_.android.graphics.Color.rgb(215, 204, 200)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_200 = _root_ide_package_.android.graphics.Color.rgb(188, 170, 164)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_300 = _root_ide_package_.android.graphics.Color.rgb(161, 136, 127)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_400 = _root_ide_package_.android.graphics.Color.rgb(141, 110, 99)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_500 = _root_ide_package_.android.graphics.Color.rgb(121, 85, 72)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_600 = _root_ide_package_.android.graphics.Color.rgb(109, 76, 65)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_700 = _root_ide_package_.android.graphics.Color.rgb(93, 64, 55)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_800 = _root_ide_package_.android.graphics.Color.rgb(78, 52, 46)
        @androidx.annotation.ColorInt
        @JvmStatic val BROWN_900 = _root_ide_package_.android.graphics.Color.rgb(62, 39, 35)

        @androidx.annotation.ColorInt
        @JvmStatic val GREY_50 = _root_ide_package_.android.graphics.Color.rgb(250, 250, 250)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_100 = _root_ide_package_.android.graphics.Color.rgb(245, 245, 245)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_200 = _root_ide_package_.android.graphics.Color.rgb(238, 238, 238)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_300 = _root_ide_package_.android.graphics.Color.rgb(224, 224, 224)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_400 = _root_ide_package_.android.graphics.Color.rgb(189, 189, 189)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_500 = _root_ide_package_.android.graphics.Color.rgb(158, 158, 158)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_600 = _root_ide_package_.android.graphics.Color.rgb(117, 117, 117)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_700 = _root_ide_package_.android.graphics.Color.rgb(97, 97, 97)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_800 = _root_ide_package_.android.graphics.Color.rgb(66, 66, 66)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY_900 = _root_ide_package_.android.graphics.Color.rgb(33, 33, 33)

        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_50 = _root_ide_package_.android.graphics.Color.rgb(236, 239, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_100 = _root_ide_package_.android.graphics.Color.rgb(207, 216, 220)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_200 = _root_ide_package_.android.graphics.Color.rgb(176, 190, 197)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_300 = _root_ide_package_.android.graphics.Color.rgb(144, 164, 174)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_400 = _root_ide_package_.android.graphics.Color.rgb(120, 144, 156)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_500 = _root_ide_package_.android.graphics.Color.rgb(96, 125, 139)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_600 = _root_ide_package_.android.graphics.Color.rgb(84, 110, 122)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_700 = _root_ide_package_.android.graphics.Color.rgb(69, 90, 100)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_800 = _root_ide_package_.android.graphics.Color.rgb(55, 71, 79)
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE_GREY_900 = _root_ide_package_.android.graphics.Color.rgb(38, 50, 56)

        @androidx.annotation.ColorInt
        @JvmStatic val WHITE = _root_ide_package_.android.graphics.Color.WHITE
        @androidx.annotation.ColorInt
        @JvmStatic val BLACK = _root_ide_package_.android.graphics.Color.BLACK

        /** An array containing all 14 Material RED colors. */
        @JvmStatic val redColorArray = intArrayOf(RED_50, RED_100, RED_200, RED_300, RED_400, RED_500, RED_600, RED_700, RED_800, RED_900, RED_A100, RED_A200, RED_A400, RED_A700)

        /** An array containing all 14 Material PINK colors. */
        @JvmStatic val pinkColorArray = intArrayOf(PINK_50, PINK_100, PINK_200, PINK_300, PINK_400, PINK_500, PINK_600, PINK_700, PINK_800, PINK_900, PINK_A100, PINK_A200, PINK_A400, PINK_A700)

        /** An array containing all 14 Material PURPLE colors. */
        @JvmStatic val purpleColorArray = intArrayOf(PURPLE_50, PURPLE_100, PURPLE_200, PURPLE_300, PURPLE_400, PURPLE_500, PURPLE_600, PURPLE_700, PURPLE_800, PURPLE_900, PURPLE_A100, PURPLE_A200, PURPLE_A400, PURPLE_A700)

        /** An array containing all 14 Material DEEP PURPLE colors. */
        @JvmStatic val deepPurpleColorArray = intArrayOf(DEEP_PURPLE_50, DEEP_PURPLE_100, DEEP_PURPLE_200, DEEP_PURPLE_300, DEEP_PURPLE_400, DEEP_PURPLE_500, DEEP_PURPLE_600, DEEP_PURPLE_700, DEEP_PURPLE_800, DEEP_PURPLE_900, DEEP_PURPLE_A100, DEEP_PURPLE_A200, DEEP_PURPLE_A400, DEEP_PURPLE_A700)

        /** An array containing all 14 Material INDIGO colors. */
        @JvmStatic val indigoColorArray = intArrayOf(INDIGO_50, INDIGO_100, INDIGO_200, INDIGO_300, INDIGO_400, INDIGO_500, INDIGO_600, INDIGO_700, INDIGO_800, INDIGO_900, INDIGO_A100, INDIGO_A200, INDIGO_A400, INDIGO_A700)

        /** An array containing all 14 Material BLUE colors. */
        @JvmStatic val blueColorArray = intArrayOf(BLUE_50, BLUE_100, BLUE_200, BLUE_300, BLUE_400, BLUE_500, BLUE_600, BLUE_700, BLUE_800, BLUE_900, BLUE_A100, BLUE_A200, BLUE_A400, BLUE_A700)

        /** An array containing all 14 Material LIGHT BLUE colors. */
        @JvmStatic val lightBlueColorArray = intArrayOf(LIGHT_BLUE_50, LIGHT_BLUE_100, LIGHT_BLUE_200, LIGHT_BLUE_300, LIGHT_BLUE_400, LIGHT_BLUE_500, LIGHT_BLUE_600, LIGHT_BLUE_700, LIGHT_BLUE_800, LIGHT_BLUE_900, LIGHT_BLUE_A100, LIGHT_BLUE_A200, LIGHT_BLUE_A400, LIGHT_BLUE_A700)

        /** An array containing all 14 Material  CYAN colors. */
        @JvmStatic val cyanColorArray = intArrayOf(CYAN_50, CYAN_100, CYAN_200, CYAN_300, CYAN_400, CYAN_500, CYAN_600, CYAN_700, CYAN_800, CYAN_900, CYAN_A100, CYAN_A200, CYAN_A400, CYAN_A700)

        /** An array containing all 14 Material TEAL colors. */
        @JvmStatic val tealColorArray = intArrayOf(TEAL_50, TEAL_100, TEAL_200, TEAL_300, TEAL_400, TEAL_500, TEAL_600, TEAL_700, TEAL_800, TEAL_900, TEAL_A100, TEAL_A200, TEAL_A400, TEAL_A700)

        /** An array containing all 14 Material GREEN colors. */
        @JvmStatic val greenColorArray = intArrayOf(GREEN_50, GREEN_100, GREEN_200, GREEN_300, GREEN_400, GREEN_500, GREEN_600, GREEN_700, GREEN_800, GREEN_900, GREEN_A100, GREEN_A200, GREEN_A400, GREEN_A700)

        /** An array containing all 14 Material LIGHT GREEN colors. */
        @JvmStatic val lightGreenColorArray = intArrayOf(LIGHT_GREEN_50, LIGHT_GREEN_100, LIGHT_GREEN_200, LIGHT_GREEN_300, LIGHT_GREEN_400, LIGHT_GREEN_500, LIGHT_GREEN_600, LIGHT_GREEN_700, LIGHT_GREEN_800, LIGHT_GREEN_900, LIGHT_GREEN_A100, LIGHT_GREEN_A200, LIGHT_GREEN_A400, LIGHT_GREEN_A700)

        /** An array containing all 14 Material LIME colors. */
        @JvmStatic val limeColorArray = intArrayOf(LIME_50, LIME_100, LIME_200, LIME_300, LIME_400, LIME_500, LIME_600, LIME_700, LIME_800, LIME_900, LIME_A100, LIME_A200, LIME_A400, LIME_A700)

        /**  An array containing all 14 Material YELLOW colors. */
        @JvmStatic val yellowColorArray = intArrayOf(YELLOW_50, YELLOW_100, YELLOW_200, YELLOW_300, YELLOW_400, YELLOW_500, YELLOW_600, YELLOW_700, YELLOW_800, YELLOW_900, YELLOW_A100, YELLOW_A200, YELLOW_A400, YELLOW_A700)

        /** An array containing all 14 Material AMBER colors. */
        @JvmStatic val amberColorArray = intArrayOf(AMBER_50, AMBER_100, AMBER_200, AMBER_300, AMBER_400, AMBER_500, AMBER_600, AMBER_700, AMBER_800, AMBER_900, AMBER_A100, AMBER_A200, AMBER_A400, AMBER_A700)

        /** An array containing all 14 Material ORANGE colors. */
        @JvmStatic val orangeColorArray = intArrayOf(ORANGE_50, ORANGE_100, ORANGE_200, ORANGE_300, ORANGE_400, ORANGE_500, ORANGE_600, ORANGE_700, ORANGE_800, ORANGE_900, ORANGE_A100, ORANGE_A200, ORANGE_A400, ORANGE_A700)

        /** An array containing all 14 Material DEEP ORANGE colors. */
        @JvmStatic val deepOrangeColorArray = intArrayOf(DEEP_ORANGE_50, DEEP_ORANGE_100, DEEP_ORANGE_200, DEEP_ORANGE_300, DEEP_ORANGE_400, DEEP_ORANGE_500, DEEP_ORANGE_600, DEEP_ORANGE_700, DEEP_ORANGE_800, DEEP_ORANGE_900, DEEP_ORANGE_A100, DEEP_ORANGE_A200, DEEP_ORANGE_A400, DEEP_ORANGE_A700)

        /** An array containing all 10 Material BROWN colors. */
        @JvmStatic val brownColorArray = intArrayOf(BROWN_50, BROWN_100, BROWN_200, BROWN_300, BROWN_400, BROWN_500, BROWN_600, BROWN_700, BROWN_800, BROWN_900)

        /** An array containing all 10 Material PINK colors. */
        @JvmStatic val greyColorArray = intArrayOf(GREY_50, GREY_100, GREY_200, GREY_300, GREY_400, GREY_500, GREY_600, GREY_700, GREY_800, GREY_900)

        /** An array containing all 10 Material BLUE GREY colors. */
        @JvmStatic val blueGreyColorArray = intArrayOf(BLUE_GREY_50, BLUE_GREY_100, BLUE_GREY_200, BLUE_GREY_300, BLUE_GREY_400, BLUE_GREY_500, BLUE_GREY_600, BLUE_GREY_700, BLUE_GREY_800, BLUE_GREY_900)

        private val arrayOfAllColorArrays = arrayOf(
            redColorArray, pinkColorArray, purpleColorArray, deepPurpleColorArray, indigoColorArray, blueColorArray,
            lightBlueColorArray, cyanColorArray, tealColorArray, greenColorArray, lightGreenColorArray, limeColorArray,
            yellowColorArray, amberColorArray, orangeColorArray, deepOrangeColorArray, brownColorArray, greyColorArray,
            blueGreyColorArray
        )

        /**
         * Gets a random shade of Material RED from the [Red Color Array][redColorArray].
         *
         * @return @[androidx.annotation.ColorInt] RED.
         */
        @JvmStatic fun randomRedColor() = redColorArray[(redColorArray.indices).random()]

        /**
         * Gets a random shade of Material PINK from the [Pink Color Array][pinkColorArray].
         *
         * @return @[androidx.annotation.ColorInt] PINK.
         */
        @JvmStatic fun randomPinkColor() = pinkColorArray[(pinkColorArray.indices).random()]

        /**
         * Gets a random shade of Material PURPLE from the [Purple Color Array][purpleColorArray].
         *
         * @return @[androidx.annotation.ColorInt] PURPLE.
         */
        @JvmStatic fun randomPurpleColor() = purpleColorArray[(purpleColorArray.indices).random()]

        /**
         * Gets a random shade of Material DEEP PURPLE from the [Deep Purple Color Array][deepPurpleColorArray].
         *
         * @return @[androidx.annotation.ColorInt] DEEP PURPLE.
         */
        @JvmStatic fun randomDeepPurpleColor() = deepPurpleColorArray[(deepPurpleColorArray.indices).random()]

        /**
         * Gets a random shade of Material INDIGO from the [Indigo Color Array][indigoColorArray].
         *
         * @return @[androidx.annotation.ColorInt] INDIGO.
         */
        @JvmStatic fun randomIndigoColor() = indigoColorArray[(indigoColorArray.indices).random()]

        /**
         * Gets a random shade of Material BLUE from the [Blue Color Array][blueColorArray].
         *
         * @return @[androidx.annotation.ColorInt] BLUE.
         */
        @JvmStatic fun randomBlueColor() = blueColorArray[(blueColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIGHT BLUE from the [Light Blue Color Array][lightBlueColorArray].
         *
         * @return @[androidx.annotation.ColorInt] LIGHT BLUE.
         */
        @JvmStatic fun randomLightBlueColor() = lightBlueColorArray[(lightBlueColorArray.indices).random()]

        /**
         * Gets a random shade of Material CYAN  from the [Cyan Color Array][cyanColorArray].
         *
         * @return @[androidx.annotation.ColorInt] CYAN.
         */
        @JvmStatic fun randomCyanColor() = cyanColorArray[(cyanColorArray.indices).random()]

        /**
         * Gets a random shade of Material TEAL from the [Teal Color Array][tealColorArray].
         *
         * @return @[androidx.annotation.ColorInt] TEAL.
         */
        @JvmStatic fun randomTealColor() = tealColorArray[(tealColorArray.indices).random()]

        /**
         * Gets a random shade of Material GREEN from the [Green Color Array][greenColorArray].
         *
         * @return @[androidx.annotation.ColorInt] GREEN.
         */
        @JvmStatic fun randomGreenColor() = greenColorArray[(greenColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIGHT GREEN from the [Light Green Color Array][lightGreenColorArray].
         *
         * @return @[androidx.annotation.ColorInt] LIGHT GREEN.
         */
        @JvmStatic fun randomLightGreenColor() = lightGreenColorArray[(lightGreenColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIME from the [Lime Color Array][limeColorArray].
         *
         * @return @[androidx.annotation.ColorInt] LIME.
         */
        @JvmStatic fun randomLimeColor() = limeColorArray[(limeColorArray.indices).random()]

        /**
         * Gets a random shade of Material YELLOW from the [Yellow Color Array][yellowColorArray].
         *
         * @return @[androidx.annotation.ColorInt] YELLOW.
         */
        @JvmStatic fun randomYellowColor() = yellowColorArray[(yellowColorArray.indices).random()]

        /**
         * Gets a random shade of Material AMBER from the [Amber Color Array][amberColorArray].
         *
         * @return @[androidx.annotation.ColorInt] AMBER.
         */
        @JvmStatic fun randomAmberColor() = amberColorArray[(amberColorArray.indices).random()]

        /**
         * Gets a random shade of Material ORANGE from the [Orange Color Array][orangeColorArray].
         *
         * @return @[androidx.annotation.ColorInt] ORANGE.
         */
        @JvmStatic fun randomOrangeColor() = orangeColorArray[(orangeColorArray.indices).random()]

        /**
         * Gets a random shade of Material DEEP ORANGE from the [Deep Orange Color Array][deepOrangeColorArray].
         *
         * @return @[androidx.annotation.ColorInt] DEEP ORANGE.
         */
        @JvmStatic fun randomDeepOrangeColor() = deepOrangeColorArray[(deepOrangeColorArray.indices).random()]

        /**
         * Gets a random shade of Material BROWN from the [Brown Color Array][brownColorArray].
         *
         * @return @[androidx.annotation.ColorInt] BROWN.
         */
        @JvmStatic fun randomBrownColor() = brownColorArray[(brownColorArray.indices).random()]

        /**
         * Gets a random shade of Material GREY from the [Grey Color Array][greyColorArray].
         *
         * @return @[androidx.annotation.ColorInt] GREY.
         */
        @JvmStatic fun randomGreyColor() = greyColorArray[(greyColorArray.indices).random()]

        /**
         * Gets a random shade of Material BLUE GREY from the [Blue Grey Color Array][blueGreyColorArray].
         *
         * @return @[androidx.annotation.ColorInt] BLUE GREY.
         */
        @JvmStatic fun randomBlueGreyColor() = blueGreyColorArray[(blueGreyColorArray.indices).random()]

        /**
         * Picks a random color from one of the [MaterialDesign] colors.
         *
         */
        @JvmStatic fun selectRandomColor(): Int {
            val anyColorIntArray = arrayOfAllColorArrays[(arrayOfAllColorArrays.indices).random()]
            return anyColorIntArray[((anyColorIntArray.indices).random())]
        }
    }

    /**
     * The Flat Design UI colors are popular in web design and are used to create simple user-friendly interfaces.
     * Flat Design technique uses simple effects to create designs without effects like shadows, bevels, gradients and embossing.
     */
    object FlatDesign {

        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_50 = _root_ide_package_.android.graphics.Color.rgb(249, 235, 234)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_100 = _root_ide_package_.android.graphics.Color.rgb(242, 215, 213)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_200 = _root_ide_package_.android.graphics.Color.rgb(230, 176, 170)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_300 = _root_ide_package_.android.graphics.Color.rgb(217, 136, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_400 = _root_ide_package_.android.graphics.Color.rgb(205, 97, 85)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_500 = _root_ide_package_.android.graphics.Color.rgb(192, 57, 43)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_600 = _root_ide_package_.android.graphics.Color.rgb(169, 50, 38)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_700 = _root_ide_package_.android.graphics.Color.rgb(146, 43, 33)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_800 = _root_ide_package_.android.graphics.Color.rgb(123, 36, 28)
        @androidx.annotation.ColorInt
        @JvmStatic val POMEGRANATE_900 = _root_ide_package_.android.graphics.Color.rgb(100, 30, 22)

        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_50 = _root_ide_package_.android.graphics.Color.rgb(253, 237, 236)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_100 = _root_ide_package_.android.graphics.Color.rgb(250, 219, 216)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_200 = _root_ide_package_.android.graphics.Color.rgb(245, 183, 177)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_300 = _root_ide_package_.android.graphics.Color.rgb(241, 148, 138)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_400 = _root_ide_package_.android.graphics.Color.rgb(236, 112, 99)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_500 = _root_ide_package_.android.graphics.Color.rgb(231, 76, 60)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_600 = _root_ide_package_.android.graphics.Color.rgb(203, 67, 53)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_700 = _root_ide_package_.android.graphics.Color.rgb(176, 58, 46)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_800 = _root_ide_package_.android.graphics.Color.rgb(148, 49, 38)
        @androidx.annotation.ColorInt
        @JvmStatic val ALIZARIN_900 = _root_ide_package_.android.graphics.Color.rgb(120, 40, 31)

        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_50 = _root_ide_package_.android.graphics.Color.rgb(245, 238, 248)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_100 = _root_ide_package_.android.graphics.Color.rgb(235, 222, 240)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_200 = _root_ide_package_.android.graphics.Color.rgb(215, 189, 226)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_300 = _root_ide_package_.android.graphics.Color.rgb(195, 155, 211)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_400 = _root_ide_package_.android.graphics.Color.rgb(175, 122, 197)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_500 = _root_ide_package_.android.graphics.Color.rgb(155, 89, 182)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_600 = _root_ide_package_.android.graphics.Color.rgb(136, 78, 160)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_700 = _root_ide_package_.android.graphics.Color.rgb(118, 68, 138)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_800 = _root_ide_package_.android.graphics.Color.rgb(99, 57, 116)
        @androidx.annotation.ColorInt
        @JvmStatic val AMETHYST_900 = _root_ide_package_.android.graphics.Color.rgb(81, 46, 95)

        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_50 = _root_ide_package_.android.graphics.Color.rgb(244, 236, 247)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_100 = _root_ide_package_.android.graphics.Color.rgb(232, 218, 239)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_200 = _root_ide_package_.android.graphics.Color.rgb(210, 180, 222)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_300 = _root_ide_package_.android.graphics.Color.rgb(187, 143, 206)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_400 = _root_ide_package_.android.graphics.Color.rgb(165, 105, 189)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_500 = _root_ide_package_.android.graphics.Color.rgb(142, 68, 173)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_600 = _root_ide_package_.android.graphics.Color.rgb(125, 60, 152)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_700 = _root_ide_package_.android.graphics.Color.rgb(108, 52, 131)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_800 = _root_ide_package_.android.graphics.Color.rgb(91, 44, 111)
        @androidx.annotation.ColorInt
        @JvmStatic val WISTERIA_900 = _root_ide_package_.android.graphics.Color.rgb(74, 35, 90)

        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_50 = _root_ide_package_.android.graphics.Color.rgb(234, 242, 248)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_100 = _root_ide_package_.android.graphics.Color.rgb(212, 230, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_200 = _root_ide_package_.android.graphics.Color.rgb(169, 204, 227)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_300 = _root_ide_package_.android.graphics.Color.rgb(127, 179, 213)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_400 = _root_ide_package_.android.graphics.Color.rgb(84, 153, 199)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_500 = _root_ide_package_.android.graphics.Color.rgb(41, 128, 185)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_600 = _root_ide_package_.android.graphics.Color.rgb(36, 113, 163)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_700 = _root_ide_package_.android.graphics.Color.rgb(31, 97, 141)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_800 = _root_ide_package_.android.graphics.Color.rgb(26, 82, 118)
        @androidx.annotation.ColorInt
        @JvmStatic val BELIZE_HOLE_900 = _root_ide_package_.android.graphics.Color.rgb(21, 67, 96)

        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_50 = _root_ide_package_.android.graphics.Color.rgb(235, 245, 251)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_100 = _root_ide_package_.android.graphics.Color.rgb(214, 234, 248)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_200 = _root_ide_package_.android.graphics.Color.rgb(174, 214, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_300 = _root_ide_package_.android.graphics.Color.rgb(133, 193, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_400 = _root_ide_package_.android.graphics.Color.rgb(93, 173, 226)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_500 = _root_ide_package_.android.graphics.Color.rgb(52, 152, 219)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_600 = _root_ide_package_.android.graphics.Color.rgb(46, 134, 193)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_700 = _root_ide_package_.android.graphics.Color.rgb(40, 116, 166)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_800 = _root_ide_package_.android.graphics.Color.rgb(33, 97, 140)
        @androidx.annotation.ColorInt
        @JvmStatic val PETER_RIVER_900 = _root_ide_package_.android.graphics.Color.rgb(27, 79, 114)

        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_50 = _root_ide_package_.android.graphics.Color.rgb(232, 248, 245)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_100 = _root_ide_package_.android.graphics.Color.rgb(209, 242, 235)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_200 = _root_ide_package_.android.graphics.Color.rgb(163, 228, 215)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_300 = _root_ide_package_.android.graphics.Color.rgb(118, 215, 196)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_400 = _root_ide_package_.android.graphics.Color.rgb(72, 201, 176)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_500 = _root_ide_package_.android.graphics.Color.rgb(26, 188, 156)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_600 = _root_ide_package_.android.graphics.Color.rgb(23, 165, 137)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_700 = _root_ide_package_.android.graphics.Color.rgb(20, 143, 119)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_800 = _root_ide_package_.android.graphics.Color.rgb(17, 120, 100)
        @androidx.annotation.ColorInt
        @JvmStatic val TORQUOISE_900 = _root_ide_package_.android.graphics.Color.rgb(14, 98, 81)

        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_50 = _root_ide_package_.android.graphics.Color.rgb(232, 246, 243)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_100 = _root_ide_package_.android.graphics.Color.rgb(208, 236, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_200 = _root_ide_package_.android.graphics.Color.rgb(162, 217, 206)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_300 = _root_ide_package_.android.graphics.Color.rgb(115, 198, 182)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_400 = _root_ide_package_.android.graphics.Color.rgb(69, 179, 157)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_500 = _root_ide_package_.android.graphics.Color.rgb(22, 160, 133)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_600 = _root_ide_package_.android.graphics.Color.rgb(19, 141, 117)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_700 = _root_ide_package_.android.graphics.Color.rgb(17, 122, 101)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_800 = _root_ide_package_.android.graphics.Color.rgb(14, 102, 85)
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN_SEA_900 = _root_ide_package_.android.graphics.Color.rgb(11, 83, 69)

        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_50 = _root_ide_package_.android.graphics.Color.rgb(233, 247, 239)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_100 = _root_ide_package_.android.graphics.Color.rgb(212, 239, 223)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_200 = _root_ide_package_.android.graphics.Color.rgb(169, 223, 191)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_300 = _root_ide_package_.android.graphics.Color.rgb(125, 206, 160)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_400 = _root_ide_package_.android.graphics.Color.rgb(82, 190, 128)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_500 = _root_ide_package_.android.graphics.Color.rgb(39, 174, 96)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_600 = _root_ide_package_.android.graphics.Color.rgb(34, 153, 84)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_700 = _root_ide_package_.android.graphics.Color.rgb(30, 132, 73)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_800 = _root_ide_package_.android.graphics.Color.rgb(25, 111, 61)
        @androidx.annotation.ColorInt
        @JvmStatic val NEPHRITIS_900 = _root_ide_package_.android.graphics.Color.rgb(20, 90, 50)

        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_50 = _root_ide_package_.android.graphics.Color.rgb(234, 250, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_100 = _root_ide_package_.android.graphics.Color.rgb(213, 245, 227)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_200 = _root_ide_package_.android.graphics.Color.rgb(171, 235, 198)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_300 = _root_ide_package_.android.graphics.Color.rgb(130, 224, 170)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_400 = _root_ide_package_.android.graphics.Color.rgb(88, 214, 141)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_500 = _root_ide_package_.android.graphics.Color.rgb(46, 204, 113)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_600 = _root_ide_package_.android.graphics.Color.rgb(40, 180, 99)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_700 = _root_ide_package_.android.graphics.Color.rgb(35, 155, 86)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_800 = _root_ide_package_.android.graphics.Color.rgb(29, 131, 72)
        @androidx.annotation.ColorInt
        @JvmStatic val EMERALD_900 = _root_ide_package_.android.graphics.Color.rgb(24, 106, 59)

        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_50 = _root_ide_package_.android.graphics.Color.rgb(254, 249, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_100 = _root_ide_package_.android.graphics.Color.rgb(252, 243, 207)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_200 = _root_ide_package_.android.graphics.Color.rgb(249, 231, 159)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_300 = _root_ide_package_.android.graphics.Color.rgb(247, 220, 111)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_400 = _root_ide_package_.android.graphics.Color.rgb(244, 208, 63)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_500 = _root_ide_package_.android.graphics.Color.rgb(241, 196, 15)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_600 = _root_ide_package_.android.graphics.Color.rgb(212, 172, 13)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_700 = _root_ide_package_.android.graphics.Color.rgb(183, 149, 11)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_800 = _root_ide_package_.android.graphics.Color.rgb(154, 125, 10)
        @androidx.annotation.ColorInt
        @JvmStatic val SUNFLOWER_900 = _root_ide_package_.android.graphics.Color.rgb(125, 102, 8)

        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_50 = _root_ide_package_.android.graphics.Color.rgb(254, 245, 231)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_100 = _root_ide_package_.android.graphics.Color.rgb(253, 235, 208)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_200 = _root_ide_package_.android.graphics.Color.rgb(250, 215, 160)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_300 = _root_ide_package_.android.graphics.Color.rgb(248, 196, 113)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_400 = _root_ide_package_.android.graphics.Color.rgb(245, 176, 65)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_500 = _root_ide_package_.android.graphics.Color.rgb(243, 156, 18)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_600 = _root_ide_package_.android.graphics.Color.rgb(214, 137, 16)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_700 = _root_ide_package_.android.graphics.Color.rgb(185, 119, 14)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_800 = _root_ide_package_.android.graphics.Color.rgb(156, 100, 12)
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE_900 = _root_ide_package_.android.graphics.Color.rgb(126, 81, 9)

        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_50 = _root_ide_package_.android.graphics.Color.rgb(253, 242, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_100 = _root_ide_package_.android.graphics.Color.rgb(250, 229, 211)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_200 = _root_ide_package_.android.graphics.Color.rgb(245, 203, 167)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_300 = _root_ide_package_.android.graphics.Color.rgb(240, 178, 122)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_400 = _root_ide_package_.android.graphics.Color.rgb(235, 152, 78)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_500 = _root_ide_package_.android.graphics.Color.rgb(230, 126, 34)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_600 = _root_ide_package_.android.graphics.Color.rgb(202, 111, 30)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_700 = _root_ide_package_.android.graphics.Color.rgb(175, 96, 26)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_800 = _root_ide_package_.android.graphics.Color.rgb(147, 81, 22)
        @androidx.annotation.ColorInt
        @JvmStatic val CARROT_900 = _root_ide_package_.android.graphics.Color.rgb(120, 66, 18)

        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_50 = _root_ide_package_.android.graphics.Color.rgb(251, 238, 230)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_100 = _root_ide_package_.android.graphics.Color.rgb(246, 221, 204)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_200 = _root_ide_package_.android.graphics.Color.rgb(237, 187, 153)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_300 = _root_ide_package_.android.graphics.Color.rgb(229, 152, 102)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_400 = _root_ide_package_.android.graphics.Color.rgb(220, 118, 51)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_500 = _root_ide_package_.android.graphics.Color.rgb(211, 84, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_600 = _root_ide_package_.android.graphics.Color.rgb(186, 74, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_700 = _root_ide_package_.android.graphics.Color.rgb(160, 64, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_800 = _root_ide_package_.android.graphics.Color.rgb(135, 54, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val PUMPKIN_900 = _root_ide_package_.android.graphics.Color.rgb(110, 44, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_50 = _root_ide_package_.android.graphics.Color.rgb(253, 254, 254)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_100 = _root_ide_package_.android.graphics.Color.rgb(251, 252, 252)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_200 = _root_ide_package_.android.graphics.Color.rgb(247, 249, 249)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_300 = _root_ide_package_.android.graphics.Color.rgb(244, 246, 247)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_400 = _root_ide_package_.android.graphics.Color.rgb(240, 243, 244)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_500 = _root_ide_package_.android.graphics.Color.rgb(236, 240, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_600 = _root_ide_package_.android.graphics.Color.rgb(208, 211, 212)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_700 = _root_ide_package_.android.graphics.Color.rgb(179, 182, 183)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_800 = _root_ide_package_.android.graphics.Color.rgb(151, 154, 154)
        @androidx.annotation.ColorInt
        @JvmStatic val CLOUD_900 = _root_ide_package_.android.graphics.Color.rgb(123, 125, 125)

        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_50 = _root_ide_package_.android.graphics.Color.rgb(248, 249, 249)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_100 = _root_ide_package_.android.graphics.Color.rgb(242, 243, 244)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_200 = _root_ide_package_.android.graphics.Color.rgb(229, 231, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_300 = _root_ide_package_.android.graphics.Color.rgb(215, 219, 221)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_400 = _root_ide_package_.android.graphics.Color.rgb(202, 207, 210)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_500 = _root_ide_package_.android.graphics.Color.rgb(189, 195, 199)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_600 = _root_ide_package_.android.graphics.Color.rgb(166, 172, 175)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_700 = _root_ide_package_.android.graphics.Color.rgb(144, 148, 151)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_800 = _root_ide_package_.android.graphics.Color.rgb(121, 125, 127)
        @androidx.annotation.ColorInt
        @JvmStatic val SILVER_900 = _root_ide_package_.android.graphics.Color.rgb(98, 101, 103)

        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_50 = _root_ide_package_.android.graphics.Color.rgb(244, 246, 246)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_100 = _root_ide_package_.android.graphics.Color.rgb(234, 237, 237)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_200 = _root_ide_package_.android.graphics.Color.rgb(213, 219, 219)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_300 = _root_ide_package_.android.graphics.Color.rgb(191, 201, 202)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_400 = _root_ide_package_.android.graphics.Color.rgb(170, 183, 184)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_500 = _root_ide_package_.android.graphics.Color.rgb(149, 165, 166)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_600 = _root_ide_package_.android.graphics.Color.rgb(131, 145, 146)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_700 = _root_ide_package_.android.graphics.Color.rgb(113, 125, 126)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_800 = _root_ide_package_.android.graphics.Color.rgb(95, 106, 106)
        @androidx.annotation.ColorInt
        @JvmStatic val CONCRETE_900 = _root_ide_package_.android.graphics.Color.rgb(77, 86, 86)

        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_50 = _root_ide_package_.android.graphics.Color.rgb(242, 244, 244)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_100 = _root_ide_package_.android.graphics.Color.rgb(229, 232, 232)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_200 = _root_ide_package_.android.graphics.Color.rgb(204, 209, 209)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_300 = _root_ide_package_.android.graphics.Color.rgb(178, 186, 187)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_400 = _root_ide_package_.android.graphics.Color.rgb(153, 163, 164)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_500 = _root_ide_package_.android.graphics.Color.rgb(127, 140, 141)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_600 = _root_ide_package_.android.graphics.Color.rgb(112, 123, 124)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_700 = _root_ide_package_.android.graphics.Color.rgb(97, 106, 107)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_800 = _root_ide_package_.android.graphics.Color.rgb(81, 90, 90)
        @androidx.annotation.ColorInt
        @JvmStatic val ASBESTOS_900 = _root_ide_package_.android.graphics.Color.rgb(66, 73, 73)

        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_50 = _root_ide_package_.android.graphics.Color.rgb(235, 237, 239)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_100 = _root_ide_package_.android.graphics.Color.rgb(214, 219, 223)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_200 = _root_ide_package_.android.graphics.Color.rgb(174, 182, 191)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_300 = _root_ide_package_.android.graphics.Color.rgb(133, 146, 158)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_400 = _root_ide_package_.android.graphics.Color.rgb(93, 109, 126)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_500 = _root_ide_package_.android.graphics.Color.rgb(52, 73, 94)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_600 = _root_ide_package_.android.graphics.Color.rgb(46, 64, 83)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_700 = _root_ide_package_.android.graphics.Color.rgb(40, 55, 71)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_800 = _root_ide_package_.android.graphics.Color.rgb(33, 47, 60)
        @androidx.annotation.ColorInt
        @JvmStatic val WET_ASPHALT_900 = _root_ide_package_.android.graphics.Color.rgb(27, 38, 49)

        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_50 = _root_ide_package_.android.graphics.Color.rgb(234, 236, 238)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_100 = _root_ide_package_.android.graphics.Color.rgb(213, 216, 220)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_200 = _root_ide_package_.android.graphics.Color.rgb(171, 178, 185)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_300 = _root_ide_package_.android.graphics.Color.rgb(128, 139, 150)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_400 = _root_ide_package_.android.graphics.Color.rgb(86, 101, 115)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_500 = _root_ide_package_.android.graphics.Color.rgb(44, 62, 80)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_600 = _root_ide_package_.android.graphics.Color.rgb(39, 55, 70)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_700 = _root_ide_package_.android.graphics.Color.rgb(33, 47, 61)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_800 = _root_ide_package_.android.graphics.Color.rgb(28, 40, 51)
        @androidx.annotation.ColorInt
        @JvmStatic val MIDNIGHT_BLUE_900 = _root_ide_package_.android.graphics.Color.rgb(23, 32, 42)

        /** An array containing all 10 FlatDesign POMEGRANATE colors. */
        @JvmStatic val pomegranateColorArray = intArrayOf( POMEGRANATE_50, POMEGRANATE_100, POMEGRANATE_200, POMEGRANATE_300, POMEGRANATE_400, POMEGRANATE_500, POMEGRANATE_600, POMEGRANATE_700, POMEGRANATE_800, POMEGRANATE_900)

        /** An array containing all 10 FlatDesign ALIZARIN colors. */
        @JvmStatic val alizarinColorArray = intArrayOf( ALIZARIN_50, ALIZARIN_100, ALIZARIN_200, ALIZARIN_300, ALIZARIN_400, ALIZARIN_500, ALIZARIN_600, ALIZARIN_700, ALIZARIN_800, ALIZARIN_900)

        /** An array containing all 10 FlatDesign AMETHYST colors. */
        @JvmStatic val amethystColorArray = intArrayOf( AMETHYST_50, AMETHYST_100, AMETHYST_200, AMETHYST_300, AMETHYST_400, AMETHYST_500, AMETHYST_600, AMETHYST_700, AMETHYST_800, AMETHYST_900)

        /** An array containing all 10 FlatDesign WISTERIA colors. */
        @JvmStatic val wisteriaColorArray = intArrayOf( WISTERIA_50, WISTERIA_100, WISTERIA_200, WISTERIA_300, WISTERIA_400, WISTERIA_500, WISTERIA_600, WISTERIA_700, WISTERIA_800, WISTERIA_900)

        /** An array containing all 10 FlatDesign BELIZE HOLE colors. */
        @JvmStatic val belizeHoleColorArray = intArrayOf( BELIZE_HOLE_50, BELIZE_HOLE_100, BELIZE_HOLE_200, BELIZE_HOLE_300, BELIZE_HOLE_400, BELIZE_HOLE_500, BELIZE_HOLE_600, BELIZE_HOLE_700, BELIZE_HOLE_800, BELIZE_HOLE_900)

        /** An array containing all 10 FlatDesign PETER RIVER colors. */
        @JvmStatic val peterRiverColorArray = intArrayOf( PETER_RIVER_50, PETER_RIVER_100, PETER_RIVER_200, PETER_RIVER_300, PETER_RIVER_400, PETER_RIVER_500, PETER_RIVER_600, PETER_RIVER_700, PETER_RIVER_800, PETER_RIVER_900)

        /** An array containing all 10 FlatDesign TORQUOISE colors. */
        @JvmStatic val torquoiseColorArray = intArrayOf( TORQUOISE_50, TORQUOISE_100, TORQUOISE_200, TORQUOISE_300, TORQUOISE_400, TORQUOISE_500, TORQUOISE_600, TORQUOISE_700, TORQUOISE_800, TORQUOISE_900)

        /** An array containing all 10 FlatDesign GREEN SEA colors. */
        @JvmStatic val greenSeaColorArray = intArrayOf( GREEN_SEA_50, GREEN_SEA_100, GREEN_SEA_200, GREEN_SEA_300, GREEN_SEA_400, GREEN_SEA_500, GREEN_SEA_600, GREEN_SEA_700, GREEN_SEA_800, GREEN_SEA_900)

        /** An array containing all 10 FlatDesign NEPHRITIS colors. */
        @JvmStatic val nephritisColorArray = intArrayOf( NEPHRITIS_50, NEPHRITIS_100, NEPHRITIS_200, NEPHRITIS_300, NEPHRITIS_400, NEPHRITIS_500, NEPHRITIS_600, NEPHRITIS_700, NEPHRITIS_800, NEPHRITIS_900)

        /** An array containing all 10 FlatDesign EMERALD colors. */
        @JvmStatic val emeraldColorArray = intArrayOf( EMERALD_50, EMERALD_100, EMERALD_200, EMERALD_300, EMERALD_400, EMERALD_500, EMERALD_600, EMERALD_700, EMERALD_800, EMERALD_900)

        /** An array containing all 10 FlatDesign SUNFLOWER colors. */
        @JvmStatic val sunflowerColorArray = intArrayOf( SUNFLOWER_50, SUNFLOWER_100, SUNFLOWER_200, SUNFLOWER_300, SUNFLOWER_400, SUNFLOWER_500, SUNFLOWER_600, SUNFLOWER_700, SUNFLOWER_800, SUNFLOWER_900)

        /** An array containing all 10 FlatDesign ORANGE colors. */
        @JvmStatic val orangeColorArray = intArrayOf( ORANGE_50, ORANGE_100, ORANGE_200, ORANGE_300, ORANGE_400, ORANGE_500, ORANGE_600, ORANGE_700, ORANGE_800, ORANGE_900)

        /** An array containing all 10 FlatDesign CARROT colors. */
        @JvmStatic val carrotColorArray = intArrayOf( CARROT_50, CARROT_100, CARROT_200, CARROT_300, CARROT_400, CARROT_500, CARROT_600, CARROT_700, CARROT_800, CARROT_900)

        /** An array containing all 10 FlatDesign PUMPKIN colors. */
        @JvmStatic val pumpkinColorArray = intArrayOf( PUMPKIN_50, PUMPKIN_100, PUMPKIN_200, PUMPKIN_300, PUMPKIN_400, PUMPKIN_500, PUMPKIN_600, PUMPKIN_700, PUMPKIN_800, PUMPKIN_900)

        /** An array containing all 10 FlatDesign CLOUD colors. */
        @JvmStatic val cloudColorArray = intArrayOf( CLOUD_50, CLOUD_100, CLOUD_200, CLOUD_300, CLOUD_400, CLOUD_500, CLOUD_600, CLOUD_700, CLOUD_800, CLOUD_900)

        /** An array containing all 10 FlatDesign SILVER colors. */
        @JvmStatic val silverColorArray = intArrayOf( SILVER_50, SILVER_100, SILVER_200, SILVER_300, SILVER_400, SILVER_500, SILVER_600, SILVER_700, SILVER_800, SILVER_900)

        /** An array containing all 10 FlatDesign CONCRETE colors. */
        @JvmStatic val concreteColorArray = intArrayOf( CONCRETE_50, CONCRETE_100, CONCRETE_200, CONCRETE_300, CONCRETE_400, CONCRETE_500, CONCRETE_600, CONCRETE_700, CONCRETE_800, CONCRETE_900)

        /** An array containing all 10 FlatDesign ASBESTOS colors. */
        @JvmStatic val asbestosColorArray = intArrayOf( ASBESTOS_50, ASBESTOS_100, ASBESTOS_200, ASBESTOS_300, ASBESTOS_400, ASBESTOS_500, ASBESTOS_600, ASBESTOS_700, ASBESTOS_800, ASBESTOS_900)

        /** An array containing all 10 FlatDesign WET ASPHALT colors. */
        @JvmStatic val wetAsphaltColorArray = intArrayOf( WET_ASPHALT_50, WET_ASPHALT_100, WET_ASPHALT_200, WET_ASPHALT_300, WET_ASPHALT_400, WET_ASPHALT_500, WET_ASPHALT_600, WET_ASPHALT_700, WET_ASPHALT_800, WET_ASPHALT_900)

        /** An array containing all 10 FlatDesign MIDNIGHT BLUE colors. */
        @JvmStatic val midNightBlueColorArray = intArrayOf( MIDNIGHT_BLUE_50, MIDNIGHT_BLUE_100, MIDNIGHT_BLUE_200, MIDNIGHT_BLUE_300, MIDNIGHT_BLUE_400, MIDNIGHT_BLUE_500, MIDNIGHT_BLUE_600, MIDNIGHT_BLUE_700, MIDNIGHT_BLUE_800, MIDNIGHT_BLUE_900)

        /**
         * Gets a random shade of FlatDesign POMEGRANATE from the [Pomegranate Color Array][pomegranateColorArray].
         *
         * @return @[androidx.annotation.ColorInt] POMEGRANATE.
         */
        @JvmStatic fun randomPomegranateColor() = pomegranateColorArray[(pomegranateColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ALIZARIN from the [Alizarin Color Array][alizarinColorArray].
         *
         * @return @[androidx.annotation.ColorInt] ALIZARIN.
         */
        @JvmStatic fun randomAlizarinColor() = alizarinColorArray[(alizarinColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign AMETHYST from the [Amethyst Color Array][amethystColorArray].
         *
         * @return @[androidx.annotation.ColorInt] AMETHYST.
         */
        @JvmStatic fun randomAmethystColor() = amethystColorArray[(amethystColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign WISTERIA from the [Wisteria Color Array][wisteriaColorArray].
         *
         * @return @[androidx.annotation.ColorInt] WISTERIA.
         */
        @JvmStatic fun randomWisteriaColor() = wisteriaColorArray[(wisteriaColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign BELIZE HOLE from the [Belize Hole Color Array][belizeHoleColorArray].
         *
         * @return @[androidx.annotation.ColorInt] BELIZE HOLE.
         */
        @JvmStatic fun randomBelizeHoleColor() = belizeHoleColorArray[(belizeHoleColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign PETER RIVER from the [Peter River Color Array][peterRiverColorArray].
         *
         * @return @[androidx.annotation.ColorInt] PETER RIVER.
         */
        @JvmStatic fun randomPeterRiverColor() = peterRiverColorArray[(peterRiverColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign TORQUOISE from the [Torquoise Color Array][torquoiseColorArray].
         *
         * @return @[androidx.annotation.ColorInt] TORQUOISE.
         */
        @JvmStatic fun randomTorquoiseColor() = torquoiseColorArray[(torquoiseColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign GREEN SEA from the [Green Sea Color Array][greenSeaColorArray].
         *
         * @return @[androidx.annotation.ColorInt] GREEN SEA.
         */
        @JvmStatic fun randomGreenSeaColor() = greenSeaColorArray[(greenSeaColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign NEPHRITIS from the [Nephritis Color Array][nephritisColorArray].
         *
         * @return @[androidx.annotation.ColorInt] NEPHRITIS.
         */
        @JvmStatic fun randomNephritisColor() = nephritisColorArray[(nephritisColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign EMERALD from the [Emerald Color Array][emeraldColorArray].
         *
         * @return @[androidx.annotation.ColorInt] EMERALD.
         */
        @JvmStatic fun randomEmeraldColor() = emeraldColorArray[(emeraldColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign SUNFLOWER from the [Sunflower Color Array][sunflowerColorArray].
         *
         * @return @[androidx.annotation.ColorInt] SUNFLOWER.
         */
        @JvmStatic fun randomSunflowerColor() = sunflowerColorArray[(sunflowerColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ORANGE from the [Orange Color Array][orangeColorArray].
         *
         * @return @[androidx.annotation.ColorInt] ORANGE.
         */
        @JvmStatic fun randomOrangeColor() = orangeColorArray[(orangeColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CARROT from the [Carrot Color Array][carrotColorArray].
         *
         * @return @[androidx.annotation.ColorInt] CARROT.
         */
        @JvmStatic fun randomCarrotColor() = carrotColorArray[(carrotColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign PUMPKIN from the [Pumpkin Color Array][pumpkinColorArray].
         *
         * @return @[androidx.annotation.ColorInt] PUMPKIN.
         */
        @JvmStatic fun randomPumpkinColor() = pumpkinColorArray[(pumpkinColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CLOUD from the [Cloud Color Array][cloudColorArray].
         *
         * @return @[androidx.annotation.ColorInt] CLOUD.
         */
        @JvmStatic fun randomCloudColor() = cloudColorArray[(cloudColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign SILVER from the [Silver Color Array][silverColorArray].
         *
         * @return @[androidx.annotation.ColorInt] SILVER.
         */
        @JvmStatic fun randomSilverColor() = silverColorArray[(silverColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CONCRETE from the [Concrete Color Array][concreteColorArray].
         *
         * @return @[androidx.annotation.ColorInt] CONCRETE.
         */
        @JvmStatic fun randomConcreteColor() = concreteColorArray[(concreteColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ASBESTOS from the [Asbestos Color Array][asbestosColorArray].
         *
         * @return @[androidx.annotation.ColorInt] ASBESTOS.
         */
        @JvmStatic fun randomAsbestosColor() = asbestosColorArray[(asbestosColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign WET ASPHALT from the [Wet Asphalt Color Array][wetAsphaltColorArray].
         *
         * @return @[androidx.annotation.ColorInt] WET ASPHALT.
         */
        @JvmStatic fun randomWetAsphaltColor() = wetAsphaltColorArray[(wetAsphaltColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign MIDNIGHT BLUE from the [MidNight Blue Array][midNightBlueColorArray].
         *
         * @return @[androidx.annotation.ColorInt] MIDNIGHT BLUE.
         */
        @JvmStatic fun randomMidNightBlueColor() = midNightBlueColorArray[(midNightBlueColorArray.indices).random()]

        private val arrayOfAllColorArrays = arrayOf(
            pomegranateColorArray, alizarinColorArray, amethystColorArray,
            wisteriaColorArray, belizeHoleColorArray, peterRiverColorArray,
            torquoiseColorArray, greenSeaColorArray, nephritisColorArray,
            emeraldColorArray, sunflowerColorArray, orangeColorArray,
            carrotColorArray, pumpkinColorArray, cloudColorArray,
            silverColorArray, concreteColorArray, asbestosColorArray,
            wetAsphaltColorArray, midNightBlueColorArray

        )

        /**  Picks a random color from one of the [FlatDesign] colors.*/
        @JvmStatic fun selectRandomColor(): Int {
            val anyColorIntArray = arrayOfAllColorArrays[(arrayOfAllColorArrays.indices).random()]
            return anyColorIntArray[((anyColorIntArray.indices).random())]
        }
    }

    /** The official Apple Human Interface Guidelines (HIG) system colors.
     *
     * **Note:** These are approximations of iOS/macOS system colors in Light Mode.
     * Actual values may vary depending on device and Dark Mode.
     */
    object AppleHIG {
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_BLUE = _root_ide_package_.android.graphics.Color.rgb(0, 122, 255)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GREEN = _root_ide_package_.android.graphics.Color.rgb(52, 199, 89)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_INDIGO = _root_ide_package_.android.graphics.Color.rgb(88, 86, 214)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_ORANGE = _root_ide_package_.android.graphics.Color.rgb(255, 149, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_PINK = _root_ide_package_.android.graphics.Color.rgb(255, 45, 85)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_PURPLE = _root_ide_package_.android.graphics.Color.rgb(175, 82, 222)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_RED = _root_ide_package_.android.graphics.Color.rgb(255, 59, 48)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_TEAL = _root_ide_package_.android.graphics.Color.rgb(90, 200, 250)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_YELLOW = _root_ide_package_.android.graphics.Color.rgb(255, 204, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY = _root_ide_package_.android.graphics.Color.rgb(142, 142, 147)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY2 = _root_ide_package_.android.graphics.Color.rgb(174, 174, 178)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY3 = _root_ide_package_.android.graphics.Color.rgb(199, 199, 204)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY4 = _root_ide_package_.android.graphics.Color.rgb(209, 209, 214)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY5 = _root_ide_package_.android.graphics.Color.rgb(229, 229, 234)
        @androidx.annotation.ColorInt
        @JvmStatic val SYSTEM_GRAY6 = _root_ide_package_.android.graphics.Color.rgb(242, 242, 247)
    }

    /**
     * Atlassian Design System Colors.
     *
     * Static references to Atlassian brand palette.
     *
     * [Source](https://atlassian.design/foundations/color)
     */
    object AtlassianColors {
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_BLUE = _root_ide_package_.android.graphics.Color.rgb(0, 82, 204)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GREEN = _root_ide_package_.android.graphics.Color.rgb(0, 135, 90)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_PURPLE = _root_ide_package_.android.graphics.Color.rgb(109, 50, 245)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_TEAL = _root_ide_package_.android.graphics.Color.rgb(0, 184, 217)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_RED = _root_ide_package_.android.graphics.Color.rgb(222, 53, 11)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_YELLOW = _root_ide_package_.android.graphics.Color.rgb(255, 171, 0)

        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY100 = _root_ide_package_.android.graphics.Color.rgb(250, 251, 252)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY200 = _root_ide_package_.android.graphics.Color.rgb(235, 236, 240)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY300 = _root_ide_package_.android.graphics.Color.rgb(223, 225, 230)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY400 = _root_ide_package_.android.graphics.Color.rgb(168, 169, 173)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY500 = _root_ide_package_.android.graphics.Color.rgb(107, 119, 140)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY600 = _root_ide_package_.android.graphics.Color.rgb(66, 82, 110)
        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_GRAY700 = _root_ide_package_.android.graphics.Color.rgb(23, 43, 77)

        @androidx.annotation.ColorInt
        @JvmStatic val ATLASSIAN_LINK = _root_ide_package_.android.graphics.Color.rgb(0, 101, 255)
    }

    /**
     * Bootstrap Colors.
     *
     * Static references to Bootstrap's standard color system.
     *
     * [Source](https://getbootstrap.com/docs/5.3/customize/color/)
     */
    object BootstrapColors {
        @androidx.annotation.ColorInt
        @JvmStatic val PRIMARY = _root_ide_package_.android.graphics.Color.rgb(13, 110, 253)
        @androidx.annotation.ColorInt
        @JvmStatic val SECONDARY = _root_ide_package_.android.graphics.Color.rgb(108, 117, 125)
        @androidx.annotation.ColorInt
        @JvmStatic val SUCCESS = _root_ide_package_.android.graphics.Color.rgb(25, 135, 84)
        @androidx.annotation.ColorInt
        @JvmStatic val DANGER = _root_ide_package_.android.graphics.Color.rgb(220, 53, 69)
        @androidx.annotation.ColorInt
        @JvmStatic val WARNING = _root_ide_package_.android.graphics.Color.rgb(255, 193, 7)
        @androidx.annotation.ColorInt
        @JvmStatic val INFO = _root_ide_package_.android.graphics.Color.rgb(13, 202, 240)
        @androidx.annotation.ColorInt
        @JvmStatic val LIGHT = _root_ide_package_.android.graphics.Color.rgb(248, 249, 250)
        @androidx.annotation.ColorInt
        @JvmStatic val DARK = _root_ide_package_.android.graphics.Color.rgb(33, 37, 41)
    }


    /** Microsoft Fluent Design System Colors.
     *
     * Note: These are static approximations of the Fluent UI palette.
     * Fluent colors are often dynamic (adjusting to themes/high contrast).
     */
    object MicrosoftFluent {
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_BLUE = _root_ide_package_.android.graphics.Color.rgb(0, 120, 212)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_RED = _root_ide_package_.android.graphics.Color.rgb(232, 17, 35)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GREEN = _root_ide_package_.android.graphics.Color.rgb(16, 124, 16)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_YELLOW = _root_ide_package_.android.graphics.Color.rgb(255, 185, 0)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_ORANGE = _root_ide_package_.android.graphics.Color.rgb(202, 80, 16)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_PURPLE = _root_ide_package_.android.graphics.Color.rgb(118, 58, 196)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_PINK = _root_ide_package_.android.graphics.Color.rgb(236, 0, 140)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_TEAL = _root_ide_package_.android.graphics.Color.rgb(0, 153, 188)

        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY100 = _root_ide_package_.android.graphics.Color.rgb(243, 242, 241)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY200 = _root_ide_package_.android.graphics.Color.rgb(237, 235, 233)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY300 = _root_ide_package_.android.graphics.Color.rgb(200, 198, 196)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY400 = _root_ide_package_.android.graphics.Color.rgb(161, 159, 157)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY500 = _root_ide_package_.android.graphics.Color.rgb(120, 118, 116)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY600 = _root_ide_package_.android.graphics.Color.rgb(96, 94, 92)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY700 = _root_ide_package_.android.graphics.Color.rgb(67, 67, 67)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY800 = _root_ide_package_.android.graphics.Color.rgb(50, 49, 48)
        @androidx.annotation.ColorInt
        @JvmStatic val FLUENT_GRAY900 = _root_ide_package_.android.graphics.Color.rgb(32, 31, 30)
    }




    ///////////////////////////////////////////////////////////////////////////
    // BRAND COLOURS
    ///////////////////////////////////////////////////////////////////////////
    /** The official Airbnb colors. */
    object Airbnb {
        @androidx.annotation.ColorInt
        @JvmStatic val RAUSCH = _root_ide_package_.android.graphics.Color.rgb(255, 90, 95)
        @androidx.annotation.ColorInt
        @JvmStatic val BABU = _root_ide_package_.android.graphics.Color.rgb(0, 166, 153)
        @androidx.annotation.ColorInt
        @JvmStatic val ARCHES = _root_ide_package_.android.graphics.Color.rgb(252, 100, 45)
        @androidx.annotation.ColorInt
        @JvmStatic val HOF = _root_ide_package_.android.graphics.Color.rgb(72, 72, 72)
        @androidx.annotation.ColorInt
        @JvmStatic val FOGGY = _root_ide_package_.android.graphics.Color.rgb(118, 118, 118)
    }

    /** The official Android colors. */
    object Android {
        @androidx.annotation.ColorInt
        @JvmStatic val GREEN = _root_ide_package_.android.graphics.Color.rgb(120, 194, 87)
    }

    /** The official Amazon colors. */
    object Amazon {
        @androidx.annotation.ColorInt
        @JvmStatic val ORANGE = _root_ide_package_.android.graphics.Color.rgb(255, 153, 0)
    }

    /** The official Facebook colors. */
    object Facebook {
        @androidx.annotation.ColorInt
        @JvmStatic val BLUE = _root_ide_package_.android.graphics.Color.rgb(66, 103, 178)
        @androidx.annotation.ColorInt
        @JvmStatic val GREY = _root_ide_package_.android.graphics.Color.rgb(137, 143, 156)

        /** The official Facebook Messenger colors. */
        object Messenger {
            @androidx.annotation.ColorInt
            @JvmStatic val LIGHT_BLUE = _root_ide_package_.android.graphics.Color.rgb(0, 178, 255)
            @androidx.annotation.ColorInt
            @JvmStatic val BLUE = _root_ide_package_.android.graphics.Color.rgb(0, 106, 255)

        }
    }

    /** The official Google colors. */
    object Google {
        @ColorInt @JvmStatic val BLUE = Color.rgb(66, 133, 244)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(244, 180, 0)
        @ColorInt @JvmStatic val RED = Color.rgb(219, 68, 55)
        @ColorInt @JvmStatic val GREEN = Color.rgb(15, 157, 88)
    }

    /** The official HP colors. */
    object HP {
        @ColorInt @JvmStatic val BLUE = Color.rgb(0, 150, 214)
    }

    /** The official IBM colors. */
    object IBM {
        @ColorInt @JvmStatic val BLUE = Color.rgb(75, 107, 175)
    }

    /** The official Instagram colors. */
    object Instagram {
        @ColorInt @JvmStatic val ROYAL_BLUE = Color.rgb(5, 10, 230)
        @ColorInt @JvmStatic val BLUE = Color.rgb(88, 81, 216)
        @ColorInt @JvmStatic val PURPLE = Color.rgb(131, 58, 180)
        @ColorInt @JvmStatic val DARK_PINK = Color.rgb(193, 53, 132)
        @ColorInt @JvmStatic val PURPLE_RED = Color.rgb(225, 48, 108)
        @ColorInt @JvmStatic val RED = Color.rgb(253, 36, 76)
        @ColorInt @JvmStatic val DARK_ORANGE = Color.rgb(245, 96, 64)
        @ColorInt @JvmStatic val ORANGE = Color.rgb(247, 119, 55)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(252, 175, 69)
        @ColorInt @JvmStatic val LIGHT_YELLOW = Color.rgb(225, 220, 128)
    }

    /** The official Lyft colors. */
    object Lyft {
        @ColorInt @JvmStatic val PINK = Color.rgb(255, 0, 191)
        @ColorInt @JvmStatic val BLACK = Color.rgb(17, 17, 31)
    }

    /** The official Microsoft colors. */
    object Microsoft {
        @ColorInt @JvmStatic val ORANGE_RED = Color.rgb(242, 80, 34)
        @ColorInt @JvmStatic val GREEN = Color.rgb(127, 186, 0)
        @ColorInt @JvmStatic val BLUE = Color.rgb(0, 164, 239)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(255, 185, 0)
        @ColorInt @JvmStatic val GREY = Color.rgb(115, 115, 115)
    }

    /** The official Netflix colors. */
    object Netflix {
        @ColorInt @JvmStatic val RED = Color.rgb(229, 9, 20)
    }

    /** The official Oracle colors. */
    object Oracle {
        @ColorInt @JvmStatic val RED = Color.rgb(248, 0, 0)
    }

    /** The official Pinterest colors. */
    object Pinterest {
        @ColorInt @JvmStatic val RED = Color.rgb(230, 0, 35)
    }

    /** The official Slack colors. */
    object Slack {
        @ColorInt @JvmStatic val LIGHT_BLUE = Color.rgb(54, 197, 240)
        @ColorInt @JvmStatic val GREEN = Color.rgb(46, 182, 125)
        @ColorInt @JvmStatic val RED = Color.rgb(224, 30, 90)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(236, 178, 46)
    }

    /** The official Snapchat colors. */
    object Snapchat {
        @ColorInt @JvmStatic val YELLOW = Color.rgb(255, 252, 0)
    }

    /** The official Spotify colors. */
    object Spotify {
        @ColorInt @JvmStatic val GREEN = Color.rgb(30, 215, 96)
        @ColorInt @JvmStatic val BLACK = Color.rgb(25, 20, 20)
    }

    /**
     * The official Twitter colors.
     * @see [X]
     */
    object Twitter {
        @ColorInt @JvmStatic val BLUE = Color.rgb(29, 161, 242)
        @ColorInt @JvmStatic val BLACK = Color.rgb(20, 23, 26)
        @ColorInt @JvmStatic val DARK_GRAY = Color.rgb(101, 119, 134)
        @ColorInt @JvmStatic val LIGHT_GRAY = Color.rgb(170, 184, 194)
        @ColorInt @JvmStatic val EXTRA_LIGHT_GRAY = Color.rgb(225, 232, 237)
        @ColorInt @JvmStatic val EXTRA_EXTRA_LIGHT_GRAY = Color.rgb(245, 248, 250)
    }

    /** The official Whatsapp colors. */
    object Whatsapp {
        @ColorInt @JvmStatic val TEAL_GREEN = Color.rgb(18, 140, 126)
        @ColorInt @JvmStatic val DARK_TEAL_GREEN = Color.rgb(7, 94, 84)
        @ColorInt @JvmStatic val LIGHT_GREEN = Color.rgb(37, 211, 102)
        @ColorInt @JvmStatic val BLUE = Color.rgb(52, 183, 241)
    }

    /** The official Xbox colors. */
    object Xbox {
        @ColorInt @JvmStatic val GREEN = Color.rgb(16, 124, 16)
        @ColorInt @JvmStatic val GRAY = Color.rgb(58, 58, 58)
    }

    /** The official YouTube colors. */
    object YouTube {
        @ColorInt @JvmStatic val RED = Color.rgb(255, 0, 0)
    }

    /**
     * The official brand colours for X (formerly Twitter).
     * @see [Twitter]
     */
    object X {
        @ColorInt @JvmStatic val BLUE = Color.rgb(29, 161, 242)
        @ColorInt @JvmStatic val BLACK = Color.rgb(20, 23, 26)
        @ColorInt @JvmStatic val DARK_GRAY = Color.rgb(101, 119, 134)
        @ColorInt @JvmStatic val LIGHT_GRAY = Color.rgb(170, 184, 194)
        @ColorInt @JvmStatic val EXTRA_LIGHT_GRAY = Color.rgb(225, 232, 237)
        @ColorInt @JvmStatic val EXTRA_EXTRA_LIGHT_GRAY = Color.rgb(245, 248, 250)
    }


}