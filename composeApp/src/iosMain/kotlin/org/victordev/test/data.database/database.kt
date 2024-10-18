package org.victordev.test.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

fun getDataBaseBuilder(): RoomDatabase.Builder<MoviesDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder<MoviesDatabase>(
        name = dbFilePath,
        factory = { MoviesDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}