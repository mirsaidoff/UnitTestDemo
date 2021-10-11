package uz.mirsaidoff.unittestdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repo: PersonCarsRepo) : ViewModel() {

    fun searchPersonCars(personName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchPersonCars = repo.fetchPersonCars(personName)    //returns red cars to somewhere
        }
    }
}