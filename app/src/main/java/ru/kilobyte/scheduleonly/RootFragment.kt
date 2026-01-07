package ru.kilobyte.scheduleonly

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.databinding.RootFragmentBinding

class RootFragment : Fragment(R.layout.root_fragment) {

    private val binding: RootFragmentBinding by viewBinding(RootFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(binding.rootFragmentsContainer.id, TodayFragment.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RootFragment().apply {  }
    }
}