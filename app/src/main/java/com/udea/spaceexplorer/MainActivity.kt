package com.udea.spaceexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import com.udea.spaceexplorer.ui.theme.SpaceExplorerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()
        lifecycleScope.launch {
            val response = service.listMostRecentPictures("r5wBPjnq3ysMhmmUs9bHMKoAovwRqGLaoLbk4NxX", 2)
            println(response)
        }

        setContent {
            SpaceExplorerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ViewApod(response)
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun ViewApod(apods: List<ApodResponse>) {
    println(apods)
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(apods){
            Text(text = it.title)
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