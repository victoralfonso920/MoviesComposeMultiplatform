package org.victordev.test.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

fun getDataBaseBuilder(ctx: Context): RoomDatabase.Builder<MoviesDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath,
    )
}