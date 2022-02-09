package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    @SerializedName("partOfSpeech")
    @Expose val partOfSpeech: String?,
    @SerializedName("definitions")
    @Expose val definitions: List<DefinitionDto>
) {
    fun toMeaning(): Meaning {
        return Meaning(
            partOfSpeech = partOfSpeech,
            definitions = definitions.map { it.toDefinition() }
        )
    }
}