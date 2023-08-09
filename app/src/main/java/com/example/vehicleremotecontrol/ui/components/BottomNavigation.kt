package com.example.vehicleremotecontrol.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vehicleremotecontrol.data.entity.generateBottoms
import com.example.vehicleremotecontrol.data.mapper.toUI
import com.example.vehicleremotecontrol.ui.theme.IconSelectedColor
import com.example.vehicleremotecontrol.ui.theme.IconUnSelectedColor

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val bottomNavData = generateBottoms().toUI()
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        ) {

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        bottomNavData.bottomList.forEach { item ->
            val selected = currentRoute == item.route
            BottomNavigationItem(
                modifier = Modifier.fillMaxHeight(),
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = "Icon"
                        )
                    }


                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )

                },
                selectedContentColor = IconSelectedColor,
                unselectedContentColor = IconUnSelectedColor
            )
        }
    }
}