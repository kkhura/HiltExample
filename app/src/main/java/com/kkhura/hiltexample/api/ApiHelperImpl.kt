package com.kkhura.hiltexample.api

import com.kkhura.hiltexample.dashboard.user.model.UserList
import com.kkhura.hiltexample.di.qualifier.RetrofitQualifier
import io.reactivex.Observable
import javax.inject.Inject


class ApiHelperImpl @Inject constructor(
    private val restAPIInterface: RestAPIInterface,
    @RetrofitQualifier val translateRestAPIInterface: RestAPIInterface
) : ApiHelper {

    override fun getUsers(): Observable<UserList> = restAPIInterface.getUsers()

    override fun getTranslationData(
        map: Map<String, String>,
        baseUrl: String
    ) = translateRestAPIInterface.getTranslationData(map, baseUrl)

}