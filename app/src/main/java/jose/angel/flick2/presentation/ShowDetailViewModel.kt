package jose.angel.flick2.presentation

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import jose.angel.flick2.data.DataProvider
import jose.angel.flick2.data.Show
import jose.angel.flick2.navigation.ShowDetailData

class ShowDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val showID:Int = savedStateHandle.toRoute<ShowDetailData>().showID
    val show = DataProvider.shows.get(showID-1)
}
