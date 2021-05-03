package com.kkhura.hiltexample.dashboard.translate.viewmodel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kkhura.hiltexample.dashboard.translate.reprository.TranslateReprository
import com.kkhura.hiltexample.di.qualifier.AppQualifier
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TranslateViewModel @ViewModelInject constructor(
    private val translateReprository: TranslateReprository,
    @Assisted private val savedStateHandle: SavedStateHandle,
    @AppQualifier val applicationString: String
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val userResponse = MutableLiveData<String>()

    fun fetchTranslation(
        newMap: HashMap<String, String>,
        baseUrl: String
    ) {

        Log.d("Log", "Application string :$applicationString")
        compositeDisposable.add(
            translateReprository
                .getTranslationData(newMap, baseUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ body ->
                    userResponse.value = body.toString()
                }, { throwable ->
                    userResponse.value = throwable.toString()
                })
        )
    }
}