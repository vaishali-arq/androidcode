package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper

class FactsUseCase {
    private val factsRepository: FactsRepository = FactsRepositoryImpl()
    suspend fun getListData(): ResultWrapper<ListResponse> = factsRepository.getListData()
}