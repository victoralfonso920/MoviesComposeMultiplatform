package org.victordev.test.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.victordev.test.ui.screens.detail.DetailsScreen
import org.victordev.test.ui.screens.home.HomeScreen

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


