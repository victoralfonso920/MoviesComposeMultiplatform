package org.victordev.test.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import org.victordev.test.data.database.MoviesDao

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

class MoviesRepository(
    private val moviesServices: MoviesServices,
    private val moviesDao: MoviesDao
) {


    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies().onEach{ movies ->
        if(movies.isEmpty()){
            val popularMovies = moviesServices.fetchPopularMovies().results.map { it.toDomainMovie() }
            moviesDao.save(popularMovies)
        }
    }

    suspend fun fetchMovieById(id: Int): Flow<Movie?>  = moviesDao.fetchMovieById(id).onEach {  movie ->
        if(movie == null){
            val remoteMovie = moviesServices.fetchMovieById(id).toDomainMovie()
            moviesDao.save(listOf(remoteMovie))
        }
    }
}

private fun RemoteMovie.toDomainMovie() = Movie(
    id = this.id,
    title = this.title,
    poster = "https://image.tmdb.org/t/p/w185${this.posterPath}",
    overview = this.overview,
    backdrop = backdropPath?.let { "https://image.tmdb.org/t/p/w780/$it" },
    originalTitle = this.originalTitle,
    originalLanguage = this.originalLanguage,
    popularity = this.popularity,
    releaseDate = this.releaseDate,
    voteAverage = this.voteAverage


)