package com.udea.spaceexplorer.Navigation

sealed class AppScreens(val route: String){
	object HomeScreen: AppScreens("home")
	object NasaObjScreen: AppScreens("nasaObj")
	object NasaObjListScreen: AppScreens("nasaObjList")
}