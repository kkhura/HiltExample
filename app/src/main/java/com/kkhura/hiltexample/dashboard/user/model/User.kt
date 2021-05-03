package com.kkhura.hiltexample.dashboard.user.model

import com.kkhura.hiltexample.model.SimpplrModel

data class User(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val avatar: String = ""
): SimpplrModel()