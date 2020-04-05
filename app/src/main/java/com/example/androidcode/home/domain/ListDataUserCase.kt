package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper

class ListDataUserCase {
    private val listDataRepository: ListDataRepository = ListDataRepositoryImpl()

    suspend fun callWebservice(): ResultWrapper<ListResponse> = listDataRepository.getListData()
}