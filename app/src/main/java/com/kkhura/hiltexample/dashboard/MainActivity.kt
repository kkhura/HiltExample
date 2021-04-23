package com.kkhura.hiltexample.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkhura.hiltexample.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.text = mainViewModel.getButtonText()
        btnClick.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }
    }
}