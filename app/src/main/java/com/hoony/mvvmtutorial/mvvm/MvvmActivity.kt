package com.hoony.mvvmtutorial.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hoony.mvvmtutorial.databinding.ActivityCounterBinding

class MvvmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private val viewModel by viewModels<MvvmViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
        setObserve()
    }

    private fun setListener() {
        binding.run {
            plus.setOnClickListener {
                viewModel.plus()
            }
            minus.setOnClickListener {
                viewModel.minus()
            }
        }
    }

    private fun setObserve() {
        viewModel.counterLiveData.observe(this) {
            binding.number.text = it.toString()
        }
    }
}