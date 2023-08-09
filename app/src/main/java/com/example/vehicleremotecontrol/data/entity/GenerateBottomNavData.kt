package com.example.vehicleremotecontrol.data.entity

import com.example.vehicleremotecontrol.R

fun generateBottomData(): List<BottomNavigation> = listOf(

    BottomNavigation("Home", R.drawable.ic_home,"screen_1"),
    BottomNavigation("Vehicle", R.drawable.ic_vehicle,"screen_2"),
    BottomNavigation("Map", R.drawable.ic_map,"screen_3"),
    BottomNavigation("Support", R.drawable.ic_support,"screen_4"),
    BottomNavigation("Settings", R.drawable.ic_settings,"screen_5"),


)

fun generateBottoms():BottomNavigationItems= BottomNavigationItems(
    bottomList = generateBottomData()
)
