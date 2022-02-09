package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.plcoding.dictionary.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    @SerializedName("definition")
    @Expose val definition: String?,
    @SerializedName("example")
    @Expose val example: String?,
    @SerializedName("synonyms")
    @Expose val synonyms: List<String>?,
    @SerializedName("antonyms")
    @Expose val antonyms: List<Any>?
) {
    fun toDefinition(): Definition {
        return Definition(
            definition, example, synonyms, antonyms
        )
    }
}