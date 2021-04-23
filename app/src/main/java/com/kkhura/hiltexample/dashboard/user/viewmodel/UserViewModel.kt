package com.kkhura.hiltexample.dashboard.user.viewmodel

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.user.reprository.UserReprository
import dagger.hilt.android.qualifiers.ActivityContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserViewModel @ViewModelInject constructor(
    private val userReprository: UserReprository,
    @ActivityContext private val context: Context,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val userResponse = MutableLiveData<String>()

    fun fetchUsers() {
        compositeDisposable.add(
            userReprository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ body ->
                    Log.d("TAg", context.getString(R.string.activity_context))
                    userResponse.value = body.toString()
                }, { throwable ->
                    userResponse.value = throwable.toString()
                })
        )
    }
}