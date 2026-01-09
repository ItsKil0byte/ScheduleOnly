package ru.kilobyte.scheduleonly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kilobyte.scheduleonly.data.Day

class WeekViewModel : ViewModel() {
    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

    private fun getDays(): List<Day> {
        return listOf()
    }

    init {
        _days.value = getDays()
    }
}