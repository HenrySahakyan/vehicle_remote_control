package com.example.vehicleremotecontrol.data.mapper

import com.example.vehicleremotecontrol.data.entity.Toast
import com.example.vehicleremotecontrol.ui.entity.ToastUI

fun Toast.toUi(): ToastUI = ToastUI(
    message=message,
    isVisible=isVisible
)