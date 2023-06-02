package com.aryasurya.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.aryasurya.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val liveDataTimerViewModel: MainViewModel by viewModels()
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

//        liveDataTimerViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        suscribe()
    }

    private fun suscribe() {
        val elapsedTimeObserver = Observer<Long?> { along ->
            val newText = this@MainActivity.resources.getString(R.string.seconds, along)
            activityMainBinding.tvTimer.text = newText
        }

        liveDataTimerViewModel.getElpasedTime().observe(this, elapsedTimeObserver)
    }
}