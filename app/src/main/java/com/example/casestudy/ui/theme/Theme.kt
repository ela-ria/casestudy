package com.example.casestudy.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Dark Theme (use lighter pinks for contrast)
private val DarkColorScheme = darkColorScheme(
    primary = PinkLight80,
    secondary = PinkLightGrey80,
    tertiary = PinkAccent80
)

// Light Theme (use deeper pinks)
private val LightColorScheme = lightColorScheme(
    primary = PinkDark40,
    secondary = PinkGrey40,
    tertiary = PinkAccent40

    /* You can also override other colors if needed:
    background = Color(0xFFFFF0F5),  // very light pink
    surface = Color(0xFFFFF0F5),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF3B002F),
    onSurface = Color(0xFF3B002F),
    */
)

@Composable
fun CasestudyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
