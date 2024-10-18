package org.victordev.test.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Created by Victor Hernandez on 9/17/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

@Composable
fun Screen(screenContent: @Composable () -> Unit){
    val isDarkMode = isSystemInDarkTheme()
    val colorScheme = if (isDarkMode)  darkColorScheme() else lightColorScheme()
    MaterialTheme(colorScheme = colorScheme){
        Surface (
            modifier = Modifier.fillMaxSize(),
            content = screenContent
        )
    }
}