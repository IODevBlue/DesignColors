package com.blueiobase.api.android.materialpalettecolors

import androidx.annotation.ColorInt

/**
 * MaterialPaletteColors is a Kotlin Singleton object that provides access to the Material Design Colors specified by the
 * [Material Color System][https://material.io/design/color/the-color-system.html#color-theme-creation] by providing Kotlin [Integer][Int] constants
 * and helper methods to utilize these constants in code.
 *
 * @author IO DevBlue
 * @since 1.0.0
 */
object MaterialPaletteColors {

    @ColorInt val RED_50 = 0xFFEBEE
    @ColorInt val RED_100 = 0xFFCDD2
    @ColorInt val RED_200 = 0xEF9A9A
    @ColorInt val RED_300 = 0xE57373
    @ColorInt val RED_400 = 0xEF5350
    @ColorInt val RED_500 = 0xF44336
    @ColorInt val RED_600 = 0xE53935
    @ColorInt val RED_700 = 0xD32F2F
    @ColorInt val RED_800 = 0xC62828
    @ColorInt val RED_900 = 0xB71C1C
    @ColorInt val RED_A100 = 0xFF8A80
    @ColorInt val RED_A200 = 0xFF5252
    @ColorInt val RED_A400 = 0xFF1744
    @ColorInt val RED_A700 = 0xD50000

    @ColorInt val PINK_50 = 0xFCE4E6
    @ColorInt val PINK_100 = 0xF8BBD0
    @ColorInt val PINK_200 = 0xF48FB1
    @ColorInt val PINK_300 = 0xF06292
    @ColorInt val PINK_400 = 0xEC407A
    @ColorInt val PINK_500 = 0xE91E63
    @ColorInt val PINK_600 = 0xD81B60
    @ColorInt val PINK_700 = 0xC2185B
    @ColorInt val PINK_800 = 0xAD1457
    @ColorInt val PINK_900 = 0x880E4F
    @ColorInt val PINK_A100 = 0xFF80AB
    @ColorInt val PINK_A200 = 0xFF4081
    @ColorInt val PINK_A400 = 0xF50057
    @ColorInt val PINK_A700 = 0xC51162

    @ColorInt val PURPLE_50 = 0xF3E5F5
    @ColorInt val PURPLE_100 = 0xE1BEE7
    @ColorInt val PURPLE_200 = 0xCE93D8
    @ColorInt val PURPLE_300 = 0xBA68C8
    @ColorInt val PURPLE_400 = 0xAB47BC
    @ColorInt val PURPLE_500 = 0x9C27B0
    @ColorInt val PURPLE_600 = 0x8E24AA
    @ColorInt val PURPLE_700 = 0x7B1FA2
    @ColorInt val PURPLE_800 = 0x6A1B9A
    @ColorInt val PURPLE_900 = 0x4A148C
    @ColorInt val PURPLE_A100 = 0xEA80FC
    @ColorInt val PURPLE_A200 = 0xE040FB
    @ColorInt val PURPLE_A400 = 0xD500F9
    @ColorInt val PURPLE_A700 = 0xAA00FF

    @ColorInt val DEEP_PURPLE_50 = 0xEDE7F6
    @ColorInt val DEEP_PURPLE_100 = 0xD1C4E9
    @ColorInt val DEEP_PURPLE_200 = 0xB39DDB
    @ColorInt val DEEP_PURPLE_300 = 0x9575CD
    @ColorInt val DEEP_PURPLE_400 = 0x7E57C2
    @ColorInt val DEEP_PURPLE_500 = 0x673AB7
    @ColorInt val DEEP_PURPLE_600 = 0x5E35B1
    @ColorInt val DEEP_PURPLE_700 = 0x512DA8
    @ColorInt val DEEP_PURPLE_800 = 0x4527A0
    @ColorInt val DEEP_PURPLE_900 = 0x311B92
    @ColorInt val DEEP_PURPLE_A100 = 0xB388FF
    @ColorInt val DEEP_PURPLE_A200 = 0x7C4DFF
    @ColorInt val DEEP_PURPLE_A400 = 0x651FFF
    @ColorInt val DEEP_PURPLE_A700 = 0x6200EA

    @ColorInt val INDIGO_50 = 0xE8EAF6
    @ColorInt val INDIGO_100 = 0xC5CAE9
    @ColorInt val INDIGO_200 = 0x9FA8DA
    @ColorInt val INDIGO_300 = 0x7986CB
    @ColorInt val INDIGO_400 = 0x5C6BC0
    @ColorInt val INDIGO_500 = 0x3F51B5
    @ColorInt val INDIGO_600 = 0x3949AB
    @ColorInt val INDIGO_700 = 0x303F9F
    @ColorInt val INDIGO_800 = 0x283593
    @ColorInt val INDIGO_900 = 0x1A237E
    @ColorInt val INDIGO_A100 = 0x8C9EFF
    @ColorInt val INDIGO_A200 = 0x536DFE
    @ColorInt val INDIGO_A400 = 0x3D5AFE
    @ColorInt val INDIGO_A700 = 0x304FFE

    @ColorInt val BLUE_50 = 0xE3F2FD
    @ColorInt val BLUE_100 = 0xBBDEFB
    @ColorInt val BLUE_200 = 0x90CAF9
    @ColorInt val BLUE_300 = 0x64B5F6
    @ColorInt val BLUE_400 = 0x42A5F5
    @ColorInt val BLUE_500 = 0x2196F3
    @ColorInt val BLUE_600 = 0x1E88E5
    @ColorInt val BLUE_700 = 0x1976D2
    @ColorInt val BLUE_800 = 0x1565C0
    @ColorInt val BLUE_900 = 0x0D47A1
    @ColorInt val BLUE_A100 = 0x82B1FF
    @ColorInt val BLUE_A200 = 0x448AFF
    @ColorInt val BLUE_A400 = 0x2979FF
    @ColorInt val BLUE_A700 = 0x2962FF

    @ColorInt val LIGHT_BLUE_50 = 0xE1F5FE
    @ColorInt val LIGHT_BLUE_100 = 0xB3E5FC
    @ColorInt val LIGHT_BLUE_200 = 0x81D4FA
    @ColorInt val LIGHT_BLUE_300 = 0x4FC3F7
    @ColorInt val LIGHT_BLUE_400 = 0x29B6FC
    @ColorInt val LIGHT_BLUE_500 = 0x03A9F4
    @ColorInt val LIGHT_BLUE_600 = 0x039BE5
    @ColorInt val LIGHT_BLUE_700 = 0x0288D1
    @ColorInt val LIGHT_BLUE_800 = 0x0277BD
    @ColorInt val LIGHT_BLUE_900 = 0x01579B
    @ColorInt val LIGHT_BLUE_A100 = 0x80D8FF
    @ColorInt val LIGHT_BLUE_A200 = 0x40C4FF
    @ColorInt val LIGHT_BLUE_A400 = 0x00B0FF
    @ColorInt val LIGHT_BLUE_A700 = 0x0091EA

    @ColorInt val CYAN_50 = 0xE0F7FA
    @ColorInt val CYAN_100 = 0xB2EBF2
    @ColorInt val CYAN_200 = 0x80DEEA
    @ColorInt val CYAN_300 = 0x4DD0E1
    @ColorInt val CYAN_400 = 0x26C6DA
    @ColorInt val CYAN_500 = 0x00BCD4
    @ColorInt val CYAN_600 = 0x00ACC1
    @ColorInt val CYAN_700 = 0x0097A7
    @ColorInt val CYAN_800 = 0x00838F
    @ColorInt val CYAN_900 = 0x006064
    @ColorInt val CYAN_A100 = 0x84FFFF
    @ColorInt val CYAN_A200 = 0x18FFFF
    @ColorInt val CYAN_A400 = 0x00E5FF
    @ColorInt val CYAN_A700 = 0x00B8D4

    @ColorInt val TEAL_50 = 0xE0F2F1
    @ColorInt val TEAL_100 = 0xB2DFDB
    @ColorInt val TEAL_200 = 0x80CBC4
    @ColorInt val TEAL_300 = 0x4DB6AC
    @ColorInt val TEAL_400 = 0x26A69A
    @ColorInt val TEAL_500 = 0x009688
    @ColorInt val TEAL_600 = 0x00897B
    @ColorInt val TEAL_700 = 0x00796B
    @ColorInt val TEAL_800 = 0x00695C
    @ColorInt val TEAL_900 = 0x004D40
    @ColorInt val TEAL_A100 = 0xA7FFEB
    @ColorInt val TEAL_A200 = 0x64FFDA
    @ColorInt val TEAL_A400 = 0x1DE9B6
    @ColorInt val TEAL_A700 = 0x00BFA5

    @ColorInt val GREEN_50 = 0xE8F5E9
    @ColorInt val GREEN_100 = 0xC8E6C9
    @ColorInt val GREEN_200 = 0xA5D6A7
    @ColorInt val GREEN_300 = 0x81C784
    @ColorInt val GREEN_400 = 0x66BB6A
    @ColorInt val GREEN_500 = 0x4CAF50
    @ColorInt val GREEN_600 = 0x43A047
    @ColorInt val GREEN_700 = 0x388E3C
    @ColorInt val GREEN_800 = 0x2E7D32
    @ColorInt val GREEN_900 = 0x1B5E20
    @ColorInt val GREEN_A100 = 0xB9F6CA
    @ColorInt val GREEN_A200 = 0x69F0AE
    @ColorInt val GREEN_A400 = 0x00E676
    @ColorInt val GREEN_A700 = 0x00C853

    @ColorInt val LIGHT_GREEN_50 = 0xF1F8E9
    @ColorInt val LIGHT_GREEN_100 = 0xDCEDC8
    @ColorInt val LIGHT_GREEN_200 = 0xC5E1A5
    @ColorInt val LIGHT_GREEN_300 = 0xAED581
    @ColorInt val LIGHT_GREEN_400 = 0x9CCC65
    @ColorInt val LIGHT_GREEN_500 = 0x8BC34A
    @ColorInt val LIGHT_GREEN_600 = 0x7CB342
    @ColorInt val LIGHT_GREEN_700 = 0x698F38
    @ColorInt val LIGHT_GREEN_800 = 0x558B2F
    @ColorInt val LIGHT_GREEN_900 = 0x33691E
    @ColorInt val LIGHT_GREEN_A100 = 0xCCFF90
    @ColorInt val LIGHT_GREEN_A200 = 0xB2FF59
    @ColorInt val LIGHT_GREEN_A400 = 0x76FF03
    @ColorInt val LIGHT_GREEN_A700 = 0x64DD17

    @ColorInt val LIME_50 = 0xF9FBE7
    @ColorInt val LIME_100 = 0xF0F4C3
    @ColorInt val LIME_200 = 0xE6EE9C
    @ColorInt val LIME_300 = 0xDCE775
    @ColorInt val LIME_400 = 0xD4E157
    @ColorInt val LIME_500 = 0xCDDC39
    @ColorInt val LIME_600 = 0xC0CA33
    @ColorInt val LIME_700 = 0xA4B42B
    @ColorInt val LIME_800 = 0x9E9D24
    @ColorInt val LIME_900 = 0x827717
    @ColorInt val LIME_A100 = 0xF4FF81
    @ColorInt val LIME_A200 = 0xEEFF41
    @ColorInt val LIME_A400 = 0xC6FF00
    @ColorInt val LIME_A700 = 0xAEEA00

    @ColorInt val YELLOW_50 = 0xFFFDE7
    @ColorInt val YELLOW_100 = 0xFFF9C4
    @ColorInt val YELLOW_200 = 0xFFF590
    @ColorInt val YELLOW_300 = 0xFFF176
    @ColorInt val YELLOW_400 = 0xFFEE58
    @ColorInt val YELLOW_500 = 0xFFEB3B
    @ColorInt val YELLOW_600 = 0xFDD835
    @ColorInt val YELLOW_700 = 0xFBC02D
    @ColorInt val YELLOW_800 = 0xF9A825
    @ColorInt val YELLOW_900 = 0xF57F17
    @ColorInt val YELLOW_A100 = 0xFFFF82
    @ColorInt val YELLOW_A200 = 0xFFFF00
    @ColorInt val YELLOW_A400 = 0xFFEA00
    @ColorInt val YELLOW_A700 = 0xFFD600

    @ColorInt val AMBER_50 = 0xFFF8E1
    @ColorInt val AMBER_100 = 0xFFECB3
    @ColorInt val AMBER_200 = 0xFFE082
    @ColorInt val AMBER_300 = 0xFFD54F
    @ColorInt val AMBER_400 = 0xFFCA28
    @ColorInt val AMBER_500 = 0xFFC107
    @ColorInt val AMBER_600 = 0xFFB300
    @ColorInt val AMBER_700 = 0xFFA000
    @ColorInt val AMBER_800 = 0xFF8F00
    @ColorInt val AMBER_900 = 0xFF6F00
    @ColorInt val AMBER_A100 = 0xFFE57F
    @ColorInt val AMBER_A200 = 0xFFD740
    @ColorInt val AMBER_A400 = 0xFFC400
    @ColorInt val AMBER_A700 = 0xFFAB00

    @ColorInt val ORANGE_50 = 0xFFF3E0
    @ColorInt val ORANGE_100 = 0xFFE0B2
    @ColorInt val ORANGE_200 = 0xFFCC80
    @ColorInt val ORANGE_300 = 0xFFB74D
    @ColorInt val ORANGE_400 = 0xFFA726
    @ColorInt val ORANGE_500 = 0xFF9800
    @ColorInt val ORANGE_600 = 0xFB8C00
    @ColorInt val ORANGE_700 = 0xF57C00
    @ColorInt val ORANGE_800 = 0xEF6C00
    @ColorInt val ORANGE_900 = 0xE65C00
    @ColorInt val ORANGE_A100 = 0xFFD180
    @ColorInt val ORANGE_A200 = 0xFFAB40
    @ColorInt val ORANGE_A400 = 0xFF9100
    @ColorInt val ORANGE_A700 = 0xFF6D00

    @ColorInt val DEEP_ORANGE_50 = 0xFBE9E7
    @ColorInt val DEEP_ORANGE_100 = 0xFFCCBC
    @ColorInt val DEEP_ORANGE_200 = 0xFFAB91
    @ColorInt val DEEP_ORANGE_300 = 0xFF8A65
    @ColorInt val DEEP_ORANGE_400 = 0xFF7043
    @ColorInt val DEEP_ORANGE_500 = 0xFF5722
    @ColorInt val DEEP_ORANGE_600 = 0xF4511E
    @ColorInt val DEEP_ORANGE_700 = 0xE64A19
    @ColorInt val DEEP_ORANGE_800 = 0xD84315
    @ColorInt val DEEP_ORANGE_900 = 0xBF360C
    @ColorInt val DEEP_ORANGE_A100 = 0xFF9E80
    @ColorInt val DEEP_ORANGE_A200 = 0xFF6E40
    @ColorInt val DEEP_ORANGE_A400 = 0xFF3D00
    @ColorInt val DEEP_ORANGE_A700 = 0xFF2600

    @ColorInt val BROWN_50 = 0xEFEBE9
    @ColorInt val BROWN_100 = 0xD7CCC8
    @ColorInt val BROWN_200 = 0xBCAAA4
    @ColorInt val BROWN_300 = 0xA1887F
    @ColorInt val BROWN_400 = 0x8D6E63
    @ColorInt val BROWN_500 = 0x795548
    @ColorInt val BROWN_600 = 0x6D4C41
    @ColorInt val BROWN_700 = 0x5D4037
    @ColorInt val BROWN_800 = 0x4E342E
    @ColorInt val BROWN_900 = 0x3E2723

    @ColorInt val GREY_50 = 0xFAFAFA
    @ColorInt val GREY_100 = 0xF5F5F5
    @ColorInt val GREY_200 = 0xEEEEEE
    @ColorInt val GREY_300 = 0xE0E0E0
    @ColorInt val GREY_400 = 0xBDBDBD
    @ColorInt val GREY_500 = 0x9E9E9E
    @ColorInt val GREY_600 = 0x757575
    @ColorInt val GREY_700 = 0x616161
    @ColorInt val GREY_800 = 0x424242
    @ColorInt val GREY_900 = 0x212121

    @ColorInt val BLUE_GREY_50 = 0xECEFF1
    @ColorInt val BLUE_GREY_100 = 0xCFD8DC
    @ColorInt val BLUE_GREY_200 = 0xB0BBC5
    @ColorInt val BLUE_GREY_300 = 0x90A4AE
    @ColorInt val BLUE_GREY_400 = 0x78909C
    @ColorInt val BLUE_GREY_500 = 0x607D8B
    @ColorInt val BLUE_GREY_600 = 0x546E7A
    @ColorInt val BLUE_GREY_700 = 0x455A64
    @ColorInt val BLUE_GREY_800 = 0x37474F
    @ColorInt val BLUE_GREY_900 = 0x263238

    /**
     * An array containing all 14 RED colors in this library.
     */
    val redColorArray = intArrayOf(RED_50, RED_100, RED_200, RED_300, RED_400, RED_500, RED_600, RED_700, RED_800, RED_900, RED_A100, RED_A200, RED_A400, RED_A700)

    /**
     * An array containing all 14 PINK colors in this library.
     */
    val pinkColorArray = intArrayOf(PINK_50, PINK_100, PINK_200, PINK_300, PINK_400, PINK_500, PINK_600, PINK_700, PINK_800, PINK_900, PINK_A100, PINK_A200, PINK_A400, PINK_A700)

    /**
     * An array containing all 14 PURPLE colors in this library.
     */
    val purpleColorArray = intArrayOf(PURPLE_50, PURPLE_100, PURPLE_200, PURPLE_300, PURPLE_400, PURPLE_500, PURPLE_600, PURPLE_700, PURPLE_800, PURPLE_900, PURPLE_A100, PURPLE_A200, PURPLE_A400, PURPLE_A700)

    /**
     * An array containing all 14 DEEP PURPLE colors in this library.
     */
    val deepPurpleColorArray = intArrayOf(DEEP_PURPLE_50, DEEP_PURPLE_100, DEEP_PURPLE_200, DEEP_PURPLE_300, DEEP_PURPLE_400, DEEP_PURPLE_500, DEEP_PURPLE_600, DEEP_PURPLE_700, DEEP_PURPLE_800, DEEP_PURPLE_900, DEEP_PURPLE_A100, DEEP_PURPLE_A200, DEEP_PURPLE_A400, DEEP_PURPLE_A700)

    /**
     * An array containing all 14 INDIGO colors in this library.
     */
    val indigoColorArray = intArrayOf(INDIGO_50, INDIGO_100, INDIGO_200, INDIGO_300, INDIGO_400, INDIGO_500, INDIGO_600, INDIGO_700, INDIGO_800, INDIGO_900, INDIGO_A100, INDIGO_A200, INDIGO_A400, INDIGO_A700)

    /**
     * An array containing all 14 BLUE colors in this library.
     */
    val blueColorArray = intArrayOf(BLUE_50, BLUE_100, BLUE_200, BLUE_300, BLUE_400, BLUE_500, BLUE_600, BLUE_700, BLUE_800, BLUE_900, BLUE_A100, BLUE_A200, BLUE_A400, BLUE_A700)

    /**
     * An array containing all 14 LIGHT BLUE colors in this library.
     */
    val lightBlueColorArray = intArrayOf(LIGHT_BLUE_50, LIGHT_BLUE_100, LIGHT_BLUE_200, LIGHT_BLUE_300, LIGHT_BLUE_400, LIGHT_BLUE_500, LIGHT_BLUE_600, LIGHT_BLUE_700, LIGHT_BLUE_800, LIGHT_BLUE_900, LIGHT_BLUE_A100, LIGHT_BLUE_A200, LIGHT_BLUE_A400, LIGHT_BLUE_A700)

    /**
     * An array containing all 14 CYAN colors in this library.
     */
    val cyanColorArray = intArrayOf(CYAN_50, CYAN_100, CYAN_200, CYAN_300, CYAN_400, CYAN_500, CYAN_600, CYAN_700, CYAN_800, CYAN_900, CYAN_A100, CYAN_A200, CYAN_A400, CYAN_A700)

    /**
     * An array containing all 14 TEAL colors in this library.
     */
    val tealColorArray = intArrayOf(TEAL_50, TEAL_100, TEAL_200, TEAL_300, TEAL_400, TEAL_500, TEAL_600, TEAL_700, TEAL_800, TEAL_900, TEAL_A100, TEAL_A200, TEAL_A400, TEAL_A700)

    /**
     * An array containing all 14 GREEN colors in this library.
     */
    val greenColorArray = intArrayOf(GREEN_50, GREEN_100, GREEN_200, GREEN_300, GREEN_400, GREEN_500, GREEN_600, GREEN_700, GREEN_800, GREEN_900, GREEN_A100, GREEN_A200, GREEN_A400, GREEN_A700)

    /**
     * An array containing all 14 LIGHT GREEN colors in this library.
     */
    val lightGreenColorArray = intArrayOf(LIGHT_GREEN_50, LIGHT_GREEN_100, LIGHT_GREEN_200, LIGHT_GREEN_300, LIGHT_GREEN_400, LIGHT_GREEN_500, LIGHT_GREEN_600, LIGHT_GREEN_700, LIGHT_GREEN_800, LIGHT_GREEN_900, LIGHT_GREEN_A100, LIGHT_GREEN_A200, LIGHT_GREEN_A400, LIGHT_GREEN_A700)

    /**
     * An array containing all 14 LIME colors in this library.
     */
    val limeColorArray = intArrayOf(LIME_50, LIME_100, LIME_200, LIME_300, LIME_400, LIME_500, LIME_600, LIME_700, LIME_800, LIME_900, LIME_A100, LIME_A200, LIME_A400, LIME_A700)

    /**
     * An array containing all 14 YELLOW colors in this library.
     */
    val yellowColorArray = intArrayOf(YELLOW_50, YELLOW_100, YELLOW_200, YELLOW_300, YELLOW_400, YELLOW_500, YELLOW_600, YELLOW_700, YELLOW_800, YELLOW_900, YELLOW_A100, YELLOW_A200, YELLOW_A400, YELLOW_A700)

    /**
     * An array containing all 14 AMBER colors in this library.
     */
    val amberColorArray = intArrayOf(AMBER_50, AMBER_100, AMBER_200, AMBER_300, AMBER_400, AMBER_500, AMBER_600, AMBER_700, AMBER_800, AMBER_900, AMBER_A100, AMBER_A200, AMBER_A400, AMBER_A700)

    /**
     * An array containing all 14 ORANGE colors in this library.
     */
    val orangeColorArray = intArrayOf(ORANGE_50, ORANGE_100, ORANGE_200, ORANGE_300, ORANGE_400, ORANGE_500, ORANGE_600, ORANGE_700, ORANGE_800, ORANGE_900, ORANGE_A100, ORANGE_A200, ORANGE_A400, ORANGE_A700)

    /**
     * An array containing all 14 DEEP ORANGE colors in this library.
     */
    val deepOrangeColorArray = intArrayOf(DEEP_ORANGE_50, DEEP_ORANGE_100, DEEP_ORANGE_200, DEEP_ORANGE_300, DEEP_ORANGE_400, DEEP_ORANGE_500, DEEP_ORANGE_600, DEEP_ORANGE_700, DEEP_ORANGE_800, DEEP_ORANGE_900, DEEP_ORANGE_A100, DEEP_ORANGE_A200, DEEP_ORANGE_A400, DEEP_ORANGE_A700)

    /**
     * An array containing all 10 BROWN colors in this library.
     */
    val brownColorArray = intArrayOf(BROWN_50, BROWN_100, BROWN_200, BROWN_300, BROWN_400, BROWN_500, BROWN_600, BROWN_700, BROWN_800, BROWN_900)

    /**
     * An array containing all 10 PINK colors in this library.
     */
    val greyColorArray = intArrayOf(GREY_50, GREY_100, GREY_200, GREY_300, GREY_400, GREY_500, GREY_600, GREY_700, GREY_800, GREY_900)

    /**
     * An array containing all 10 BLUE GREY colors in this library.
     */
    val blueGreyColorArray = intArrayOf(BLUE_GREY_50, BLUE_GREY_100, BLUE_GREY_200, BLUE_GREY_300, BLUE_GREY_400, BLUE_GREY_500, BLUE_GREY_600, BLUE_GREY_700, BLUE_GREY_800, BLUE_GREY_900)

    private val arrayOfAllColorArrays = arrayOf(
        redColorArray, pinkColorArray, purpleColorArray, deepPurpleColorArray, indigoColorArray, blueColorArray,
        lightBlueColorArray, cyanColorArray, tealColorArray, greenColorArray, lightGreenColorArray, limeColorArray,
        yellowColorArray, amberColorArray, orangeColorArray, deepOrangeColorArray, brownColorArray, greyColorArray,
        blueGreyColorArray
    )

    /**
     * Gets a random shade of color RED from the [Red Color Array][redColorArray].
     *
     * @return @[ColorInt] RED.
     */
    fun randomRedColor() = redColorArray[(0..redColorArray.size).random()]

    /**
     * Gets a random shade of color PINK from the [Pink Color Array][pinkColorArray].
     *
     * @return @[ColorInt] PINK.
     */
    fun randomPinkColor() = pinkColorArray[(0..pinkColorArray.size).random()]

    /**
     * Gets a random shade of color PURPLE from the [Purple Color Array][purpleColorArray].
     *
     * @return @[ColorInt] PURPLE.
     */
    fun randomPurpleColor() = purpleColorArray[(0..purpleColorArray.size).random()]

    /**
     * Gets a random shade of DEEP PURPLE from the [Deep Purple Color Array][deepPurpleColorArray].
     *
     * @return @[ColorInt] DEEP PURPLE.
     */
    fun randomDeepPurpleColor() = deepPurpleColorArray[(0..deepPurpleColorArray.size).random()]

    /**
     * Gets a random shade of INDIGO from the [Indigo Color Array][indigoColorArray].
     *
     * @return @[ColorInt] INDIGO.
     */
    fun randomIndigoColor() = indigoColorArray[(0..indigoColorArray.size).random()]

    /**
     * Gets a random shade of color BLUE from the [Blue Color Array][blueColorArray].
     *
     * @return @[ColorInt] BLUE.
     */
    fun randomBlueColor() = blueColorArray[(0..blueColorArray.size).random()]

    /**
     * Gets a random shade of color LIGHT BLUE from the [Light Blue Color Array][lightBlueColorArray].
     *
     * @return @[ColorInt] LIGHT BLUE.
     */
    fun randomLightBlueColor() = lightBlueColorArray[(0..lightBlueColorArray.size).random()]

    /**
     * Gets a random shade of color CYAN  from the [Cyan Color Array][cyanColorArray].
     *
     * @return @[ColorInt] CYAN.
     */
    fun randomCyanColor() = cyanColorArray[(0..cyanColorArray.size).random()]

    /**
     * Gets a random shade of color TEAL from the [Teal Color Array][tealColorArray].
     *
     * @return @[ColorInt] TEAL.
     */
    fun randomTealColor() = tealColorArray[(0..tealColorArray.size).random()]

    /**
     * Gets a random shade of color GREEN from the [Green Color Array][greenColorArray].
     *
     * @return @[ColorInt] GREEN.
     */
    fun randomGreenColor() = greenColorArray[(0..greenColorArray.size).random()]

    /**
     * Gets a random shade of color LIGHT GREEN from the [Light Green Color Array][lightGreenColorArray].
     *
     * @return @[ColorInt] LIGHT GREEN.
     */
    fun randomLightGreenColor() = lightGreenColorArray[(0..lightGreenColorArray.size).random()]

    /**
     * Gets a random shade of color LIME from the [Lime Color Array][limeColorArray].
     *
     * @return @[ColorInt] LIME.
     */
    fun randomLimeColor() = limeColorArray[(0..limeColorArray.size).random()]

    /**
     * Gets a random shade of color YELLOW from the [Yellow Color Array][yellowColorArray].
     *
     * @return @[ColorInt] YELLOW.
     */
    fun randomYellowColor() = yellowColorArray[(0..yellowColorArray.size).random()]

    /**
     * Gets a random shade of color AMBER from the [Amber Color Array][amberColorArray].
     *
     * @return @[ColorInt] AMBER.
     */
    fun randomAmberColor() = amberColorArray[(0..amberColorArray.size).random()]

    /**
     * Gets a random shade of color ORANGE from the [Orange Color Array][orangeColorArray].
     *
     * @return @[ColorInt] ORANGE.
     */
    fun randomOrangeColor() = orangeColorArray[(0..orangeColorArray.size).random()]

    /**
     * Gets a random shade of color DEEP ORANGE from the [Deep Orange Color Array][deepOrangeColorArray].
     *
     * @return @[ColorInt] DEEP ORANGE.
     */
    fun randomDeepOrangeColor() = deepOrangeColorArray[(0..deepOrangeColorArray.size).random()]

    /**
     * Gets a random shade of color BROWN from the [Brown Color Array][brownColorArray].
     *
     * @return @[ColorInt] BROWN.
     */
    fun randomBrownColor() = brownColorArray[(0..brownColorArray.size).random()]

    /**
     * Gets a random shade of color GREY from the [Grey Color Array][greyColorArray].
     *
     * @return @[ColorInt] GREY.
     */
    fun randomGreyColor() = greyColorArray[(0..greyColorArray.size).random()]

    /**
     * Gets a random shade of color BLUE GREY from the [Blue Grey Color Array][blueGreyColorArray].
     *
     * @return @[ColorInt] BLUE GREY.
     */
    fun randomBlueGreyColor() = blueGreyColorArray[(0..blueGreyColorArray.size).random()]

    /**
     * Picks a random color from one of the [MaterialPaletteColors].
     *
     */
    fun selectRandomColor(): Int {
        val anyColorIntArray = arrayOfAllColorArrays[(0..arrayOfAllColorArrays.size).random()]
        return anyColorIntArray[((0..anyColorIntArray.size).random())]
    }

}