package com.example.vehicleremotecontrol.data.entity

import com.example.vehicleremotecontrol.R
import com.example.vehicleremotecontrol.ui.theme.SelectedButtonColor
import com.example.vehicleremotecontrol.ui.theme.UnSelectedButtonColor


fun generateHomeData(): Home = Home(
    title = "MY NISSAN ARIYA",
    actions = generateAction()
)

private fun generateAction(): List<Action> = listOf(
    Action(
        title = "Lock",
        isSelected = true,
        imageBorder = R.drawable.ic_cycle_selected,
        imageInner = R.drawable.ic_lock,
        isClicked = false,
        isLoading = false,
        buttonColor = SelectedButtonColor
    ),
    Action(
        title = "Unlock",
        isSelected = false,
        imageBorder = R.drawable.ic_cycle,
        imageInner = R.drawable.ic_unlock,
        isClicked = false,
        isLoading = false,
        buttonColor = UnSelectedButtonColor
    ),
    Action(
        title = "Climate",
        isSelected = false,
        imageBorder = R.drawable.ic_cycle,
        imageInner = R.drawable.ic_climate,
        isClicked = false,
        isLoading = false,
        buttonColor = UnSelectedButtonColor
    ),
    Action(
        title = "Charge",
        isSelected = false,
        imageBorder = R.drawable.ic_cycle,
        imageInner = R.drawable.ic_charge,
        isClicked = false,
        isLoading = false,
        buttonColor = UnSelectedButtonColor
    ),
    Action(
        title = "Lights",
        isSelected = false,
        imageBorder = R.drawable.ic_cycle,
        imageInner = R.drawable.ic_lights,
        isClicked = false,
        isLoading = false,
        buttonColor = UnSelectedButtonColor
    ),
)