package com.nadji.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(

    @SerializedName("genres")
    val genres: List<GenresTvItem>,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("vote_average")
    val vote_average: Double,
)

data class GenresTvItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,
)
