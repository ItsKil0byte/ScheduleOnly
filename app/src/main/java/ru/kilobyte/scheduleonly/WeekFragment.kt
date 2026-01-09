package ru.kilobyte.scheduleonly

import android.os.Bundle
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
import ru.kilobyte.scheduleonly.databinding.WeekFragmentBinding

class WeekFragment : Fragment(R.layout.week_fragment) {
    private val binding: WeekFragmentBinding by viewBinding(WeekFragmentBinding::bind)
    private val viewModel: ScheduleViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )
    private var adapter: DayAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DayAdapter()

        binding.weekRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.weekRecycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.lessons.collect {
                    adapter?.submitList(viewModel.getDays())
                }
            }
        }
    }

}