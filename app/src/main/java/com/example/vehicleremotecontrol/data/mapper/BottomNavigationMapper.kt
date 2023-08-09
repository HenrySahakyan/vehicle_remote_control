package com.example.vehicleremotecontrol.data.mapper

import com.example.vehicleremotecontrol.data.entity.BottomNavigation
import com.example.vehicleremotecontrol.data.entity.BottomNavigationItems
import com.example.vehicleremotecontrol.ui.entity.BottomNavigationItemsUI
import com.example.vehicleremotecontrol.ui.entity.BottomNavigationUI

fun BottomNavigation.toUi(): BottomNavigationUI = BottomNavigationUI(
    title =title,
    iconId=iconId,
    route=route
)

fun BottomNavigationItems.toUI() : BottomNavigationItemsUI = BottomNavigationItemsUI(
    bottomList=bottomList.toUi()
)

fun List<BottomNavigation>.toUi(): List<BottomNavigationUI> = map { it.toUi() }