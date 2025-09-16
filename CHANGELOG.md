Change Log
==========

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

* **1.0.1**
    * Changed library name from MaterialPaletteColors to DesignColors to accommodate other design colors. 
    * Added Flat Design Colors. 
    * Changed color constants to RGB values.

* **1.0.0**
    * Initial release