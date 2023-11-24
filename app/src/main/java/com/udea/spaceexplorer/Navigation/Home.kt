package com.udea.spaceexplorer.Navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.udea.spaceexplorer.BottomNavigationBar

@Composable
fun Home(navController: NavController) {
	HomeScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: SpaceExplorerViewModel = viewModel(), navController: NavController) {
	Scaffold(
		bottomBar = { BottomNavigationBar(navController = navController) },
		content = { paddingValues ->
			HomeView(Modifier.padding(paddingValues))
		}
	)
}

@Composable
fun HomeView(modifier: Modifier, viewModel: SpaceExplorerViewModel = viewModel()) {
	val elementList by viewModel.apodResponse.observeAsState(initial = emptyList())
	
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		if (elementList.isEmpty()) {
			CircularProgressIndicator()
		} else {
			NasaObjView(elementList[0])
		}
	}
}