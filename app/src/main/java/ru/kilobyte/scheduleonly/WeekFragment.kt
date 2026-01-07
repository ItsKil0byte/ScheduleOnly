package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.databinding.WeekFragmentBinding

class WeekFragment : Fragment(R.layout.week_fragment) {
    private val binding: WeekFragmentBinding by viewBinding(WeekFragmentBinding::bind)
    private val viewModel: WeekViewModel by viewModels()
    private var adapter: DayAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DayAdapter()

        binding.weekRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.weekRecycler.adapter = adapter

        viewModel.days.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
    }

}