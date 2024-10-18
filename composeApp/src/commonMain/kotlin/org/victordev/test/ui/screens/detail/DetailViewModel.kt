package org.victordev.test.ui.screens.detail

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

class DetailViewModel(
    private val id: Int,
    private val repository: MoviesRepository
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.fetchMovieById(id).collect { movie ->
                movie?.let {
                    state = DetailState(
                        isLoading = false,
                        movie = it
                    )
                }
            }
        }

    }

    data class DetailState(
        val isLoading: Boolean = false,
        val movie: Movie? = null
    )

}