package org.victordev.test

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.victordev.test.data.Movie
import org.victordev.test.ui.screens.home.MovieItem

@Composable
@Preview
fun PreviewMovieItem(){
    MovieItem(
        movie = Movie(
            id = 238,
            title = "El Padrino",
            popularity = 100.5,
            poster = "https://image.tmdb.org/t/p/w500/rPdtLWNsZmAtoZl9PK7S2wE3qiS.jpg",
            overview = "El patriarca envejecido de una dinastía del crimen organizado en Nueva York transfiere el control de su imperio clandestino a su hijo reacio.",
            releaseDate = "1972-03-14",
            backdrop = "https://image.tmdb.org/t/p/w500/6xKCYgH16UuwEGAyroLU6p8HLIn.jpg",
            originalLanguage = "en",
            originalTitle = "The Godfather",
            voteAverage = 8.7
        )
    ){

    }
}