package com.mindorks.framework.mvvm.data.model

import com.kkhura.hiltexample.dashboard.user.model.SimpplrModel

data class User(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val avatar: String = ""
):SimpplrModel()