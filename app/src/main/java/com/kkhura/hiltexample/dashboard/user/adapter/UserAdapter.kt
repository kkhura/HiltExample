package com.kkhura.hiltexample.dashboard.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kkhura.hiltexample.BindableAdapter
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.user.model.User
import com.kkhura.hiltexample.databinding.UserListBinding

class UserAdapter(val context: Context) : RecyclerView.Adapter<UserAdapter.UserHolder>(),
    BindableAdapter<User> {

    var userList: ArrayList<User> = arrayListOf()

    override fun setData(data: List<User>?) {
        data?.let {
            userList.addAll(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = UserListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                binding.userName.text = context.getString(R.string.full_name, first_name, last_name)
            }
        }
    }

    override fun getItemCount() = userList.size


    inner class UserHolder(val binding: UserListBinding) : RecyclerView.ViewHolder(binding.root)
}