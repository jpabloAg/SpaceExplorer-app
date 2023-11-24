package com.udea.spaceexplorer.Navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import kotlinx.coroutines.launch

class SpaceExplorerViewModel : ViewModel() {
	
	private val _apodResponse = MutableLiveData<List<ApodResponse>>()
	val apodResponse: LiveData<List<ApodResponse>> = _apodResponse
	
	init {
		fetchApodResponse()
	}
	
	private fun fetchApodResponse() {
		viewModelScope.launch {
			val serviceApiNasa = RetrofitServiceFactory.makeRetrofitService()
			// Llama a la API y actualiza el LiveData
			_apodResponse.value = serviceApiNasa.listMostRecentPictures("r5wBPjnq3ysMhmmUs9bHMKoAovwRqGLaoLbk4NxX", 20)
		}
	}
}
