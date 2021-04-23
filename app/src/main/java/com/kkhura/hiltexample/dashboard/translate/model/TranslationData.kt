package com.workwin.aurora.tanslation.model

import com.google.gson.annotations.SerializedName

data class TranslationData(@SerializedName("translations") val translationsList: List<Translations>)