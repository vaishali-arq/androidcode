package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import retrofit2.http.GET

/**
 * ListApiService is API interface for retrofit call
 */
interface ListApiService {
    @GET("facts.json")
    suspend fun getListData(): ListResponse
}