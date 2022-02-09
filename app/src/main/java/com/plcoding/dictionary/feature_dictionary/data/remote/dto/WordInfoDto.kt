package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    @SerializedName("word")
    @Expose val word: String?,
    @SerializedName("phonetic")
    @Expose val phonetic: String?,
    @SerializedName("phonetics")
    @Expose val phonetics: List<PhoneticDto>?,
    @SerializedName("origin")
    @Expose val origin: String?,
    @SerializedName("meanings")
    @Expose val meanings: List<MeaningDto>?
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word,
            phonetic,
            origin,
            meanings?.map { it.toMeaning() },
            phonetics?.map { it.toPhonetic() }
        )
    }

    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            word.orEmpty(),
            phonetic.orEmpty(),
            origin.orEmpty(),
            meanings = meanings?.map { it.toMeaning() } ?: emptyList(),
            phonetics = phonetics?.map { it.toPhonetic() } ?: emptyList()
        )
    }
}