package jose.angel.flick2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jose.angel.flick2.data.DataProvider

// Factory para crear el ViewModel
class ViewModelFactory(private val dataProvider: DataProvider) : ViewModelProvider.Factory {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ShowListViewModel::class.java)) {
//            return ShowListViewModel(dataProvider) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
}
