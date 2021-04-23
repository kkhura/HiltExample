package com.kkhura.hiltexample.dashboard.user.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.user.viewmodel.UserViewModel
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {

    private val userViewModel by viewModels<UserViewModel>()

    @FragmentQualifier
    @Inject
    lateinit var fragmentString: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.fetchUsers()

        userViewModel.userResponse.observe(viewLifecycleOwner, Observer {
            textFragment.text = it
        })
    }
}