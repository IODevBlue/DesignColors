DesignColors
============

This is a library that provides a Singleton class containing default colors specified in the: 
- [Material Color System](https://material.io/design/color/the-color-system.html#color-theme-creation).
- Flat Design Color system used in web design.
- Official colors for several mainstream companies: Google, Twitter, Instagram, YouTube etc.

It provides helper methods for selecting random colors in any of these coloring systems.

Uses
----
Use DesignColors: 
- When you specifically need to work with Material or Flat Design Colors in Kotlin code.
- When you need to reference design colors mainstream apps for personal purposes.

This is a singleton class and can directly be copied into your project module.

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
* **1.1.2**
    * Included `@JvmStatic` to ease Java interoperability.
    * Added utility function `getRGB()` and `createColor()`.

* **1.1.1**
    * Added Utility functions `addAlpha()` and `isDarkColor()`
    * Added design colors for popular brands: Google, Twitter, Instagram, Youtube, Pinterest etc.
  
* **1.0.1**
    * Changed library name from MaterialPaletteColors to DesignColors to accommodate other design colors.
    * Added Flat Design Colors.
    * Changed color constants to RGB values.
  
* **1.0.0**
    * Initial release


License
-------
```
    Copyright 2022 IO DevBlue
    
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