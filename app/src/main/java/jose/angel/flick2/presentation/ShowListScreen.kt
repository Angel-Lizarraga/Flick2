package jose.angel.flick2.presentation

import android.content.Context
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import jose.angel.flick2.data.Show
import jose.angel.flick2.presentation.MovieCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowListScreen(
    onClick: (Show) -> Unit,
    shows : List<Show>
) {

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Show List") }) }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = paddingValues
        ) {
            items(shows) { show ->
                MovieCard(
                    show = show,
                    onClick = { onClick(show) }
                )
            }
        }
    }
}
