package com.hoony.mvvmtutorial.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hoony.mvvmtutorial.databinding.ActivityMainBinding
import com.hoony.mvvmtutorial.mvvm.MvvmActivity
import com.hoony.mvvmtutorial.not_mvvm.NotMvvmActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() {
        binding.run {
            startMvvmActivity.setOnClickListener {
                startActivity(getIntent(MvvmActivity::class.java))
            }
            startNotMvvmActivity.setOnClickListener {
                startActivity(getIntent(NotMvvmActivity::class.java))
            }
        }
    }

    private fun getIntent(targetActivity: Class<*>): Intent =
        Intent(this, targetActivity)
}