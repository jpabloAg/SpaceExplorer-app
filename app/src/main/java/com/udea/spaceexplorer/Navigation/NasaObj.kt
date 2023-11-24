package com.udea.spaceexplorer.Navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.udea.spaceexplorer.BottomNavigationBar
import com.udea.spaceexplorer.DisplayImageFromUrl
import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.domain.dto.Selected

@Composable
fun NasaObj(navController: NavController) {
	NasaObjScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NasaObjScreen(navController: NavController) {
	Scaffold(
		bottomBar = { BottomNavigationBar(navController = navController) },
		content = { paddingValues ->
			NasaObjInfo(Modifier.padding(paddingValues))
		}
	)
}

@Composable
fun NasaObjInfo(modifier: Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		NasaObjView(Selected)
	}
}

@Composable
fun NasaObjView(element: ApodResponse, width: Int = 300, height: Int = 300) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		DisplayImageFromUrl(url = element.url, width, height)
		Text(
			text = element.title,
			modifier = Modifier.padding(20.dp),
			style = MaterialTheme.typography.bodyLarge
		)
		Text(
			text = element.date,
			modifier = Modifier.padding(10.dp, 0.dp),
			style = MaterialTheme.typography.bodyMedium
		)
		Text(
			text = element.explanation,
			modifier = Modifier.padding(5.dp, 30.dp),
			style = MaterialTheme.typography.bodyMedium
		)
	}
}