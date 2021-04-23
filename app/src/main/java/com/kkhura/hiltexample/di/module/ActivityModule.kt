package com.github.aakira.hilt.di.module

import android.content.Context
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.di.qualifier.ActivityQualifier
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @ActivityQualifier
    @Provides
    fun provideActivitySting(@ActivityContext context: Context ): String {
        return context.getString(R.string.activity_context)
    }
}