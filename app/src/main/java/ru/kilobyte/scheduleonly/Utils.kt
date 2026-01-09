package ru.kilobyte.scheduleonly

object Utils {
    fun toMinutes(timeString: String): Int {
        val parts = timeString.split(":")
        val hours = parts[0].toInt()
        val minutes = parts[1].toInt()

        return hours * 60 + minutes
    }

    fun toTimeString(minutes: Int): String {
        return String.format("%02d:%02d", minutes / 60, minutes % 60)
    }
}