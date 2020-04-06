package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper

class FactsUseCase {
    private val factsRepository: FactsRepository = FactsRepositoryImpl()

    suspend fun callWebservice(): ResultWrapper<ListResponse> = factsRepository.getListData()
}