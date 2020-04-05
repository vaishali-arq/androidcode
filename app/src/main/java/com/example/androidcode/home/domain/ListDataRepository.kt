package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import com.example.androidcode.home.domain.data.ResultWrapper

interface ListDataRepository {
    suspend fun getListData(): ResultWrapper<ListResponse>
}