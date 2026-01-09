package ru.kilobyte.scheduleonly.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.kilobyte.scheduleonly.data.model.Lesson

class ScheduleRepository(private val context: Context) {
    private val gson = Gson()

    fun loadFromFile(): List<Lesson> {
        val text = context.assets.open("lessons.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Lesson>>() {}.type

        return gson.fromJson(text, type) ?: emptyList()
    }
}