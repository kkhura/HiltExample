package com.kkhura.hiltexample.dashboard.translate.model

import com.google.gson.annotations.SerializedName
import com.kkhura.hiltexample.dashboard.translate.model.DetectionModel

data class LanguageDetectionData(@SerializedName("data") val languageData: DetectionModel)