package ru.kilobyte.scheduleonly.data

import java.time.LocalTime

data class Lesson(
    val name: String,
    val teacher: String,
    val room: String,
    val startTime: LocalTime,
    val endTime: LocalTime
)
