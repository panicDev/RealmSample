package com.panicdev.realmsample.presentation.vehicles

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panicdev.realmsample.data.local.VehicleEntity
import com.panicdev.realmsample.domain.repository.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class VehicleViewModel @Inject constructor(private val repository: VehicleRepository) :
    VehicleContract.Model,
    ViewModel() {

    init {
        dispatch(VehicleContract.Intent.GetVehicles)
    }

    override fun dispatch(intent: VehicleContract.Intent) {
        when (intent) {
            VehicleContract.Intent.GetVehicles -> {
//                loadVehicles()
                loadDb()
            }

            VehicleContract.Intent.Back -> {}
        }

    }

    private fun loadVehicles() = intent {
        viewModelScope.launch {
            repository.getVehicles()
                .onStart {
                    reduce {
                        state.copy(isLoading = true)
                    }
                }
                .collect {
                    reduce {
                        state.copy(vehicles = it, isLoading = false)
                    }
                }
        }


    }

    private fun loadDb() {
        val configuration = RealmConfiguration.Builder(
            schema = setOf(VehicleEntity::class)
        ).initialRealmFile("g4new.realm")
            .name("g4new.realm")
            .compactOnLaunch()
            .build()
        val bundledRealm = Realm.open(configuration)

        Log.i("VehicleViewModel", "Realm location -> ${configuration.path}")
        Log.i("VehicleViewModel", "loadDb ${bundledRealm.query<VehicleEntity>().first().find()}")
        val bundledItems: RealmResults<VehicleEntity> = bundledRealm.query<VehicleEntity>().find()
        for (item in bundledItems) {
            Log.i("VehicleViewModel", "Item in the bundledRealm: ${item.nopol}")
        }
    }

    override val container = container<VehicleContract.UIState, VehicleContract.SideEffect>(
        VehicleContract.UIState()
    )

}