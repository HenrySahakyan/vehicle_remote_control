package com.example.vehicleremotecontrol.ui.entity

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.vehicleremotecontrol.R

data class ActionUi(
    val imageBorder: Int,
    val imageInner: Int,
    val title: String,
    val isSelected: Boolean,
    val isClicked: Boolean,
    val isLoading: Boolean,
    val buttonColor: Color
)

data class HomeUi(
    val title: String,
    @DrawableRes
    val supportIcon: Int = R.drawable.ic_support,
    @DrawableRes
    val titleLockIcon: Int = R.drawable.ic_lock_small,
    @DrawableRes
    val notificationIcon: Int = R.drawable.ic_notification,
    val actions: List<ActionUi>
)