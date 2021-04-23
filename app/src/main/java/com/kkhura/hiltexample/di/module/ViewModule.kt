package com.kkhura.hiltexample.di.module

import android.content.Context
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.di.qualifier.ActivityQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ViewComponent::class)
object ViewModule {
    @ActivityQualifier
    @Provides
    fun provideActivitySting(@ActivityContext context: Context ): String {
        return context.getString(R.string.activity_context)
    }
}
