package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper
import com.example.androidcode.home.domain.data.safeApiCall
import com.example.androidcode.network.NetworkService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class FactsRepositoryImpl : FactsRepository {
    private val retrofitService = NetworkService()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getListData(): ResultWrapper<ListResponse> {
        return safeApiCall(dispatcher) {
            retrofitService.apiInterface.getFacts()
        }
    }
}
