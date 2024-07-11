package com.panicdev.realmsample.presentation.vehicles

import com.panicdev.realmsample.domain.models.Vehicle
import org.orbitmvi.orbit.ContainerHost

interface VehicleContract {
    sealed interface Model : ContainerHost<UIState, SideEffect> {
        fun dispatch(intent: Intent)
    }

    data class UIState(
        val vehicles: List<Vehicle> = emptyList(),
        val title: String = "",
        val isLoading: Boolean = false
    )

    sealed interface SideEffect
    sealed interface Intent {
        data object GetVehicles : Intent
        data object Back : Intent
    }
}