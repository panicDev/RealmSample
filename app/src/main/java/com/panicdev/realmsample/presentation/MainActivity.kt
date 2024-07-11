package com.panicdev.realmsample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.panicdev.realmsample.designsystem.theme.RealmSampleTheme
import com.panicdev.realmsample.presentation.vehicles.VehicleViewModel
import com.panicdev.realmsample.presentation.vehicles.VehiclesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealmSampleTheme {
                val viewModel: VehicleViewModel = hiltViewModel()
                VehiclesScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}