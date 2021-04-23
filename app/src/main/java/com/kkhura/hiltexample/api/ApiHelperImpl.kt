package com.mindorks.framework.mvvm.data.api

import com.kkhura.hiltexample.di.qualifier.RetrofitQualifier
import com.mindorks.framework.mvvm.data.model.User
import javax.inject.Inject
import io.reactivex.Observable


class ApiHelperImpl @Inject constructor(
    private val restAPIInterface: RestAPIInterface,
    @RetrofitQualifier val translateRestAPIInterface: RestAPIInterface
) : ApiHelper {

    override fun getUsers(): Observable<List<User>> = restAPIInterface.getUsers()

    override fun getTranslationData(
        map: Map<String, String>,
        baseUrl: String
    ) = translateRestAPIInterface.getTranslationData(map, baseUrl)

}