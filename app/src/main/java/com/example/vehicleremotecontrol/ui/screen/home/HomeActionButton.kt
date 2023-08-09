package com.example.vehicleremotecontrol.ui.screen.home

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vehicleremotecontrol.ui.entity.HomeUi
import com.example.vehicleremotecontrol.ui.entity.ToastUI
import com.example.vehicleremotecontrol.ui.theme.IconSelectedColor
import com.example.vehicleremotecontrol.ui.theme.PrimaryTextColor


@Composable
fun HomeActionButton(viewModel: HomeViewModel, index: Int) {
    val homeData = viewModel.clickListener.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }
    val rotationAngle by viewModel.rotationAngle.collectAsState()
    if(homeData.actions[index].isLoading){
        viewModel.startRotationAnimation(5000)
        viewModel.showToast(5000, ToastUI(homeData.actions[index].title,false))
        delayed(5000) {
            viewModel.onButtonSelected(homeData, index)
        }

    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                viewModel.onButtonClick(index)

            },
            content = { HomeButton(homeData, index,rotationAngle) },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(0.dp, 0.dp),
        )
        Text(
            text = homeData.actions[index].title,
            color = PrimaryTextColor,
        )
        showDialog = homeData.actions[index].isClicked
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("Are you Sure?")
                },
                text = {
                    Text("This action will remotely ${homeData.actions[index].title.lowercase()} your vehicle.")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.onDialogClick(homeData, index, true)
                            showDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = IconSelectedColor),

                        ) {
                        Text("Yes", color = Color.White)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            viewModel.onDialogClick(homeData, index, false)
                            showDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(0.dp),
                    ) {
                        Text("No", color = IconSelectedColor)
                    }

                }
            )
        }
    }


}


@Composable
fun HomeButton(homeData: HomeUi, index: Int,rotationAngle:Float) {
    Box() {
        Image(
            painter = painterResource(id = homeData.actions[index].imageBorder),
            contentDescription = "cycle",
            modifier = Modifier.rotate(rotationAngle),
        )
        Icon(
            painter = painterResource(id = homeData.actions[index].imageInner),
            contentDescription = "cycle",
            modifier = Modifier
                .align(Alignment.Center),
            tint = homeData.actions[index].buttonColor
        )
    }
}
private fun delayed(milliseconds: Long, body: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(body, milliseconds)
}







