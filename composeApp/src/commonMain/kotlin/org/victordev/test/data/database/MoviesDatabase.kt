package org.victordev.test.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.victordev.test.data.Movie

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

const val DATABASE_NAME = "movies.db"

interface DB {
    fun clearAllTables()
}

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() , DB {
    abstract fun moviesDao(): MoviesDao

    override fun clearAllTables() = Unit
}