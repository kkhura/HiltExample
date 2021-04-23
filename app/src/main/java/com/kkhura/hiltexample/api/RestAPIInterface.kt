package com.kkhura.hiltexample.api

import com.kkhura.hiltexample.dashboard.user.model.User
import com.kkhura.hiltexample.dashboard.translate.model.TranslationObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RestAPIInterface {

    @GET("users")
    fun getUsers(): Observable<List<User>>

    @POST("language/translate/v2?key=AIzaSyA7lHSVE5ZkBNw_AAOFOioH18eDNLZXjis")
    fun getTranslationData(
        @Body map: Map<String, String>,
        @Header("Referer") baseUrl: String
    ): Observable<TranslationObject>

}