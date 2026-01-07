package ru.kilobyte.scheduleonly

import androidx.fragment.app.Fragment

class RootFragment : Fragment(R.layout.root_fragment) {

    companion object {
        @JvmStatic
        fun newInstance() = RootFragment().apply {  }
    }
}