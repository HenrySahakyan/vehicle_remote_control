package com.example.vehicleremotecontrol.data.entity

import androidx.compose.ui.graphics.Color

data class Home(
    val title: String,
    val actions: List<Action>
)

data class Action(
    val title: String,
    val isSelected: Boolean,
    val isClicked: Boolean,
    val imageBorder: Int,
    val imageInner : Int,
    val isLoading:Boolean,
    val buttonColor: Color,
)
