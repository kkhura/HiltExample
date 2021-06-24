package com.kkhura.hiltexample.dashboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.translate.view.TranslateFragment
import com.kkhura.hiltexample.dashboard.user.view.UserFragment
import com.kkhura.hiltexample.databinding.ActivityNextBinding
import com.kkhura.hiltexample.di.qualifier.ActivityQualifier
import com.kkhura.hiltexample.di.qualifier.AppQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    @ActivityQualifier
    @Inject
    lateinit var activityString: String

    @AppQualifier
    @Inject
    lateinit var applicationString: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.textActivity.text = activityString
        binding.textApplicaation.text = applicationString

        binding.textActivity.setOnClickListener {
            binding.frameContainer.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, TranslateFragment())
                .commit()
        }

        binding.textApplicaation.setOnClickListener {
            binding.frameContainer.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, UserFragment())
                .commit()
        }
    }
}