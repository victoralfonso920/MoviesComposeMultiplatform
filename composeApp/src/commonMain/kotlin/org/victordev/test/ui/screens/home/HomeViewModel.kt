package org.victordev.test.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.victordev.test.data.Movie
import org.victordev.test.data.MoviesRepository

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

class HomeViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            moviesRepository.movies.collect { movies ->
                if (movies.isNotEmpty()) {
                    state = HomeState(
                        isLoading = false,
                        movies = movies
                    )
                }
            }
        }
    }

    data class HomeState(
        val movies: List<Movie> = emptyList(),
        val isLoading: Boolean = false
    )
}


