package com.kkhura.hiltexample.dashboard.translate.view

import android.content.Context
import com.kkhura.hiltexample.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SinglentonObject @Inject constructor(@ApplicationContext val context: Context) {
    fun getString() = context.getString(R.string.app_context)
}