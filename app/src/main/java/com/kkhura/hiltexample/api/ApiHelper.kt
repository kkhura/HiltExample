package com.kkhura.hiltexample.api

import com.kkhura.hiltexample.dashboard.translate.model.TranslationObject
import com.kkhura.hiltexample.dashboard.user.model.UserList
import io.reactivex.Observable

interface ApiHelper {
    fun getUsers(): Observable<UserList>

    fun getTranslationData(
        map: Map<String, String>,
        baseUrl: String
    ): Observable<TranslationObject>
}