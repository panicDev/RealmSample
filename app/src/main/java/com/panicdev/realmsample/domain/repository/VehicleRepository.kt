package com.panicdev.realmsample.domain.repository

import com.panicdev.realmsample.domain.models.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {
    fun getVehicles(): Flow<List<Vehicle>>

    suspend fun addVehicle(title: String)

    suspend fun updateVehicle(id: String)

}