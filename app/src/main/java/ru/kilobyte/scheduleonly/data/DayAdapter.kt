package ru.kilobyte.scheduleonly.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kilobyte.scheduleonly.data.LessonAdapter
import ru.kilobyte.scheduleonly.data.model.Day
import ru.kilobyte.scheduleonly.databinding.ItemDayBinding

class DayAdapter : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    private var days: List<Day> = listOf()

    class DayViewHolder(
        private val binding: ItemDayBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Day) {
            binding.dayName.text = item.name

            val lessonAdapter = LessonAdapter()
            lessonAdapter.submitList(item.lessons)

            binding.innerLessonsRecycler.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = lessonAdapter
            }
        }
    }

    fun submitList(list: List<Day>) {
        days = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)

        val binding = ItemDayBinding.inflate(
            layoutInflater, parent, false
        )

        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DayViewHolder,
        position: Int
    ) {
        val item: Day = days[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return days.size
    }
}