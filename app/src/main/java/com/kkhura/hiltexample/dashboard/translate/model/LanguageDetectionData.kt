package com.kkhura.hiltexample.dashboard.translate.model

import com.google.gson.annotations.SerializedName

data class LanguageDetectionData(@SerializedName("data") val languageData: DetectionModel)