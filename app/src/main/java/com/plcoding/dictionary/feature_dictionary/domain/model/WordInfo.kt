package com.plcoding.dictionary.feature_dictionary.domain.model

data class WordInfo(
    val word: String?,
    val phonetic: String?,
    val origin: String?,
    val meanings: List<Meaning>?,
    val phonetics: List<Phonetic>?
)