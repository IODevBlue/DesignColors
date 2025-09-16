DesignColors
============

[![Current Version](https://img.shields.io/github/v/tag/IODevBlue/DesignColors?label=Current%20Version&color=2CCCE4&style=for-the-badge&labelColor=0109B6)](https://github.com/IODevBlue/DesignColors/releases)
[![Repo Size](https://img.shields.io/github/repo-size/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6)](https://github.com/IODevBlue/DesignColors)
[![License](https://img.shields.io/github/license/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6)](http://www.apache.org/licenses/LICENSE-2.0)
[![Stars](https://img.shields.io/github/stars/IODevBlue/DesignColors?color=2CCCE4&style=for-the-badge&labelColor=0109B6)](https://github.com/IODevBlue/DesignColors/stargazers)
[![Gradle](https://img.shields.io/static/v1?label=Gradle&message=9.0.0&color=2CCCE4&style=for-the-badge&labelColor=0109B6)](https://docs.gradle.org/9.0.0/release-notes)
[![Kotlin](https://img.shields.io/static/v1?label=Kotlin&message=2.2.20&color=2CCCE4&style=for-the-badge&labelColor=0109B6)](https://kotlinlang.org/docs/whatsnew2220.html)

This is a library that provides a Singleton class containing default colors specified in the: 
- [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation).
- [Flat UI Colors](https://flatuicolors.com/)
- [Apple Human Interface Guidelines](https://developer.apple.com/design/human-interface-guidelines/foundations/color)
- [Atlassian Design System](https://atlassian.design/foundations/color/)
- [Bootstrap](https://getbootstrap.com/docs/5.3/customize/color/)
- [Microsoft Fluent UI](https://developer.microsoft.com/en-us/fluentui#/styles/web/colors)
- Official Brand Colors: A curated set of official colors from various mainstream companies such as Google, X (formerly Twitter), Instagram, and YouTube, ensuring brand consistency in your UI.

Table of content
----------------
- [Uses](https://github.com/IODevBlue/DesignColors/tree/main#uses)
- [Features](https://github.com/IODevBlue/DesignColors/tree/main#features)
- [Installation](https://github.com/IODevBlue/DesignColors/tree/main#installation)
- [Usage](https://github.com/IODevBlue/DesignColors/tree/main#usage)
- [Java interoperability](https://github.com/IODevBlue/DesignColors/tree/main#java-interoperability)
- [Contributions](https://github.com/IODevBlue/DesignColors/tree/main#contributions)
- [Changelog](https://github.com/IODevBlue/DesignColors/tree/main#changelog)
- [License](https://github.com/IODevBlue/DesignColors/tree/main#license)

Uses
----
The DesignColors singleton provides easy access to a wide variety of predefined color palettes from major design systems and popular brands. 
Use it when you need:
- Direct access to Material, Flat UI, Apple, Atlassian, Bootstrap, Microsoft Fluent, or curated brand color palettes in Kotlin code or multi-platform Kotlin projects. 
- To reference official colors from mainstream apps for personal projects, prototypes, or design consistency. 
- A centralized color utility for apps where consistent color theming is important.

Features
--------
DesignColors includes utility functions and extensions to make working with colors in Kotlin simpler:
* **Color conversion support:**
  - Convert between Android `ColorInt` and Jetpack Compose [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color).

* **Alpha transparency:**
  - Apply alpha (opacity) to colors using either integer or float values.

* **Color analysis:**
  - Determine if a color is light or dark.

* **RGB utilities:**
  - Extract RGB components or construct colors from RGB values.

* **Jetpack Compose extensions:**
  - Convert ColorInt values to Compose Color objects seamlessly.

Installation
------------
**current-version: v1.2.1**

There are several ways to install this library.

Grab a JAR artifact from the Maven Central Repository:
```kotlin
//build.gradle.kts
implementation ("io.github.iodevblue:designcolors:${current-version}")
```

- If it is a snapshot version, add the Sonatype OSS Nexus snapshots repository.:
```kotlin
//build.gradle.kts
maven {
    url = uri("https://central.sonatype.com/repository/maven-snapshots/")
}
```
- Then retrieve a copy:
```kotlin
//build.gradle.kts
implementation ("io.github.iodevblue:designcolors:${current-version}-SNAPSHOT")
```

Grab a JAR or AAR artifact from the [release](https://github.com/IODevBlue/DesignColors/releases) section. 

Place it in `libs` folder in your project module and install in your project.
```kotlin
//build.gradle.kts
implementation(fileTree("libs") { include("*.jar", "*.aar") })
```

Material Design Colors
----------------------
<p style="text-align: center;">
    <img src="/art/material-design-color-chart.png" alt="Material Design Color Chart">
</p>

Usage
-----
To select Material Blue 50:
```kotlin
val blue50 = DesignColors.MaterialDesign.BLUE_50
```

Then apply it to a View or Widget:
```kotlin
val textView: TextView = findViewById(R.id.name_textview)
textView.background = blue50
```

You can convert the color to a Jetpack Compose Color and use in a composable:
```kotlin
Text(
    text = "Exit", 
    modifier = modifier
        .background(DesignColors.MaterialDesign.BLUE_300.toComposeColor(), shape = AbsoluteRoundedCornerShape(10.dp))
        .padding(20.dp), 
    color = DesignColors.MaterialDesign.BLUE_50.toComposeColor()
)
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

Contributions
-------------
Contributors are welcome!

If you would like to add your startup or company's official colors to this library, you can do so by contributing. Your additions help make this a more comprehensive and useful resource for designers and developers.

**NOTE:** This repository is organized into two branches:
- [main](https://github.com/IODevBlue/DesignColors/tree/main) branch: contains stable, finalized updates.
- [development](https://github.com/IODevBlue/DesignColors/tree/development) branch: used for active development and proposed changes.

Check the [Contributing](https://github.com/IODevBlue/DesignColors/blob/development/CONTRIBUTING.md) for more information.


Changelog
---------
* **1.2.1**
    * Added extensions to convert between Android colors and Jetpack Compose colors:
      - `Int.toComposeColor()` – Converts an Android `@ColorInt` Int to a Compose Color.
      - `Long.toComposeColor()` – Converts a packed ARGB Long to a Compose Color.
      - `Color.toColorInt()` – Converts a Jetpack Compose Color back to an Android @ColorInt Int.

Check the [CHANGELOG](https://github.com/IODevBlue/DesignColors/blob/development/CHANGELOG.md) for all previous releases.

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