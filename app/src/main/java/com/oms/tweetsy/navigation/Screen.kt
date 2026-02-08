package com.oms.tweetsy.navigation

sealed class Screen(val route: String) {
    object Category : Screen("category")
    object Detail : Screen("detail/{category}") {
        fun createRoute(category: String) = "detail/$category"
    }
}

