package org.victordev.test.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinmultiplatformproject.composeapp.generated.resources.Res
import kotlinmultiplatformproject.composeapp.generated.resources.api_key
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.victordev.test.BuildConfig
import org.victordev.test.data.MoviesRepository
import org.victordev.test.data.MoviesServices
import org.victordev.test.data.database.MoviesDao
import org.victordev.test.ui.screens.detail.DetailViewModel
import org.victordev.test.ui.screens.detail.DetailsScreen
import org.victordev.test.ui.screens.home.HomeScreen
import org.victordev.test.ui.screens.home.HomeViewModel

// Created by Victor Hernandez on 9/26/24.
// Proyect KotlinMultiplatformProject
//contact victoralfonso920@gmail.com

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                },
            )
        }
        composable(
            "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) {
            val movieID = checkNotNull(it.arguments?.getInt("movieId"))
            DetailsScreen(
                vm = koinViewModel(parameters = { parametersOf(movieID)}),
                onBack = { navController.popBackStack() }
            )
        }
    }
}


