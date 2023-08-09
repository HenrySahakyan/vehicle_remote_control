package com.example.vehicleremotecontrol.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vehicleremotecontrol.R
import com.example.vehicleremotecontrol.ui.theme.HomeBackgroundColor
import com.example.vehicleremotecontrol.ui.theme.PrimaryTextColor
import com.example.vehicleremotecontrol.ui.theme.SecondaryTextColor
import com.example.vehicleremotecontrol.ui.theme.ToastCardBackground


@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel()
    val toastState = viewModel.toastState.collectAsState(initial = null).value
    with(viewModel.homeData) {
        Box(
            modifier = Modifier
                .background(HomeBackgroundColor)
                .fillMaxSize()
        ) {
            Column(

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.morning),
                        contentDescription = "HomeScreen",
                        modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
                        contentScale = ContentScale.FillBounds
                    )
                    Column(
                        modifier = Modifier
                            .offset(y = 48.dp)
                            .padding(start = 27.dp, end = 27.dp),
                    ) {
                        Box {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    painter = painterResource(id = supportIcon),
                                    contentDescription = "support"
                                )
                                Row(verticalAlignment = Alignment.CenterVertically)
                                {
                                    Icon(
                                        painter = painterResource(id = titleLockIcon),
                                        contentDescription = "small_lock"
                                    )
                                    Text(title, color = PrimaryTextColor,
                                        fontWeight = FontWeight.Bold,)
                                }

                                Icon(
                                    painter = painterResource(id = notificationIcon),
                                    contentDescription = "notification"
                                )
                            }
                        }
                        Box {
                            Column(horizontalAlignment = Alignment.Start) {
                                Text(
                                    fontSize = 14.sp,
                                    text = "Est. Range",
                                    color = SecondaryTextColor,
                                    modifier = Modifier.padding(top = 7.dp)
                                )
                                Row(
                                    modifier = Modifier.padding(top = 2.dp),
                                    verticalAlignment = Alignment.Bottom,
                                ) {
                                    Text(
                                        text = "120",
                                        fontSize = 40.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                    )
                                    Text(
                                        text = "mi",
                                        fontSize = 18.sp,
                                        modifier = Modifier.offset(y=((-5).dp))
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(top = 26.dp)
                                ) {

                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_weather),
                                        contentDescription = "weather"
                                    )
                                    Text(text = "70° • Irvine, CA",
                                        fontWeight = FontWeight.Bold,)
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(x = 105.dp, y = (-28).dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.car),
                            contentDescription = "Car",

                            )
                    }
                }
                Box() {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        itemsIndexed(actions) { index, _ ->
                            HomeActionButton(viewModel = viewModel, index = index)
                        }
                    }
                }


            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .offset(y = (-55).dp)
                    .align(Alignment.BottomCenter)
            ) {

                if (toastState != null) {
                    ToastMessage(message = toastState.message,toastState.isVisible)
                }
            }
        }
    }
}

@Composable
fun ToastMessage(message: String,isVisible:Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        backgroundColor = ToastCardBackground,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = message,
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
            Image(
                painter = painterResource(id = R.drawable.ic_ok),
                contentDescription = "iconOk",
                alpha = if(isVisible) 1f else 0f
            )
        }
    }
}