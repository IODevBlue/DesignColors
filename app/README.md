MaterialPaletteColors
=====================

This is a library that provides a Singleton class containing default colors specified by the [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation)

It provides helper methods to help in selecting random Material Colors.

Material Design Colors
----------------------
<p align="center">
    <img src="/art/color_res.jpg" alt="Material Design Colors">
</p>

Usage
-----
To select Material Blue 50:
```KOTLIN
val blue_50 = MaterialPaletteColors.BLUE_50
```

Then apply it to a View or Widget:
```KOTLIN
val textView: TextView = findViewById(R.id.name_textview)
textView.background = blue_50
```

To retrieve all Material Blue Colors in an Integer Array:
```KOTLIN
val blueColors = MaterialPaletteColors.blueColorArray
```

To choose a random Material Blue Color:
```KOTLIN
val randomBlueColor = MaterialPaletteColors.randomBlueColor()
```

To choose a random Material Color:
```KOTLIN
val randomMaterialColor = MaterialPaletteColors.selectRandomColor()
```

Use MaterialPaletteColors when you specifically need to work with Material Design Colors in Kotlin code.

Changelog
---------
* **1.0.0**
    * Initial release