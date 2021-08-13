package com.nadji.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseMovieTrailer(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("results")
    val results: List<ResultsItemTrailer>,
)

data class ResultsItemTrailer(

    @field:SerializedName("key")
    val key: String,
)
