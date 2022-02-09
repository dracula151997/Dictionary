package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.plcoding.dictionary.feature_dictionary.domain.model.Phonetic

data class PhoneticDto(
    @SerializedName("text")
    @Expose val text: String?,
    @SerializedName("audio")
    @Expose val audio: String?
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(text.orEmpty(), audio.orEmpty())
    }
}