package ru.kilobyte.scheduleonly.data

data class Day(
    val name: String,
    val dayOfWeek: Int,     // 1 - 7
    val lessons: List<Lesson>
)
