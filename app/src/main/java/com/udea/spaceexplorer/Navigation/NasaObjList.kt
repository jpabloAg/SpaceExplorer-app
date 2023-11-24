package com.udea.spaceexplorer.Navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.udea.spaceexplorer.BottomNavigationBar
import com.udea.spaceexplorer.DisplayImageFromUrl
import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.domain.dto.Selected

@Composable
fun NasaObjList(navController: NavController) {
	MainScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
	Scaffold(
		bottomBar = { BottomNavigationBar(navController = navController) },
		content = { paddingValues ->
			SpaceExplorer(Modifier.padding(paddingValues), navController = navController)
		}
	)
}

@Composable
fun SpaceExplorer(
	modifier: Modifier = Modifier,
	viewModel: SpaceExplorerViewModel = viewModel(),
	navController: NavController
) {
	val elementList by viewModel.apodResponse.observeAsState(initial = emptyList())
	
	Column(
		modifier = modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		if (elementList.isEmpty()) {
			CircularProgressIndicator()
		} else {
			LazyColumn {
				items(elementList) { element ->
					NasaObj(element, navController = navController)
				}
			}
		}
	}
}

@Composable
fun NasaObj(apodResponse: ApodResponse, navController: NavController) {
	val annotatedString = buildAnnotatedString {
		withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.LightGray)) {
			append(apodResponse.title)
		}
		append("\n \n")
		withStyle(style = SpanStyle(color = Color.Gray)) {
			append(apodResponse.explanation.substring(0, 70) + "...")
		}
	}
	
	Spacer(modifier = Modifier.border(1.dp, Color.LightGray))
	Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
		DisplayImageFromUrl(apodResponse.url, 70, 70)
		Column(
			modifier = Modifier
				.padding(10.dp, 8.dp, 0.dp, 8.dp)
				.fillMaxWidth(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			ClickableText(text = annotatedString, onClick = {
				Selected = apodResponse
				navController.navigate(route = AppScreens.NasaObjScreen.route)
			}, modifier = Modifier.fillMaxWidth())
		}
	}
}

