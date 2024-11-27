package jose.angel.flick2.presentation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import jose.angel.flick2.data.Show
import jose.angel.flick2.data.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDetailScreen(
    show: Show,
    navController: NavHostController
) {

    // Cargar el show cuando se navega a esta pantalla


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(show?.name ?: "Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            if (show != null) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Imagen y detalles principales
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = show.image?.medium,
                            contentDescription = show.name,
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = show.name,
                                style = MaterialTheme.typography.titleLarge.copy()
                            )
                            Text(text = "Genres: ${show.genres.joinToString(", ")}")
                            Text(text = "Premiered: ${show.premiered}")
                            Text(text = "Network: ${show.network?.name ?: "N/A"}")
                            Text(text = "Language: ${show.language}")
                        }
                    }

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    // Resumen del show
                    show.summary?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                // Botón flotante para compartir
                ShareButton(url = show.url, modifier = Modifier.align(Alignment.BottomEnd))
            } else {
                Text("Show no encontrado", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
}

@Composable
fun ShareButton(url: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this show: $url")
            }
            context.startActivity(Intent.createChooser(shareIntent, "Share via"))
        },
        modifier = modifier.padding(16.dp)
    ) {
        Icon(Icons.Filled.Share, contentDescription = "Compartir")
    }
}


