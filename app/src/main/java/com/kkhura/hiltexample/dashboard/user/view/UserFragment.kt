package com.kkhura.hiltexample.dashboard.user.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.user.adapter.UserAdapter
import com.kkhura.hiltexample.dashboard.user.viewmodel.UserViewModel
import com.kkhura.hiltexample.databinding.FragmentUserBinding
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val userViewModel by viewModels<UserViewModel>()

    @FragmentQualifier
    @Inject
    lateinit var fragmentString: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        context?.let {
            binding = DataBindingUtil.inflate<FragmentUserBinding>(
                inflater,
                R.layout.fragment_user,
                container,
                false
            ).apply {
                lifecycleOwner = this@UserFragment
                userViewModel = userViewModel
                userAdapter = UserAdapter(it)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.fetchUsers()
        userViewModel.userList.observe(viewLifecycleOwner, {
            binding.userAdapter?.userList = it
            binding.userAdapter?.notifyDataSetChanged()
        })
    }
}