package com.oms.tweetsy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.oms.tweetsy.screen.CategoryScreen
import com.oms.tweetsy.screen.DetailScreen

@Composable
fun ScreenNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
    navController = navController,
    startDestination = Screen.Category.route
    ) {
        composable(route = Screen.Category.route){
            CategoryScreen{
                navController.navigate(
                    Screen.Detail.createRoute(it)
                )
            }
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(Screen.Category.route){
                    type = NavType.StringType
                }
            )
        ){
            DetailScreen()
        }
    }
}