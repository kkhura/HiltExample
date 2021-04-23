package com.kkhura.hiltexample.api

import com.kkhura.hiltexample.dashboard.user.model.User
import com.kkhura.hiltexample.dashboard.translate.model.TranslationObject
import io.reactivex.Observable

interface ApiHelper {
    fun getUsers(): Observable<List<User>>

    fun getTranslationData(
        map: Map<String, String>,
        baseUrl: String
    ): Observable<TranslationObject>
}