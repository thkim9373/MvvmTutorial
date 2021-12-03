package com.hoony.mvvmtutorial.not_mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hoony.mvvmtutorial.databinding.ActivityCounterBinding

class NotMvvmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCounter()
        setListener()
    }

    private fun setupCounter() {
        binding.number.text = counter.toString()
    }

    private fun setListener() {
        binding.run {
            plus.setOnClickListener {
                plus()
                setupCounter()
            }
            minus.setOnClickListener {
                minus()
                setupCounter()
            }
        }
    }

    private fun plus() {
        counter += 1
    }

    private fun minus() {
        counter -= 1
    }
}