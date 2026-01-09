package ru.kilobyte.scheduleonly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kilobyte.scheduleonly.data.Lesson

class TodayViewModel : ViewModel() {
    private val _lessons = MutableLiveData<List<Lesson>>()
    val lessons: LiveData<List<Lesson>> = _lessons

    private fun getLessons(): List<Lesson> {
        return listOf()
    }

    init {
        _lessons.value = getLessons()
    }
}