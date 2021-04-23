package com.kkhura.hiltexample.di.module

import android.content.Context
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {
    @FragmentQualifier
    @Provides
    fun provideFragmentSting(@ActivityContext context: Context ): String {
        return context.getString(R.string.fragment_context)
    }
}
