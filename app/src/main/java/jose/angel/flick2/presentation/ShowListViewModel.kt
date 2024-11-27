package jose.angel.flick2.presentation

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jose.angel.flick2.data.DataProvider
import jose.angel.flick2.data.Show
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShowListViewModel() : ViewModel() {
    val shows = mutableStateOf( DataProvider.shows)
}
