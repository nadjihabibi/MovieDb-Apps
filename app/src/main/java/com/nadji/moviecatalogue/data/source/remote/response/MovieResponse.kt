package com.nadji.moviecatalogue.data.source.remote

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val results: List<ResultsItem>,

    @SerializedName("total_results")
    val totalResults: Int,
)

data class ResultsItem(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("vote_average")
    val vote_average: Double,
)

