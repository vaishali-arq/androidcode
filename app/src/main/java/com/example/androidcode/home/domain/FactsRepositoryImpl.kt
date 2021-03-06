package com.example.androidcode.home.domain

import com.example.androidcode.config.APIConstant.Companion.KEY_FACTS_DATA
import com.example.androidcode.datasource.FactsSharedPreference
import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper
import com.example.androidcode.home.domain.data.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(private val factsApiService: FactsApiService) :
    FactsRepository {
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend override fun getListData(): ResultWrapper<ListResponse> {
        var listResponse: ResultWrapper<ListResponse>
        var listDataFromPreference: ListResponse?
        listDataFromPreference = FactsSharedPreference.get<ListResponse>(KEY_FACTS_DATA)

        if (listDataFromPreference != null) {
            listResponse = ResultWrapper.Success(listDataFromPreference)
        } else {
            listResponse = getDataFromServer()
        }
        return listResponse
    }

    override suspend fun getDataFromServer(): ResultWrapper<ListResponse> {
        var response = safeApiCall(dispatcher) {
            factsApiService.getFacts()
        }
        if (response is ResultWrapper.Success) {
            FactsSharedPreference.put(response.value, KEY_FACTS_DATA)
        }
        return response
    }
}
