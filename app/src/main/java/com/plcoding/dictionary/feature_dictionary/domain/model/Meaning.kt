package com.plcoding.dictionary.feature_dictionary.domain.model

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val partOfSpeech: String?,
    val definitions: List<Definition>?
)
