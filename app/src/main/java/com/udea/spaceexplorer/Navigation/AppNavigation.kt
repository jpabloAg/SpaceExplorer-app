package com.udea.spaceexplorer.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route){
		composable(route = AppScreens.HomeScreen.route){
			Home(navController)
		}
		
		composable(route = AppScreens.NasaObjScreen.route){
			NasaObj(navController)
		}
		
		composable(route = AppScreens.NasaObjListScreen.route){
			NasaObjList(navController)
		}
	}
}