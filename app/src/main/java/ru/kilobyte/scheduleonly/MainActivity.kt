package ru.kilobyte.scheduleonly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.androidbroadcast.vbpd.viewBinding
import ru.kilobyte.scheduleonly.databinding.ActivityMainBinding
import ru.kilobyte.scheduleonly.presentier.RootFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.rootContainer)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentsContainer.id, RootFragment())
                .commit()
        }
    }
}