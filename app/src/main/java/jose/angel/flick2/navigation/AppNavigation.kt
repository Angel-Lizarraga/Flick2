package jose.angel.flick2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import jose.angel.flick2.presentation.ShowDetailScreen
import jose.angel.flick2.presentation.ShowDetailViewModel
import jose.angel.flick2.presentation.ShowListScreen
import jose.angel.flick2.presentation.ShowListViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "ShowsList") {
        // Pantalla de lista
        composable("show_list") {
            val vs:ShowListViewModel = viewModel()
            ShowListScreen(
                shows = vs.shows.value,
                onClick = {show ->
                    navController.navigate(ShowDetailData(showID = show.id))
                }
            )
        }
        composable<ShowDetailData> {
            val vs: ShowDetailViewModel = viewModel()
            ShowDetailScreen(
                show = vs.show,
                navController=navController
            )
        }
    }
}
