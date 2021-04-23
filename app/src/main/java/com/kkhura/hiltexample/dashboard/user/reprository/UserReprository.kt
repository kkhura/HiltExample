package com.kkhura.hiltexample.dashboard.user.reprository

import com.mindorks.framework.mvvm.data.api.ApiHelper
import javax.inject.Inject

class UserReprository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getUsers() =  apiHelper.getUsers()

}