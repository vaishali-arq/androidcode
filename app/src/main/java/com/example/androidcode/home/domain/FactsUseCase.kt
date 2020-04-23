package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper
import javax.inject.Inject

class FactsUseCase @Inject constructor(private val factsRepository: FactsRepository){
    suspend fun getListData(): ResultWrapper<ListResponse> = factsRepository.getListData()
}