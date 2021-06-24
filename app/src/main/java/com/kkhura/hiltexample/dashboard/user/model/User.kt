package com.kkhura.hiltexample.dashboard.user.model

import com.kkhura.hiltexample.model.SimpplrModel

data class User(
    val id: Int = 0,
    val first_name: String = "",
    val last_name: String = "",
    val email: String = "",
    val avatar: String = ""
): SimpplrModel()