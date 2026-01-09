package ru.kilobyte.scheduleonly

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kilobyte.scheduleonly.data.Day
import ru.kilobyte.scheduleonly.data.Lesson
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.Locale

class ScheduleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = LessonRepository(application)
    private val _lessons = MutableStateFlow<List<Lesson>>(emptyList())
    val lessons: StateFlow<List<Lesson>> = _lessons

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            _lessons.value = repository.loadFromFile()
        }
    }

    private fun isWeekOdd(date: LocalDate): Boolean {
        val weekNumber = date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear())

        return weekNumber % 2 == 1
    }

    private fun getDayName(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            1 -> "Понедельник"
            2 -> "Вторник"
            3 -> "Среда"
            4 -> "Четверг"
            5 -> "Пятница"
            6 -> "Суббота"
            7 -> "Воскресенье"
            else -> ""
        }
    }

    fun getLessons(date: LocalDate = LocalDate.now()): List<Lesson> {
        val dayOfWeek = date.dayOfWeek.value
        val weekIsOdd = isWeekOdd(date)

        return _lessons.value.asSequence()
            .filter { it.dayOfWeek == dayOfWeek && Utils.parityCheck(it.parity, weekIsOdd) }
            .sortedBy { Utils.toMinutes(it.startTime) }
            .toList()
    }

    fun getDays(date: LocalDate = LocalDate.now()): List<Day> {
        val weekIsOdd = isWeekOdd(date)

        return (1..7).map { day ->
            val lessons = _lessons.value.asSequence()
                .filter { it.dayOfWeek == day && Utils.parityCheck(it.parity, weekIsOdd) }
                .sortedBy { Utils.toMinutes(it.startTime) }
                .toList()
            Day(getDayName(day), day, lessons)
        }
    }
}