DesignColors
============

[<img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/IODevBlue/DesignColors?label=Current Version&color=2CCCE4&style=for-the-badge&labelColor=0109B6">](https://github.com/IODevBlue/DesignColors/releases) <img alt="Repository Size" src="https://img.shields.io/github/repo-size/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6"> [<img alt="License" src="https://img.shields.io/github/license/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6">](http://www.apache.org/licenses/LICENSE-2.0) [<img alt="GitHub Repository stars" src="https://img.shields.io/github/stars/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6">](https://github.com/IODevBlue/DesignColors/stargazers)
<img alt="GitHub watchers" src="https://img.shields.io/github/watchers/IODevBlue/DesignColors?label=Repository Watchers&color=2CCCE4&style=for-the-badge&labelColor=0109B6"> [<img alt="Gradle version" src="https://img.shields.io/static/v1?label=Gradle version&message=9.0.0&color=2CCCE4&style=for-the-badge&labelColor=0109B6">](https://docs.gradle.org/9.0.0/release-notes) [<img alt="Kotlin version" src="https://img.shields.io/static/v1?label=Kotlin version&message=2.2.20&color=2CCCE4&style=for-the-badge&labelColor=0109B6">](https://kotlinlang.org/docs/whatsnew2220.html)

This is a library that provides a Singleton class containing default colors specified in the: 
- [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation).
- [Flat UI Colors](https://flatuicolors.com/)
- [Apple Human Interface Guidelines](https://developer.apple.com/design/human-interface-guidelines/foundations/color)
- [Atlassian Design System](https://atlassian.design/foundations/color/)
- [Bootstrap](https://getbootstrap.com/docs/5.3/customize/color/)
- [Microsoft Fluent UI](https://developer.microsoft.com/en-us/fluentui#/styles/web/colors)
- Official Brand Colors: A curated set of official colors from various mainstream companies such as Google, X (formerly Twitter), Instagram, and YouTube, ensuring brand consistency in your UI.

Uses
----
Use DesignColors: 
- When you specifically need to work with Material, Flat Design Colors or any other design palette in Kotlin code or multi-platform project.
- When you need to reference design colors from mainstream apps for personal purposes.

This is a singleton class and can directly be copied into your project module.

Features
--------
- Supports conversion from and to Jetpack Compose [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color) class.
- Utility functions for working with colors:
  - Add alpha transparency (int or float values).
  - Detect whether a color is light or dark.
  - Extract RGB values or create colors from RGB components.
  - Convert between Android `ColorInt` and Jetpack Compose `Color`.


Installation
------------
**current-version: v1.2.0**


Material Design Colors
----------------------
<p align="center">
    <img src="/art/material-design-color-chart.png" alt="Material Design Color Chart">
</p>

Usage
-----
To select Material Blue 50:
```KOTLIN
val blue50 = DesignColors.MaterialDesign.BLUE_50
```

Then apply it to a View or Widget:
```KOTLIN
val textView: TextView = findViewById(R.id.name_textview)
textView.background = blue50
```

To retrieve all Material Blue Colors in an Integer Array:
```KOTLIN
val blueColors = DesignColors.MaterialDesign.blueColorArray
```

To choose a random Material Blue Color:
```KOTLIN
val randomBlueColor = DesignColors.MaterialDesign.randomBlueColor()
```

To choose a random Material Color:
```KOTLIN
val randomMaterialColor = DesignColors.MaterialDesign.selectRandomColor()
```

Flat Design Colors
------------------
<p align="center">
    <img src="/art/flat-design-color-chart.png" alt="Flat Design Color Chart">
</p>

Usage
-----
To select Flat Design Midnight Blue 50:
```KOTLIN
val midNightBlue50 = DesignColors.FlatDesign.MIDNIGHT_BLUE_50
```

Then apply it to a View or Widget:
```KOTLIN
val textView: TextView = findViewById(R.id.email_textview)
textView.background = midNightBlue50
```

To retrieve all Flat Design Midnight Blue in an Integer Array:
```KOTLIN
val midnightBlueColors = DesignColors.FlatDesign.midNightBlueColorArray
```

To choose a random Flat Design Midnight Blue Color:
```KOTLIN
val randomMidnightBlueColor = DesignColors.FlatDesign.randomMidNightBlueColor()
```

To choose a random Flat Design Color:
```KOTLIN
val randomFlatDesignColor = DesignColors.FlatDesign.selectRandomColor()
```

Special
-------
To choose YouTube Red:
```KOTLIN
val youtubeRed = DesignColors.YouTube.RED 
``` 

To select Snapchat Yellow:
```KOTLIN
val snapchatYellow = DesignColors.Snapchat.YELLOW
``` 

Java Interoperability
---------------------
Design Colors is completely interoperable in Java.

To select Material Blue 50:
```JAVA
int blue50 = DesignColors.MaterialDesign.getBLUE_50();
``` 

To select Flat Design Midnight Blue 50:
```JAVA
int midNightBlue50 = DesignColors.FlatDesign.getMIDNIGHT_BLUE_50();
```

To select Facebook Messenger's Light Blue:
```JAVA
int midNightBlue50 = DesignColors.Facebook.Messenger.getLIGHT_BLUE();
```

Using the `INSTANCE` to access each method and variable for any singleton object is legal however it is a longer syntax.
```JAVA
int midNightBlue50 = DesignColors.Facebook.Messenger.INSTANCE.getLIGHT_BLUE();
```

Changelog
---------
* **1.2.0**
    * **New Design Systems**: Added color palettes for Apple HIG, Atlassian, Bootstrap and Microsoft Fluent UI.
    * **Compose Color Utilities**: Included new utility functions for converting between Android `ColorInt` and Jetpack Compose `Color` types:
      - `toComposeColor(@ColorInt color: Int)`
      - `toComposeColor(color: Long)`
      - `fromComposeColor(color: androidx.compose.ui.graphics.Color)`
    * **Expanded Brand Colors**: Added colors for X (formerly Twitter).
  
* **1.1.2**
    * Included `@JvmStatic` to ease Java interoperability.
    * Added utility function `getRGB()` and `createColor()`.

* **1.1.1**
    * Added Utility functions `addAlpha()` and `isDarkColor()`
    * Added design colors for popular brands: Google, Twitter, Instagram, Youtube, Pinterest etc.

License
-------
```
    Copyright 2022-2025 IO DevBlue
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```