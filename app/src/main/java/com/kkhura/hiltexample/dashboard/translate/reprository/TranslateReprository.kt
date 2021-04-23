package com.kkhura.hiltexample.dashboard.translate.reprository

import com.kkhura.hiltexample.di.qualifier.AppQualifier
import com.kkhura.hiltexample.api.ApiHelper
import javax.inject.Inject

class TranslateReprository @Inject constructor(private val apiHelper: ApiHelper) {

    @AppQualifier
    @Inject
    lateinit var applicationString: String

    fun getTranslationData(
        newMap: HashMap<String, String>,
        baseUrl: String
    ) =  apiHelper.getTranslationData(newMap, baseUrl)

}