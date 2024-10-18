package org.victordev.test.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

class MoviesServices(
    private val client: HttpClient
) {
    suspend fun fetchPopularMovies(): RemoteResult {
        return client.get("/3/discover/movie?sort_by=popularity.desc")
            .body<RemoteResult>()
    }

    suspend fun fetchMovieById(id: Int): RemoteMovie {
        return client.get("/3/movie/$id")
            .body<RemoteMovie>()
    }

}