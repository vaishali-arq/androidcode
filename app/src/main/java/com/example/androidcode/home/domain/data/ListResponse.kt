package com.example.androidcode.home.domain.data

import com.google.gson.annotations.SerializedName

data class ListResponse (
    @SerializedName("title")
    val title : String?,
    @SerializedName("rows")
    val listRow : List<ListRow>
)

data class ListRow(
    @SerializedName("title")
    val title : String?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("imageHref")
    val imageHref : String?
)