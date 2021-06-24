package com.kkhura.hiltexample.dashboard.user.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kkhura.hiltexample.dashboard.user.model.User
import com.kkhura.hiltexample.dashboard.user.reprository.UserReprository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userReprository: UserReprository,
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val userList = MutableLiveData<List<User>>()

    fun fetchUsers() {
        compositeDisposable.add(
            userReprository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userData ->
                    if (userData.data.isNotEmpty()) {
                        userList.value = userData.data
                    }
                }, { throwable ->
                    throwable.stackTrace
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}