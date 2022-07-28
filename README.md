DesignColors
============

This is a library that provides a Singleton class containing default colors specified in the: 
- [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation).
- Flat Design Color system used in web design.

It provides helper methods for selecting random colors in any of these coloring systems.

Uses
----
Use DesignColors when you specifically need to work with Material or Flat Design Colors in Kotlin code.

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

Changelog
---------
* **1.0.1**
    * Changed library name from MaterialPaletteColors to DesignColors to accommodate other design colors.
    * Added Flat Design Colors.
    * Changed color constants to RGB values.
  
* **1.0.0**
    * Initial release
