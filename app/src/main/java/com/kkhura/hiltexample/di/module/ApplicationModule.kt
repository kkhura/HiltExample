package com.github.aakira.hilt.di.module

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kkhura.hiltexample.BuildConfig
import com.kkhura.hiltexample.R
import com.kkhura.hiltexample.dashboard.translate.view.SinglentonObject
import com.kkhura.hiltexample.di.qualifier.AppQualifier
import com.kkhura.hiltexample.di.qualifier.RetrofitQualifier
import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.api.ApiHelperImpl
import com.mindorks.framework.mvvm.data.api.RestAPIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @AppQualifier
    @Provides
    fun provideApplicationString(@ApplicationContext context: Context): String {
        return context.getString(R.string.app_context)
    }

    @Provides
    fun provideBaseUrl() = "https://5e510330f2c0d300147c034c.mockapi.io"

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GOOGLE_BASE_URL

    @GOOGLE_BASE_URL
    @Provides
    fun provideGoogleBaseUrl() = "https://translation.googleapis.com/"

    @RetrofitQualifier
    @Provides
    @Singleton
    fun provideRetrofitGoogleUrl(
        okHttpClient: OkHttpClient,
        @GOOGLE_BASE_URL BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
//            .baseUrl("https://translation.googleapis.com/")
            .client(okHttpClient)
            .build()

    /*@Provides
    @Singleton
    fun provideTranslateApiService(@RetrofitQualifier retrofit: Retrofit): RestAPIInterface =
        retrofit.create(RestAPIInterface::class.java)

    @Provides
    @Singleton
    fun provideTranslateApiHelper(@RetrofitQualifier apiHelper: TranslateApiHelperImpl): TranslateApiHelper = apiHelper*/


    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): RestAPIInterface =
        retrofit.create(RestAPIInterface::class.java)

    @RetrofitQualifier
    @Provides
    @Singleton
    fun provideGoogleApiService(@RetrofitQualifier retrofit: Retrofit): RestAPIInterface =
        retrofit.create(RestAPIInterface::class.java)

    @Provides
    @Singleton
    fun provideSingletonObject(@ApplicationContext context: Context): SinglentonObject =
        SinglentonObject((context))
}
