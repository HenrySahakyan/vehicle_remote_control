package com.example.vehicleremotecontrol.data.mapper

import com.example.vehicleremotecontrol.data.entity.Action
import com.example.vehicleremotecontrol.data.entity.BottomNavigation
import com.example.vehicleremotecontrol.data.entity.Home
import com.example.vehicleremotecontrol.ui.entity.ActionUi
import com.example.vehicleremotecontrol.ui.entity.BottomNavigationUI
import com.example.vehicleremotecontrol.ui.entity.HomeUi

fun Home.toUi(): HomeUi = HomeUi(
    title = title,
    actions = actions.toUi(),
)

fun List<Action>.toUi(): List<ActionUi> = map { it.toUi() }



fun Action.toUi(): ActionUi = ActionUi(
    title = title,
    isSelected = isSelected,
    imageBorder = imageBorder,
    imageInner = imageInner,
    isClicked = isClicked,
    isLoading = isLoading,
    buttonColor = buttonColor
)





