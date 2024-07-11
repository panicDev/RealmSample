package com.panicdev.realmsample.di

import android.content.Context
import com.panicdev.realmsample.data.local.VehicleEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRealm(@ApplicationContext context: Context): Realm {
        val configuration = RealmConfiguration.Builder(
            schema = setOf(VehicleEntity::class)
        ).initialRealmFile("g4new.realm")
            .name("default-realm")
            .compactOnLaunch()
            .build()

        return Realm.open(configuration)
    }
}