package com.udea.spaceexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.udea.spaceexplorer.Navigation.AppNavigation
import com.udea.spaceexplorer.Navigation.AppScreens
import com.udea.spaceexplorer.ui.theme.SpaceExplorerTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		lifecycleScope.launch {
		}
		setContent {
			SpaceExplorerTheme {
				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					Column(
						modifier = Modifier.fillMaxSize(),
						horizontalAlignment = Alignment.CenterHorizontally
					) {
						Text(text = "Space Explorer", modifier = Modifier.padding(10.dp), color = Color.White)
						AppNavigation()
					}
				}
			}
		}
	}
}

@Composable
fun BottomNavigationBar(navController: NavController) {
	val homeAnnotatedString = buildAnnotatedString {
		withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.LightGray)) {
			append("Home")
		}
	}
	val nasaAnnotatedString = buildAnnotatedString {
		withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.LightGray)) {
			append("SpaceExplorer")
		}
	}
	BottomAppBar(modifier = Modifier.fillMaxWidth()) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			ClickableText(
				text = homeAnnotatedString,
				onClick = { navController.navigate(route = AppScreens.HomeScreen.route) },
				modifier = Modifier.padding(start = 16.dp)
			)
			ClickableText(
				text = nasaAnnotatedString,
				onClick = { navController.navigate(route = AppScreens.NasaObjListScreen.route) },
				modifier = Modifier.padding(end = 16.dp)
			)
		}
	}
}

@Composable
fun DisplayImageFromUrl(url: String, width: Int, height: Int) {
	val painter = rememberAsyncImagePainter(
      ImageRequest.Builder(LocalContext.current).data(data = url).apply(block = fun ImageRequest.Builder.() {
          crossfade(true)
      }).build()
  )
	
	Image(
		painter = painter,
		contentDescription = "Imagen Cargada",
		modifier = Modifier
        .width(width.dp)
        .height(height.dp)
        .clip(CircleShape),
		contentScale = ContentScale.Crop
	)
}



