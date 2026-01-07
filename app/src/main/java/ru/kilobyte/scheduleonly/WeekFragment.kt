package ru.kilobyte.scheduleonly

import androidx.fragment.app.Fragment

class WeekFragment : Fragment(R.layout.week_fragment) {

    companion object {
        @JvmStatic
        fun newInstance() = WeekFragment().apply {  }
    }
}