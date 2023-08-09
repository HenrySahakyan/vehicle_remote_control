package com.example.vehicleremotecontrol.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vehicleremotecontrol.ui.screen.test.Screen2
import com.example.vehicleremotecontrol.ui.screen.test.Screen3
import com.example.vehicleremotecontrol.ui.screen.test.Screen4
import com.example.vehicleremotecontrol.ui.screen.test.Screen5
import com.example.vehicleremotecontrol.ui.screen.home.HomeScreen
import com.example.vehicleremotecontrol.ui.screen.home.HomeViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "screen_1") {
        composable("screen_1") {
            HomeScreen()
        }
        composable("screen_2") {
            Screen2()
        }
        composable("screen_3") {
            Screen3()
        }
        composable("screen_4") {
            Screen4()
        }
        composable("screen_5") {
            Screen5()
        }
    }
}