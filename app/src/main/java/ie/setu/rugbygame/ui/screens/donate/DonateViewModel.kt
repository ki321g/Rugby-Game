package ie.setu.rugbygame.ui.screens.donate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.data.room.RoomRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DonateViewModel @Inject
constructor(private val repository: RoomRepository) : ViewModel() {

    fun insert(donations: DonationModel)
            = viewModelScope.launch {
        repository.insert(donations)
    }
}