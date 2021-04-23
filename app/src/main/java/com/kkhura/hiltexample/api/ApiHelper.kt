package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.User
import com.workwin.aurora.tanslation.model.TranslationObject
import io.reactivex.Observable

interface ApiHelper {
    fun getUsers(): Observable<List<User>>

    fun getTranslationData(
        map: Map<String, String>,
        baseUrl: String
    ): Observable<TranslationObject>
}