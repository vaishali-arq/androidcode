package com.example.androidcode.home.presentation.data

import com.example.androidcode.home.domain.data.ListResponse

data class ListResultView (
    val success: ListResponse? = null,
    val error: Int? = null,
    var errorMsg: String? = null
)