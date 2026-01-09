package ru.kilobyte.scheduleonly

object Utils {
    fun toMinutes(timeString: String): Int {
        val parts = timeString.split(":")
        val hours = parts[0].toInt()
        val minutes = parts[1].toInt()

        return hours * 60 + minutes
    }

    fun parityCheck(parity: String, weekIsOdd: Boolean): Boolean {
        return when (parity) {
            "both" -> true
            "odd" -> weekIsOdd
            "even" -> !weekIsOdd
            else -> false
        }
    }
}