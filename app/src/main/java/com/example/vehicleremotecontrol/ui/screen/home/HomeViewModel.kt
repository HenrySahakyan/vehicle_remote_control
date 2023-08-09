package com.example.vehicleremotecontrol.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehicleremotecontrol.R
import com.example.vehicleremotecontrol.data.entity.generateHomeData
import com.example.vehicleremotecontrol.data.mapper.toUi
import com.example.vehicleremotecontrol.ui.entity.HomeUi
import com.example.vehicleremotecontrol.ui.entity.ToastUI
import com.example.vehicleremotecontrol.ui.theme.SelectedButtonColor
import com.example.vehicleremotecontrol.ui.theme.UnSelectedButtonColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val homeData = generateHomeData().toUi()
    private val _clickListenerFlow = MutableStateFlow(homeData)
    val clickListener: StateFlow<HomeUi> = _clickListenerFlow
    private val _rotationAngle = MutableStateFlow(0f)
    val rotationAngle: StateFlow<Float> = _rotationAngle
    private val _toastState = MutableStateFlow<ToastUI?>(null)
    val toastState = _toastState


    fun onButtonClick(index: Int) {
        viewModelScope.launch {
            val updatedActions = clickListener.value.actions.mapIndexed { i, action ->
                if (!action.isSelected && i == index && (index == 0 || index == 1)) {
                    action.copy(isClicked = true)
                } else {
                    action.copy(isClicked = false)
                }
            }
            val newHomeData = clickListener.value.copy(actions = updatedActions)
            _clickListenerFlow.emit(newHomeData)
        }
    }

    fun onDialogClick(homeData: HomeUi, index: Int, confirmed: Boolean) {
        viewModelScope.launch {
            val updatedActions = homeData.actions.mapIndexed { i, action ->
                if (!confirmed) {
                    action.copy(isClicked = false)
                } else {
                    if (i == index) {
                        action.copy(
                            isSelected = false,
                            isClicked = false,
                            isLoading = true,
                            imageBorder = R.drawable.ic_loading,
                        )
                    } else {
                        action.copy(isSelected = false, isClicked = false)
                    }
                }
            }
            val newHomeData = homeData.copy(actions = updatedActions)
            _clickListenerFlow.emit(newHomeData) // Emit the updated state
        }
    }

    fun startRotationAnimation(durationMillis: Long) {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            val endTime = startTime + durationMillis
            while (System.currentTimeMillis() < endTime) {
                val progress = (System.currentTimeMillis() - startTime).toFloat() / durationMillis
                val angle = progress * 360f
                _rotationAngle.value = angle
                delay(16)
            }
        }
    }

    fun onButtonSelected(homeData: HomeUi, index: Int) {
        viewModelScope.launch {
            val updatedActions = homeData.actions.mapIndexed { i, action ->
                if (i == index) {
                    action.copy(
                        isSelected = true,
                        isClicked = false,
                        isLoading = false,
                        imageBorder = R.drawable.ic_cycle_selected,
                        buttonColor = SelectedButtonColor
                    )
                } else {
                    action.copy(
                        isLoading = false,
                        isSelected = false,
                        isClicked = false,
                        imageBorder = R.drawable.ic_cycle,
                        buttonColor = UnSelectedButtonColor
                    )
                }
            }
            val newHomeData = homeData.copy(actions = updatedActions)
            _clickListenerFlow.emit(newHomeData)
        }
    }

    fun showToast(durationMillis: Long,item:ToastUI) {
        viewModelScope.launch {
            _toastState.value = ToastUI( "Waking Ariya to ${item.message?.lowercase()}...",false)
            delay(durationMillis)
            _toastState.value =ToastUI( "Ariya is ${item.message?.lowercase()}ed.",true)
            delay(2000)
            _toastState.value = null
        }
    }
}