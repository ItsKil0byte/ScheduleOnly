package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.androidbroadcast.vbpd.viewBinding
import kotlinx.coroutines.launch
import ru.kilobyte.scheduleonly.databinding.TodayFragmentBinding

class TodayFragment : Fragment(R.layout.today_fragment) {
    private val binding: TodayFragmentBinding by viewBinding(TodayFragmentBinding::bind)
    private val viewModel: ScheduleViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )
    private var adapter: LessonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LessonAdapter()

        binding.todayRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.todayRecycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.lessons.collect {
                    adapter?.submitList(viewModel.getLessons())
                }
            }
        }
    }
}