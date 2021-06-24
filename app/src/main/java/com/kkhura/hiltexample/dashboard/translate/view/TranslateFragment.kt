package com.kkhura.hiltexample.dashboard.translate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.translate.SOURCE_LANGUAGE
import com.kkhura.hiltexample.dashboard.translate.STRING
import com.kkhura.hiltexample.dashboard.translate.TARGET_LANGUAGE
import com.kkhura.hiltexample.dashboard.translate.viewmodel.TranslateViewModel
import com.kkhura.hiltexample.databinding.FragmentTranslateBinding
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TranslateFragment : Fragment() {

    private lateinit var binding: FragmentTranslateBinding
    private val userViewModel by viewModels<TranslateViewModel>()

    @FragmentQualifier
    @Inject
    lateinit var fragmentString: String

    @Inject
    lateinit var singlentonObject: SinglentonObject

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        context?.let {
            binding = DataBindingUtil.inflate<FragmentTranslateBinding>(
                inflater,
                R.layout.fragment_translate,
                container,
                false
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newMap = HashMap<String, String>()
        newMap[TARGET_LANGUAGE] = "es"
        newMap[SOURCE_LANGUAGE] = "en"
        newMap[STRING] = singlentonObject.getString() //"Hello"

        userViewModel.fetchTranslation(newMap, "https://blanc-stg1--simpplr.visualforce.com/")

        userViewModel.userResponse.observe(viewLifecycleOwner, {
            binding.textFragment.text = it
        })
    }
}