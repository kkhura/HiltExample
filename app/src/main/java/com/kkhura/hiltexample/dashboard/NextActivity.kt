package com.kkhura.hiltexample.dashboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.translate.view.TranslateFragment
import com.kkhura.hiltexample.dashboard.user.view.UserFragment
import com.kkhura.hiltexample.di.qualifier.ActivityQualifier
import com.kkhura.hiltexample.di.qualifier.AppQualifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_next.*
import javax.inject.Inject

@AndroidEntryPoint
class NextActivity : AppCompatActivity() {

    @ActivityQualifier
    @Inject
    lateinit var activityString: String

    @AppQualifier
    @Inject
    lateinit var applicationString: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        textActivity.text = activityString
        textApplicaation.text = applicationString

        textActivity.setOnClickListener {
            frameContainer.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, TranslateFragment())
                .commit()
        }

        textApplicaation.setOnClickListener {
            frameContainer.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, UserFragment())
                .commit()
        }
    }
}