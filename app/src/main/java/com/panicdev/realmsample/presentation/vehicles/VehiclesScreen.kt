package com.panicdev.realmsample.presentation.vehicles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun VehiclesScreen(
    modifier: Modifier = Modifier,
    viewModel: VehicleViewModel
) {
    val state by viewModel.collectAsState()
    VehiclesScreen(modifier, state, viewModel::dispatch)
}


@Composable
private fun VehiclesScreen(
    modifier: Modifier = Modifier,
    state: VehicleContract.UIState,
    action: (VehicleContract.Intent) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Column {
            TextField(
                value = state.title,
                onValueChange = {
//                    viewModel.setEvent(TasksContract.Event.TitleInputChanged(it))
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(text = "Title")
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Vehicles Size : ${state.vehicles.size}")

//        LazyColumn(
//            modifier = Modifier
//                .weight(1f)
//        ) {
//            items(items = state.value.vehicles, key = { it.id }) {
//                TaskItem(
//                    task = it,
//                    onUpdateTask = { viewModel.setEvent(TasksContract.Event.UpdateTask(it)) })
//            }
//        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VehicleScreenPreview() {
    VehiclesScreen(
        modifier = Modifier.fillMaxSize(),
        state = VehicleContract.UIState(),
        action = {}
    )
}