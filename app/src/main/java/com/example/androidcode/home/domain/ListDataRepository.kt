package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse

interface ListDataRepository {
    suspend fun getListData(): ListResponse
}