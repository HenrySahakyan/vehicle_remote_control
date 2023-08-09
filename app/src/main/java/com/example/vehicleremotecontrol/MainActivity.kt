package com.example.vehicleremotecontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.vehicleremotecontrol.ui.screen.navigation.NavigationScreen
import com.example.vehicleremotecontrol.ui.theme.MainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                NavigationScreen()
            }

        }
    }
}
