package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.network.RetrofitService

class ListDataRepositoryImpl : ListDataRepository {
    private val retrofitService = RetrofitService()

    override suspend fun getListData(): ListResponse = retrofitService.apiInterface.getListData()
}
