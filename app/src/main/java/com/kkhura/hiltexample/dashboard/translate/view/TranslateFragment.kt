package com.kkhura.hiltexample.dashboard.translate.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.translate.SOURCE_LANGUAGE
import com.kkhura.hiltexample.dashboard.translate.STRING
import com.kkhura.hiltexample.dashboard.translate.TARGET_LANGUAGE
import com.kkhura.hiltexample.dashboard.translate.viewmodel.TranslateViewModel
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

@AndroidEntryPoint
class TranslateFragment : Fragment(R.layout.fragment_user) {

    private val userViewModel by viewModels<TranslateViewModel>()

    @FragmentQualifier
    @Inject
    lateinit var fragmentString: String

    @Inject
    lateinit var singlentonObject: SinglentonObject

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newMap = HashMap<String, String>()
        newMap[TARGET_LANGUAGE] = "es"
        newMap[SOURCE_LANGUAGE] = "en"
        newMap[STRING] = singlentonObject.getString() //"Hello"

        userViewModel.fetchTranslation(newMap, "https://blanc-stg1--simpplr.visualforce.com/")

        userViewModel.userResponse.observe(viewLifecycleOwner, Observer {
            textFragment.text = it
        })
    }
}