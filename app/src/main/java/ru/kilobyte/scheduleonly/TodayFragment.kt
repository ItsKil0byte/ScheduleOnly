package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.databinding.TodayFragmentBinding

class TodayFragment : Fragment(R.layout.today_fragment) {
    private val binding: TodayFragmentBinding by viewBinding(TodayFragmentBinding::bind)
    private val viewModel: TodayViewModel by viewModels()
    private var adapter: LessonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LessonAdapter()

        binding.todayRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.todayRecycler.adapter = adapter

        viewModel.lessons.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
    }
}