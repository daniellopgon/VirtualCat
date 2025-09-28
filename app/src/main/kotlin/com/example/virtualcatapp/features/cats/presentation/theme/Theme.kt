package com.example.virtualcatapp.presentation.presentation.di.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.virtualcatapp.cats.presentation.theme.DarkText
import com.example.virtualcatapp.cats.presentation.theme.SoftBackground
import com.example.virtualcatapp.cats.presentation.theme.SoftBlue
import com.example.virtualcatapp.cats.presentation.theme.SoftPink
import com.example.virtualcatapp.cats.presentation.theme.SoftPurple
import com.example.virtualcatapp.cats.presentation.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = SoftPurple,
    secondary = SoftPink,
    tertiary = SoftBlue
)

private val LightColorScheme = lightColorScheme(
    primary = SoftPurple,
    secondary = SoftPink,
    tertiary = SoftBlue,
    background = SoftBackground,
    onBackground = DarkText
)

@Composable
fun VirtualCatAppTheme(
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