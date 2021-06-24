package com.kkhura.hiltexample.dashboard.user.model

import com.kkhura.hiltexample.model.SimpplrModel

data class UserList(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>
) : SimpplrModel()