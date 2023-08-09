package com.example.vehicleremotecontrol.data.entity

data class BottomNavigation (
    val title: String,
    val iconId: Int,
    val route: String
)

data class BottomNavigationItems(
    val bottomList: List<BottomNavigation>
)
