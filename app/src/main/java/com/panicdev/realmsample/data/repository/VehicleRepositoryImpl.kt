package com.panicdev.realmsample.data.repository

import com.panicdev.realmsample.data.local.VehicleEntity
import com.panicdev.realmsample.data.local.VehicleMapper
import com.panicdev.realmsample.domain.models.Vehicle
import com.panicdev.realmsample.domain.repository.VehicleRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VehicleRepositoryImpl(
    private val realm: Realm,
    private val mapper: VehicleMapper
) : VehicleRepository {

    override fun getVehicles(): Flow<List<Vehicle>> {
        return realm.query<VehicleEntity>().asFlow()
            .map { entities ->
                entities.list.map { mapper.mapToDomainModel(it) }
            }
    }

    override suspend fun addVehicle(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateVehicle(id: String) {
        TODO("Not yet implemented")
    }
}