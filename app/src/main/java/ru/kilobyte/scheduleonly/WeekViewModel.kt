package ru.kilobyte.scheduleonly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kilobyte.scheduleonly.data.Day
import ru.kilobyte.scheduleonly.data.Lesson
import java.time.LocalTime

class WeekViewModel : ViewModel() {
    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

    private fun getDays(): List<Day> {
        return listOf(
            Day(
                "Понедельник", listOf(
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now())
                )
            ),
            Day(
                "Вторник", listOf(
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                    Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                )
            )
        )
    }

    init {
        _days.value = getDays()
    }
}