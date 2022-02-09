package com.plcoding.dictionary.feature_dictionary.domain.model

data class Definition(
    val definition: String?,
    val example: String?,
    val synonyms: List<String>?,
    val antonyms: List<Any>?
)
