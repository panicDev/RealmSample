package com.panicdev.realmsample.di

import com.panicdev.realmsample.data.local.VehicleMapper
import com.panicdev.realmsample.data.repository.VehicleRepositoryImpl
import com.panicdev.realmsample.domain.repository.VehicleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideVehicleMapper(): VehicleMapper {
        return VehicleMapper()
    }

    @Provides
    @Singleton
    fun provideVehicleRepository(realm: Realm, mapper: VehicleMapper): VehicleRepository {
        return VehicleRepositoryImpl(realm = realm, mapper = mapper)
    }
}