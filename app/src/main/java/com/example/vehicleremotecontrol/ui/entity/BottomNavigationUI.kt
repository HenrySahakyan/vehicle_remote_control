package com.example.vehicleremotecontrol.ui.entity

data class BottomNavigationUI(
    val title: String,
    val iconId: Int,
    val route: String
)

data class BottomNavigationItemsUI(
    val bottomList : List<BottomNavigationUI>
)