package ru.kilobyte.scheduleonly

import androidx.fragment.app.Fragment

class TodayFragment : Fragment(R.layout.today_fragment) {

    companion object {
        @JvmStatic
        fun newInstance() = TodayFragment().apply {  }
    }
}