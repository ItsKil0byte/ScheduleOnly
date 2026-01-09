package ru.kilobyte.scheduleonly.data.model

import ru.kilobyte.scheduleonly.data.model.Lesson

data class Day(
    val name: String,
    val dayOfWeek: Int,     // 1 - 7
    val lessons: List<Lesson>
)