package ru.kilobyte.scheduleonly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kilobyte.scheduleonly.data.Lesson
import java.time.LocalTime

class TodayViewModel : ViewModel() {
    private val _lessons = MutableLiveData<List<Lesson>>()
    val lessons: LiveData<List<Lesson>> = _lessons

    private fun getLessons(): List<Lesson> {
        return listOf(
            Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
            Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
            Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
            Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now())
        )
    }

    init {
        _lessons.value = getLessons()
    }
}