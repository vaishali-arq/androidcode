package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import retrofit2.http.GET

/**
 * FactsApiService is API interface for retrofit call
 */
interface FactsApiService {
    @GET("facts.json")
    suspend fun getFacts(): ListResponse
}