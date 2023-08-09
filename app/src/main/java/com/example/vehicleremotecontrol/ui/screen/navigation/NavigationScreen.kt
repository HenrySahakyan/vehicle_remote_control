package com.example.vehicleremotecontrol.ui.screen.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.vehicleremotecontrol.ui.components.BottomNavigation
import com.example.vehicleremotecontrol.ui.navigation.NavGraph


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationScreen() {


    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        NavGraph(navHostController = navController)
    }
}