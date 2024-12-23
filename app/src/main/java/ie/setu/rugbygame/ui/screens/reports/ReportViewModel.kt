package ie.setu.rugbygame.ui.screens.reports

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.data.api.RetrofitRepository
import ie.setu.rugbygame.data.room.RoomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class ReportViewModel @Inject
constructor(private val repository: RetrofitRepository) : ViewModel() {
    private val _donations
            = MutableStateFlow<List<DonationModel>>(emptyList())
    val uiDonations: StateFlow<List<DonationModel>>
            = _donations.asStateFlow()
    var isErr = mutableStateOf(false)
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf(Exception())

//    init {
//        viewModelScope.launch {
//            repository.getAll().collect { listOfDonations ->
//                _donations.value = listOfDonations
//            }
//        }
//    }

    init { getDonations() }

    fun getDonations() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                _donations.value = repository.getAll()
                isErr.value = false
                isLoading.value = false
            }
            catch(e:Exception) {
                isErr.value = true
                isLoading.value = false
                error.value = e
                Timber.i("RVM Error ${e.message}")
            }
        }
    }

    fun deleteDonation(donation: DonationModel) {
        viewModelScope.launch {
            repository.delete(donation)
        }
    }
}