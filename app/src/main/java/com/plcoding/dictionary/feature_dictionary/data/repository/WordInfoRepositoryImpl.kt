package com.plcoding.dictionary.feature_dictionary.data.repository

import android.util.Log
import com.plcoding.dictionary.core.utils.Resource
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDao
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getCachedWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfos))

        try {
            val remoteWorkApi = api.getWorkInfo(word)
            dao.deleteWordInfos(remoteWorkApi.map { it.word!! })
            dao.insertWordInfo(remoteWorkApi.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error("Oops! Something went error", data = wordInfos))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    "Couldn't reach to server. Check your internet connection",
                    wordInfos
                )
            )
        }

        val newWordInfos = dao.getCachedWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}