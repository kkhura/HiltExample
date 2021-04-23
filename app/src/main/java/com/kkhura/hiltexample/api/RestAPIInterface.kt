package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.User
import com.workwin.aurora.tanslation.model.TranslationObject
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