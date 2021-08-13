package com.nadji.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseTvTrailer(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("results")
    val results: List<ResultsItemTvTrailer>,
)

data class ResultsItemTvTrailer(

    @field:SerializedName("key")
    val key: String,
)
