package org.victordev.test.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val poster:String,
    val overview:String,
    val releaseDate:String,
    val backdrop:String?,
    val originalTitle:String,
    val originalLanguage:String,
    val popularity:Double,
    val voteAverage:Double,
)
