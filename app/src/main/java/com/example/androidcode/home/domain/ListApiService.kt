package com.example.androidcode.home.domain

import com.example.androidcode.home.domain.data.ListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ListApiService {
    @GET("facts.json")
    suspend fun getListData() : ListResponse
}