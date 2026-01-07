package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.data.Lesson
import ru.kilobyte.scheduleonly.databinding.TodayFragmentBinding
import java.time.LocalTime

class TodayFragment : Fragment(R.layout.today_fragment) {
    private val binding: TodayFragmentBinding by viewBinding(TodayFragmentBinding::bind)
    private var adapter: LessonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LessonAdapter()

        binding.todayRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.todayRecycler.adapter = adapter

        adapter?.submitList(
            listOf(
                Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now()),
                Lesson("It", "Me", "123", LocalTime.now(), LocalTime.now())
            )
        )
    }
}