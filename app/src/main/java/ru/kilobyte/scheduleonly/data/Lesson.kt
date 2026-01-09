package ru.kilobyte.scheduleonly.data

data class Lesson(
    val name: String,
    val teacher: String,
    val room: String,
    val startTime: String,  // HH:mm
    val endTime: String,    // HH:mm
    val dayOfWeek: Int,     // 1 - 7
    val parity: String      // odd / even / both
)
