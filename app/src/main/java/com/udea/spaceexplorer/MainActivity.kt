package com.udea.spaceexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberAsyncImagePainter
import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import com.udea.spaceexplorer.ui.theme.SpaceExplorerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serviceApiNasa = RetrofitServiceFactory.makeRetrofitService()
        val serviceApiOpenNotify = RetrofitServiceFactory.makeRetrofitServiceOpenNotify()
        val serviceApiNinja = RetrofitServiceFactory.makeRetrofitServiceNinja()
        lifecycleScope.launch {
            // Api Nasa
            //val response = serviceApiNasa.listMarsRoverPhotos("r5wBPjnq3ysMhmmUs9bHMKoAovwRqGLaoLbk4NxX", 10)
            //val response = serviceApiNasa.listMostRecentPictures("r5wBPjnq3ysMhmmUs9bHMKoAovwRqGLaoLbk4NxX", 10)

            // Api Open Notify
            //val response = serviceApiOpenNotify.GetISSPosition()

            // Api Planet
            val response = serviceApiNinja.getPlanetDetail("V0TSsL6hBZfBL8TEpm3eiw==wRaD5t65flambTCp","Jupiter")

            println(response)
        }

        setContent {
            SpaceExplorerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    //loadImage()
                }
            }
        }
    }
}

@Composable
fun loadImage(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.size(300.dp),
            shape = RectangleShape
        ){
            Image(
                painter = rememberAsyncImagePainter("https://apod.nasa.gov/apod/image/0401/ngc1232all_vlt.jpg"),
                contentDescription = "Space",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpaceExplorerTheme {
        Greeting("Android")
    }
}