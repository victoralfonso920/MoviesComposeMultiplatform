package org.victordev.test

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.logger.Level
import org.koin.android.ext.koin.androidLogger
import org.victordev.test.di.initKoin

// Created by Victor Hernandez on 10/7/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

class MoviesApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MoviesApp)
        }
    }
}