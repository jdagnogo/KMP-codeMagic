package com.carrefour.kmpcodemagic.ui.feature.build

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.carrefour.kmpcodemagic.domain.models.Build
import com.carrefour.kmpcodemagic.sharedUi.component.BuildComponent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BuildListPage(
    viewModel: BuildViewModel = koinViewModel(),
    onNavigateToBuildDetails: (id: String) -> Unit,
) {
    val buildList by viewModel.buildList.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetch()
    }
    if (buildList.isEmpty()) {
        BuildListEmptyScreen()
    } else {
        BuildListScreen(
            buildList = buildList,
            onFetch = viewModel::fetch,
            onClick = onNavigateToBuildDetails
        )
    }
}

@Composable
private fun BuildListEmptyScreen() {
//TODO : show empty screen
    Scaffold() { padding ->
        Text("BuildListEmptyScreen")
    }
}

@Composable
private fun BuildListScreen(
    buildList: List<Build>,
    onFetch: () -> Unit,
    onClick: (id: String) -> Unit
) {
    Scaffold(
        bottomBar = {
            Button(onClick = onFetch) {
                Text("fetch")
            }
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding), contentPadding = PaddingValues(16.dp)) {
            itemsIndexed(
                items = buildList,
                key = { index: Int, item: Build -> item.id }
            ) { index, build ->
                BuildComponent(build = build, onClick = onClick)
            }
        }
    }
}