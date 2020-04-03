package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse

class ListDataUserCase {
    private val listDataRepository: ListDataRepository = ListDataRepositoryImpl()

    suspend fun callWebservice(): ListResponse = listDataRepository.getListData()
}