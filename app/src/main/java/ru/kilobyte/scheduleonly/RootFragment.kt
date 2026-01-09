package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.databinding.RootFragmentBinding

class RootFragment : Fragment(R.layout.root_fragment) {

    private val binding: RootFragmentBinding by viewBinding(RootFragmentBinding::bind)

    /*
    * Даже не знаю насколько хорошей идеей было отказываться от двух view models
    * и вместо этого пихать всю логику загрузки в одну, да и потом выносить её
    * в корневой фрагмент, но, тем не менее, оно работает, значит не трогаем
    *
    * Источник - https://stackoverflow.com/questions/53817046/how-to-scope-a-view-model-to-a-parent-fragment
    *
    * */
    private val viewModel: ScheduleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.load()

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(binding.rootFragmentsContainer.id, TodayFragment())
                .commit()
        }

        binding.navigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_today -> {
                    childFragmentManager.beginTransaction().replace(
                        binding.rootFragmentsContainer.id, TodayFragment()
                    ).commit()
                    true
                }

                R.id.menu_week -> {
                    childFragmentManager.beginTransaction().replace(
                        binding.rootFragmentsContainer.id, WeekFragment()
                    ).commit()
                    true
                }

                else -> false
            }
        }
    }
}