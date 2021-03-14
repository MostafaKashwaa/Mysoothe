/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.HomeScreen
import com.example.androiddevchallenge.components.LoginScreen
import com.example.androiddevchallenge.components.WelcomeScreen

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object WelcomeScreen : Screen("welcomeScreen", R.string.WelcomeScreen)
    object LoginScreen : Screen("loginScreen", R.string.LoginScreen)
    object HomeScreen : Screen("homeScreen", R.string.HomeScreen)
    object ProfileScreen : Screen("profileScreen", R.string.ProfileScreen)
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(
                onSignUpClick = { },
                onLoginClick = { navController.navigate(route = Screen.LoginScreen.route) }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                onSignUpClick = { /*TODO*/ },
                onLoginClick = {
                    navController.navigate(route = Screen.HomeScreen.route) {
                        popUpTo = navController.currentDestination!!.id
                    }
                }
            )
        }
        composable(Screen.HomeScreen.route) { HomeScreen() }
        composable(Screen.ProfileScreen.route) {}
    }
}
