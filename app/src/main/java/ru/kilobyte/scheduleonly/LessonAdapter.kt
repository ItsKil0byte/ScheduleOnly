package ru.kilobyte.scheduleonly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kilobyte.scheduleonly.data.Lesson
import ru.kilobyte.scheduleonly.databinding.ItemLessonBinding

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var lessons: List<Lesson> = listOf()

    class LessonViewHolder(
        private val binding: ItemLessonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Lesson) {
            binding.subjectName.text = item.name
            binding.subjectTeacher.text = item.teacher
            binding.subjectRoom.text = item.room
            binding.subjectStartTime.text = item.startTime.toString()
            binding.subjectEndTime.text = item.endTime.toString()
        }
    }

    fun submitList(list: List<Lesson>) {
        lessons = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LessonViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)

        val binding = ItemLessonBinding.inflate(
            layoutInflater, parent, false
        )

        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LessonViewHolder,
        position: Int
    ) {
        val item: Lesson = lessons[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }
}